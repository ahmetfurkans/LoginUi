package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dag.odev2fmss.databinding.ActivityGetStartedBinding

class GetStartedActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGetStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_get_started)
        launcher()

    }
    // Create all onClick Functions
    private fun launcher() {
        // Intent to welcomeback page
        binding.join.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, WelcomeBackActivity::class.java)
            startActivity(intent)
        })
    }
}