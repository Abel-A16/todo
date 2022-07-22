package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener {
            var dialog = detailFragment()
            dialog.show(supportFragmentManager,dialog.tag)
        }
        deleteAll.setOnClickListener {
            DataObject.deleteAll()
            setRecycler()
        }
        setRecycler()
    }



    private fun save() {
        if(create_title.text.toString().trim{it<=' '}.isNotEmpty()
            &&create_priority.text.toString().trim{it<=' '}.isNotEmpty()){
            var title=create_title.getText().toString()
            var priority=create_priority.getText().toString()
            DataObject.setData(title, priority)}
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


    fun setRecycler(){
        recycler_view.adapter=Adapter(DataObject.getAllData())
        recycler_view.layoutManager=LinearLayoutManager(this)
    }
}