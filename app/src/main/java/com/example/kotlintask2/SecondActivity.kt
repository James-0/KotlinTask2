package com.example.kotlintask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val bundle = intent.getBundleExtra("Bundle")
        val people = bundle?.getParcelable<Object>("extra_object")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.textView2) as TextView
        val textView2 = findViewById<TextView>(R.id.textView3) as TextView

        textView.text = people?.title
        textView2.text = people?.description

    }
}
