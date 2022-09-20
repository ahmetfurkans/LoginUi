package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dag.odev2fmss.databinding.ActivityWelcomeBackBinding
import java.text.Normalizer

class WelcomeBackActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBackBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_back)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome_back)
        launcher()
    }

    // Create all OnClick Functions
    private fun launcher() {
        // Intent to previous page
        binding.backIcon.setOnClickListener {
            val intent = Intent(this, GetStartedActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }

        // Intent to create account page
        binding.createAccount.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }

        // Sign in
        binding.welcomebackLogin.setOnClickListener(View.OnClickListener {
            val username = binding.welcomebackUsername
            val password = binding.welcomebackPassword

            FormHelper.editTextTintChange(username, this)
            FormHelper.editTextTintChange(password, this)
            FormHelper.isFormEmpty(this, username.text, password.text)

        })
    }
}