package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.android.synthetic.main.activity_create_card.create_priority
import kotlinx.android.synthetic.main.activity_create_card.create_title
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.view.*
import kotlin.properties.Delegates

class UpdateCard : AppCompatActivity() {
    var pos by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)

       pos = intent.getIntExtra("id", -1)
        high.setOnClickListener {
            changeColor(0)
        }
        medium.setOnClickListener {
            changeColor(1)
        }
        low.setOnClickListener {
            changeColor(2)
        }
        delete_button.setOnClickListener {
            DataObject.deleteData(pos)
            RestartActivity()
        }

        if (pos != -1) {
            val title = DataObject.getData(pos).title
            create_title.setText(title)
        }

    }

    fun RestartActivity(){
        var intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }


    fun changeColor(position: Int) {
        when (position) {
            0 -> change_priority.setBackgroundResource(R.drawable.high)
            1 -> change_priority.setBackgroundResource(R.drawable.medium)
            2 -> change_priority.setBackgroundResource(R.drawable.low)
        }

        if (pos != -1) {
            val title = DataObject.getData(pos).title
            create_title.setText(title)

            DataObject.updateData(
                pos,
                create_title.text.toString(),
                position
            )
            RestartActivity()
        }

    }
}