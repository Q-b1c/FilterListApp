package com.example.filter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        var listofNumber: MutableList<Int> = mutableListOf()
        var listofEvenNumber: MutableList<Int> = mutableListOf()
        var listofOddNumber: MutableList<Int> = mutableListOf()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editTextNumber)
        val radioAll = findViewById<RadioButton>(R.id.radioButton)
        val adapter = RecyclerAdapter(listofNumber)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val radioEven = findViewById<RadioButton>(R.id.radioEven)
        val radioOdd = findViewById<RadioButton>(R.id.radioOdd)
        val Button = findViewById<Button>(R.id.button)
        Button.setOnClickListener {
            if (!editText.text.isEmpty()) {
                listofNumber.add(editText.text.toString().toIntOrNull() ?: 0)
            }
            listofEvenNumber = checkEven(listofNumber)
            listofOddNumber = checkOdd(listofNumber)
            if (radioAll.isChecked) {
                adapter.insertList(listofNumber)
                adapter.notifyDataSetChanged()
            }
            if (radioOdd.isChecked) {
                adapter.insertList(listofOddNumber)
                adapter.notifyDataSetChanged()
            }
            if (radioEven.isChecked) {
                adapter.insertList(listofEvenNumber)
                adapter.notifyDataSetChanged()
            }

        }
        val radioGroup = findViewById<RadioGroup>(R.id.Radio)
        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton -> {
                    adapter.insertList(listofNumber)
                    adapter.notifyDataSetChanged()
                }
                R.id.radioEven -> {
                    adapter.insertList(listofEvenNumber)
                    adapter.notifyDataSetChanged()
                }
                R.id.radioOdd -> {
                    adapter.insertList(listofOddNumber)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    fun checkOdd(l: MutableList<Int>): MutableList<Int> {
        var Odd: MutableList<Int> = mutableListOf()
        for (i in 0..l.size - 1) {
            if (l[i] % 2 != 0) {
                Odd.add(l[i])
            }
        }
        return Odd
    }

    fun checkEven(l: MutableList<Int>): MutableList<Int> {
        var Even: MutableList<Int> = mutableListOf()
        for (i in 0..l.size - 1) {
            if (l[i] % 2 == 0) {
                Even.add(l[i])
            }
        }
        return Even
    }


}