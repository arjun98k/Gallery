package com.example.resumelist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.resumelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userArrayList: ArrayList<user>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = arrayOf("Arjun","Aditya","rohit","mohit","sahil")
        val lastMsg = arrayOf("Hey yeah I am good","Hey yeah I am fine","Hey yeah I am not feeling well","Hey yeah I am good","Hey yeah I am good")
        val lastMsgTime = arrayOf("4:00 PM","5:00 PM","6:00 PM","7:00 PM","9:00 PM")
        val phoneNumber = arrayOf("9876543210","9876543210","9876543210","9876543210","9876543210")
        val imageId = intArrayOf(R.drawable.pic0,R.drawable.pic0,R.drawable.pic0,R.drawable.pic0,R.drawable.pic0)

        userArrayList = ArrayList()
        for (eachIndex in name.indices){
            val user = user(name[eachIndex],lastMsg[eachIndex],lastMsgTime[eachIndex],phoneNumber[eachIndex],imageId[eachIndex])
            userArrayList.add(user)
        }

         val listview = binding.listView
        listview.isClickable = true
        listview.adapter = MyAdapter(this,userArrayList)
    }
}