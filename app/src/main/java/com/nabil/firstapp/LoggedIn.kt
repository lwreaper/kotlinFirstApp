package com.nabil.firstapp

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.logged_in.*
import java.time.LocalDateTime

class LoggedIn : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logged_in)

        val username: String? = intent.getStringExtra("username")
        val password: String? = intent.getStringExtra("password")
        displayInfos.text = "(${username.toString()}) (${password.toString()})"

        changePasswordButton.setOnClickListener {
            when(oldPasswordInput.text.toString()){

//                when old password is matching with the old password
                 password -> {

                    when(newPasswordInput.text.length){

//                        check that the new password is not blank
                        0 -> Toast.makeText(this, "Enter a new password!", Toast.LENGTH_SHORT).show()

//                        set intent and send password in the intent to the front page (main page)
                        else -> {
                            var intent = Intent(this, MainActivity::class.java)
                            intent.putExtra("password", newPasswordInput.text.toString())
                            startActivity(intent)

                            Toast.makeText(this, "Logged Out! Please Log in again!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

//                when old password is not matching
                else -> {

//                    make toast saying that old password is wrong
                    Toast.makeText(this, "Incorrect Old Password!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}

