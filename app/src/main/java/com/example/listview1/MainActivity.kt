package com.example.listview1

import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listview1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listview = binding.listview1

        var taskList = arrayListOf<String>()
        taskList.add("attend exam")
        taskList.add("complete project")
        taskList.add("complete assignment")
        taskList.add("bazar se bhendi")
        taskList.add("work on resume")
        taskList.add("attend exam")
        taskList.add("improve internet presence")
        taskList.add("complete project")
        taskList.add("complete assignment")
        taskList.add("bazar se bhendi")
        taskList.add("work on resume")
        taskList.add("attend exam")
        taskList.add("improve internet presence")
        taskList.add("complete project")
        taskList.add("complete assignment")
        taskList.add("bazar se bhendi")
        taskList.add("work on resume")
        taskList.add("attend exam")
        taskList.add("improve internet presence")
        taskList.add("complete project")
        taskList.add("complete assignment")
        taskList.add("bazar se bhendi")
        taskList.add("work on resume")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        listview.adapter = arrayAdapter

        listview.setOnItemClickListener { parent, view, position, id ->
            val builder = androidx.appcompat.app.AlertDialog.Builder(this)
            builder.setTitle("Task Selected")
            builder.setMessage(" ${taskList[position]}")
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        }




    }
}