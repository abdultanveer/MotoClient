package com.example.motoclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motoclient.databinding.ActivityMainBinding
import com.example.motoclient.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnContact.setOnClickListener {
           // sendContact()
            getShowContact()
        }
    }

    private fun getShowContact() {
        var con = binding.etContact.text.toString()
        binding.tvCon.text = con
    }

    private fun sendContact() {
        var phno = binding.etContact.text.toString()
        var dataIntent = Intent()
        dataIntent.putExtra("cont", phno)
        setResult(RESULT_OK,dataIntent)
        finish()
    }


}