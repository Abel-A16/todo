package com.example.todo

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_create_card.*
import android.content.Intent
import android.graphics.Color
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_card.create_priority
import kotlinx.android.synthetic.main.activity_create_card.create_title
import kotlinx.android.synthetic.main.activity_create_card.save_button
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.view.*


class detailFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back_button.setOnClickListener {
            dismiss()
        }
        high_priority.setOnClickListener {
            changeColor(0)
        }
        medium_priority.setOnClickListener {
            changeColor(1)
        }
        low_priority.setOnClickListener {
            changeColor(2)
        }
        isCancelable=false
    }
    fun SaveData( position: Int) {
        if (create_title.text.toString().trim { it <= ' ' }.isNotEmpty()) {
            DataObject.setData(create_title.text.toString(), position)
            var intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(requireContext(), "Task can not be Empty", Toast.LENGTH_SHORT).show()
        }
    }

    fun changeColor(position: Int) {
        when (position) {
            0 -> change.setBackgroundResource(R.drawable.high)
            1 -> change.setBackgroundResource(R.drawable.medium)
            2 -> change.setBackgroundResource(R.drawable.low)
        }
        SaveData(position)
    }


}