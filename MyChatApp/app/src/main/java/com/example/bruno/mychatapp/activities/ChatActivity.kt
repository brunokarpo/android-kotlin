package com.example.bruno.mychatapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.bruno.mychatapp.R
import com.example.bruno.mychatapp.model.FriendlyMessage
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_settings.view.*
import kotlinx.android.synthetic.main.custom_bar_image.view.*

class ChatActivity : AppCompatActivity() {

    var userId: String? = null
    var mFirebaseDatabaseReference: DatabaseReference? = null
    var mFirebaseUser: FirebaseUser? = null

    var mLinearLayoutManager: LinearLayoutManager? = null
    var mFirebaseAdapter: FirebaseRecyclerAdapter<FriendlyMessage, MessageViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        mFirebaseUser = FirebaseAuth.getInstance().currentUser

        if (intent.extras != null) {
            userId = intent.extras.getString("userId")
        }

        mLinearLayoutManager = LinearLayoutManager(this)
        mLinearLayoutManager!!.stackFromEnd = true

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowCustomEnabled(true)

        var inflater = this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var actionBarView = inflater.inflate(R.layout.custom_bar_image, null)
        actionBarView.customBarName.text = intent.extras.getString("name")
        Picasso.get()
                .load(intent.extras.getString("profile"))
                .placeholder(R.drawable.profile_img)
                .into(actionBarView.customBarCircleImage)

        supportActionBar!!.customView = actionBarView


        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().reference

        mFirebaseAdapter = object : FirebaseRecyclerAdapter<FriendlyMessage, MessageViewHolder>(
                FriendlyMessage::class.java,
                R.layout.item_message,
                MessageViewHolder::class.java,
                mFirebaseDatabaseReference!!.child("messages")) {
            override fun populateViewHolder(viewHolder: MessageViewHolder, friendlyMessage: FriendlyMessage?, position: Int) {

                if (friendlyMessage != null) {
                    viewHolder.bindView(friendlyMessage!!)

                    var currentUserId = mFirebaseUser!!.uid

                    var isMe: Boolean = friendlyMessage!!.id.equals(currentUserId)

                    if (isMe) {
                        viewHolder.profileImageViewRight!!.visibility = View.VISIBLE
                        viewHolder.profileImageView!!.visibility = View.GONE
                        viewHolder.messangerTextView!!.gravity = (Gravity.CENTER_VERTICAL or Gravity.RIGHT)
                        viewHolder.messageTextView!!.gravity = (Gravity.CENTER_VERTICAL or Gravity.RIGHT)

                        mFirebaseDatabaseReference!!.child("Users")
                                .child(currentUserId)
                                .addValueEventListener(object : ValueEventListener{
                                    override fun onDataChange(dataSnapshot: DataSnapshot?) {

                                        var imageUrl = dataSnapshot!!.child("thumb_image").value.toString()
                                        var displayName = dataSnapshot!!.child("display_name").value.toString()

                                        viewHolder.messangerTextView!!.text = "I wrote..."

                                        Picasso.get()
                                                .load(imageUrl.toString())
                                                .placeholder(R.drawable.profile_img)
                                                .into(viewHolder.profileImageViewRight)

                                    }

                                    override fun onCancelled(error: DatabaseError?) {

                                    }
                                })

                    } else {
                        viewHolder.profileImageViewRight!!.visibility = View.GONE
                        viewHolder.profileImageView!!.visibility = View.VISIBLE
                        viewHolder.messangerTextView!!.gravity = (Gravity.CENTER_VERTICAL or Gravity.LEFT)
                        viewHolder.messageTextView!!.gravity = (Gravity.CENTER_VERTICAL or Gravity.LEFT)

                        mFirebaseDatabaseReference!!.child("Users")
                                .child(userId)
                                .addValueEventListener(object : ValueEventListener{
                                    override fun onDataChange(dataSnapshot: DataSnapshot?) {

                                        var imageUrl = dataSnapshot!!.child("thumb_image").value.toString()
                                        var displayName = dataSnapshot!!.child("display_name").value.toString()

                                        viewHolder.messangerTextView!!.text = "$displayName wrote..."

                                        Picasso.get()
                                                .load(imageUrl.toString())
                                                .placeholder(R.drawable.profile_img)
                                                .into(viewHolder.profileImageView)

                                    }

                                    override fun onCancelled(error: DatabaseError?) {

                                    }
                                })
                    }
                }

            }
        }

        message_recycler_view_id.layoutManager = mLinearLayoutManager
        message_recycler_view_id.adapter = mFirebaseAdapter


        sendButton.setOnClickListener {
            if (!intent.extras.getString("name").equals("")) {
                var currentUsername = intent.extras.getString("name")
                var mCurrentUserId = mFirebaseUser!!.uid

                var friendlyMessage = FriendlyMessage(mCurrentUserId,
                        messageEdt.text.toString().trim(),
                        currentUsername.toString().trim())

                mFirebaseDatabaseReference!!.child("messages").push().setValue(friendlyMessage)

                messageEdt.setText("")
            }
        }
    }


    class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var messageTextView: TextView? = null
        var messangerTextView: TextView? = null
        var profileImageView: CircleImageView? = null
        var profileImageViewRight: CircleImageView? = null

        fun bindView(friendlyMessage: FriendlyMessage) {
            messageTextView = itemView.findViewById(R.id.message_text_view_id)
            messangerTextView = itemView.findViewById(R.id.messanger_text_view_id)
            profileImageView = itemView.findViewById(R.id.message_image_view_id)
            profileImageViewRight = itemView.findViewById(R.id.message_image_view_right_id)

            messageTextView!!.text = friendlyMessage.text
            messangerTextView!!.text = friendlyMessage.name
        }
    }
}
