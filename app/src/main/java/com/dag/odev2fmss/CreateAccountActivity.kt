package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dag.odev2fmss.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_account)
        launcher()
    }

    // Create all onClick Functions
    private fun launcher() {
        // Intent to previous page
        binding.createaccountBackIcon.setOnClickListener {
            val intent = Intent(this, WelcomeBackActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }

        // Sign up
        binding.createaccountSignup.setOnClickListener {
            val username = binding.createaccountUsername
            val password = binding.createaccountPassword
            val email = binding.createaccountEmail

            FormHelper.editTextTintChange(username, this)
            FormHelper.editTextTintChange(password, this)
            FormHelper.editTextTintChange(email, this)
            FormHelper.isFormEmpty(this, username.text, password.text, email.text)
        }
    }
}