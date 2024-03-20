package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy{
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private var isDisplay = View.VISIBLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.titleTextView)

        viewModel.setState(textView)
        findViewById<Button>(R.id.changeButton).setOnClickListener {
            viewModel.changeState("I am an Android Developer!")
            viewModel.setState(textView)
        }

        findViewById<Button>(R.id.hideButton).setOnClickListener {
            isDisplay = View.INVISIBLE
            textView.visibility = isDisplay
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isDisplay = savedInstanceState.getInt("visibility")
        findViewById<TextView>(R.id.titleTextView).visibility = isDisplay
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("visibility", isDisplay)
    }
}