package com.example.motoclient

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Messenger
import android.util.Log
import com.example.motoclient.databinding.ActivityMainBinding
import com.example.motodemo.IAddMoto

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var mService: IAddMoto? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAdd.setOnClickListener {
            bindMyService()
        }
    }

    private fun bindMyService() {
        val intent = Intent("moto.add.service")
        val pack = IAddMoto::class.java.`package`
        intent.setPackage(pack.name)
        bindService(intent,connection, BIND_AUTO_CREATE)
    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, aidlBinder: IBinder?) {
            mService = IAddMoto.Stub.asInterface(aidlBinder)
            var sum = mService?.add(30, 40)
            Log.i("clientActivity", "connected to service--sum is--"+sum)

            binding.tvSum.text = ""+sum

        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }
    }
    }