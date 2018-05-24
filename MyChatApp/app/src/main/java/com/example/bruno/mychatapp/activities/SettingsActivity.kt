package com.example.bruno.mychatapp.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.bruno.mychatapp.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.squareup.picasso.Picasso
import com.theartofdev.edmodo.cropper.CropImage
import id.zelory.compressor.Compressor
import kotlinx.android.synthetic.main.activity_settings.*
import java.io.ByteArrayOutputStream
import java.io.File

class SettingsActivity : AppCompatActivity() {


    var mDatabaseReference: DatabaseReference? = null
    var mCurrentUser: FirebaseUser? = null
    var mStorage: StorageReference? = null
    var GALLERY_ID: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        mCurrentUser = FirebaseAuth.getInstance().currentUser
        mStorage = FirebaseStorage.getInstance().reference

        var userUID = mCurrentUser!!.uid

        mDatabaseReference = FirebaseDatabase.getInstance().reference
                .child("Users")
                .child(userUID)

        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot?) {
                var displayName = snapshot!!.child("display_name").value
                var image = snapshot!!.child("image").value.toString()
                var status = snapshot!!.child("status").value
                var thumbnail = snapshot!!.child("thumb_image").value

                settings_status_text_id.text = status.toString()
                settings_display_name.text = displayName.toString()

                if (!image!!.equals("default")) {
                    Picasso.get()
                            .load(image)
                            .placeholder(R.drawable.profile_img)
                            .into(settings_profile_id)
                }
            }

            override fun onCancelled(error: DatabaseError?) {

            }
        })


        settings_text_status_button_id.setOnClickListener {
            var intent = Intent(this, StatusActivity::class.java)
            intent.putExtra("status", settings_status_text_id.text.toString().trim())
            startActivity(intent)
        }

        settings_change_image_button_id.setOnClickListener {
            var galleryIntent = Intent()
            galleryIntent.type = "image/*"
            galleryIntent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(galleryIntent, "SELECT IMAGE"), GALLERY_ID)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode.equals(GALLERY_ID)
                        .and(resultCode.equals(Activity.RESULT_OK))) {
            var image: Uri = data!!.data

            CropImage.activity(image)
                    .setAspectRatio(1, 1)
                    .start(this)
        }

        if (requestCode === CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)

            if (resultCode === Activity.RESULT_OK) {
                val resultUri = result.uri

                var userId = mCurrentUser!!.uid
                var thumbFile = File(resultUri.path)

                var thumbBitmap = Compressor(this)
                        .setMaxWidth(200)
                        .setMaxHeight(200)
                        .setQuality(65)
                        .compressToBitmap(thumbFile)

                var byteArray = ByteArrayOutputStream()
                thumbBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArray)

                var thumbByteArray: ByteArray = byteArray.toByteArray()

                var filePath = mStorage!!.child("chat_profile_images")
                        .child(userId + ".jpg")

                var thumbFilePath = mStorage!!.child("chat_profile_images")
                        .child("thumbs")
                        .child(userId + ".jpg")

                filePath.putFile(resultUri)
                        .addOnCompleteListener{
                    task: Task<UploadTask.TaskSnapshot> ->
                            if (task.isSuccessful) {

                                var downloadUrl = task.result.downloadUrl.toString()

                                var uploadTask: UploadTask = thumbFilePath
                                        .putBytes(thumbByteArray)

                                uploadTask.addOnCompleteListener{
                                    task: Task<UploadTask.TaskSnapshot> ->
                                    if (task.isSuccessful) {
                                        var thumbUrl = task.result.downloadUrl.toString()

                                        var updateObject = hashMapOf<String, Any>()
                                        updateObject.put("image", downloadUrl)
                                        updateObject.put("thumb_image", thumbUrl)


                                        mDatabaseReference!!.updateChildren(updateObject)
                                                .addOnCompleteListener {
                                                    task: Task<Void> ->
                                                    if (task.isSuccessful) {
                                                        Toast.makeText(this, "Profile image saved!", Toast.LENGTH_LONG).show()
                                                    } else {
                                                        Toast.makeText(this, "Profile image doesn't saved!", Toast.LENGTH_LONG).show()
                                                    }
                                                }

                                    } else {

                                    }
                                }

                            }
                }
            }
        }
    }
}
