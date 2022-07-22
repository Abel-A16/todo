package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_create_card.*
import android.content.Intent


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
        save_button.setOnClickListener {
            if(create_title.text.toString().trim{it<=' '}.isNotEmpty()
                &&create_priority.text.toString().trim{it<=' '}.isNotEmpty()){
                var title=create_title.getText().toString()
                var priority=create_priority.getText().toString()
                DataObject.setData(title, priority)}
            var intent = Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)
        }
    }



    override fun onDestroy() {

        super.onDestroy()

    }

    private fun save() {
        if(create_title.text.toString().trim{it<=' '}.isNotEmpty()
            &&create_priority.text.toString().trim{it<=' '}.isNotEmpty()){
            var title=create_title.getText().toString()
            var priority=create_priority.getText().toString()
            DataObject.setData(title, priority)
            var intent = Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)
        }
    }
}