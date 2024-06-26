package com.example.crud_34b.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_34b.R
import com.example.crud_34b.databinding.ActivityForgetBinding
import com.google.firebase.auth.FirebaseAuth

class ForgetActivity : AppCompatActivity() {
    lateinit var forgetBinding: ActivityForgetBinding
    var auth : FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        forgetBinding = ActivityForgetBinding.inflate(layoutInflater)
        setContentView(forgetBinding.root)

        forgetBinding.btnForget.setOnClickListener {
            var email : String = forgetBinding.forgetEmail.text.toString()

            auth.sendPasswordResetEmail(email).
            addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(applicationContext,
                        "Registration success", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,
                        it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}