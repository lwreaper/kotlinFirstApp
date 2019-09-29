package com.nabil.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username: String? = intent.getStringExtra("username")
        var password: String? = intent.getStringExtra("password")

        if (username==null) username = "000"
        if (password==null) password = "000"

        loginButton.setOnClickListener {
//            If both username and password inputs matches their respective username and password
            if(usernameInput.text.toString() == username.toString() && passwordInput.text.toString() == password.toString()){
                logIn(username, password)
            }else{

//                show toast that they are not logged in
                Toast.makeText(this, "Wrong Username/Password!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun logIn(current_username: Any, current_password: Any){

        Log.i("Called", "logIn")
//        log in!
        var nextIntent = Intent(this, LoggedIn::class.java)
        nextIntent.putExtra("username", current_username.toString())
        nextIntent.putExtra("password", current_password.toString())

        startActivity(nextIntent)
    }
}
