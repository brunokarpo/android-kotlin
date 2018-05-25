package com.example.bruno.mychatapp.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.bruno.mychatapp.R
import com.example.bruno.mychatapp.activities.ChatActivity
import com.example.bruno.mychatapp.activities.ProfileActivity
import com.example.bruno.mychatapp.model.User
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class UsersAdapter(databaseQuery: DatabaseReference, var context: Context)
    : FirebaseRecyclerAdapter<User, UsersAdapter.ViewHolder>(
        User::class.java,
        R.layout.user_row,
        ViewHolder::class.java,
        databaseQuery
    ) {

    override fun populateViewHolder(viewHolder: ViewHolder?, model: User?, position: Int) {
        var userId = getRef(position).key

        viewHolder!!.bindView(model!!, context)

        viewHolder.itemView.setOnClickListener {
            var options = arrayOf("Open profile", "Send Message")
            var builder = AlertDialog.Builder(context)
            builder.setTitle("Select Options")
            builder.setItems(options, DialogInterface.OnClickListener { dialog, which ->
                var userName = viewHolder!!.userNameTxt
                var userStatus = viewHolder!!.userStatusTxt
                var profilePic = viewHolder!!.userProfilePicLink

                when(which) {
                    0 -> {
                        var profileIntent = Intent(context, ProfileActivity::class.java)
                        profileIntent.putExtra("userId", userId)
                        context.startActivity(profileIntent)
                    }
                    1 -> {
                        var chatIntent = Intent(context, ChatActivity::class.java)
                        chatIntent.putExtra("userId", userId)
                        chatIntent.putExtra("name", userName)
                        chatIntent.putExtra("status", userStatus)
                        chatIntent.putExtra("profile", profilePic)
                        context.startActivity(chatIntent)
                    }
                    else -> {}
                }
            })

            builder.create().show()
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userNameTxt: String? = null
        var userStatusTxt: String? = null
        var userProfilePicLink: String? = null

        fun bindView(user: User, context: Context){
            var userName = itemView.findViewById<TextView>(R.id.user_row_user_name_text_id)
            var userStatus = itemView.findViewById<TextView>(R.id.user_row_user_status_text_id)
            var userProfilePic = itemView.findViewById<CircleImageView>(R.id.user_row_profile_pic_id)

            userNameTxt = user.display_name
            userStatusTxt = user.status
            userProfilePicLink = user.thumb_image

            userName.text = userNameTxt
            userStatus.text = userStatusTxt

            Picasso.get()
                    .load(userProfilePicLink)
                    .placeholder(R.drawable.profile_img)
                    .into(userProfilePic)
        }
    }
}