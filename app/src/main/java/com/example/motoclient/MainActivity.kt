package com.example.motoclient

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.motoclient.databinding.ActivityMainBinding
import com.example.motodemo.IAddMoto


/*
steps
1. enable aidl in buildfeatures of build.gradle [module]
2. select app folder rt click - new - aidl file- name it as IAddMoto
3. in IAddMoto.aidl copy the int add(int a, int b) method from motodemo also change the package to com.ex.motodemo
4. refactor and rename the package name ie within aidl folder the inner folder should be com.example.motodemo
5. add queries tag in the manifest
6. onclick of button create an intent and bind it to the service
 */
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

    override fun onStart() {
        super.onStart()
        val uriSms = Uri.parse("content://sms/inbox")
        val dataCursor : Cursor? = getContentResolver().query(uriSms, null, null, null, null)
        var from = arrayOf("body","address")
        var toTvs = intArrayOf(android.R.id.text1, android.R.id.text2)
        var adapter = SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,
            dataCursor,from,toTvs,0)

        binding.listView.adapter = adapter

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