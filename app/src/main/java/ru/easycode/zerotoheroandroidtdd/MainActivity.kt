package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var uiState: UiState = UiState.Init
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val counter = Count.Base(2, 4)

        binding.incrementButton.setOnClickListener{
            uiState = uiState.increment(counter)
            uiState.show(binding)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        uiState.saveState(outState, "counter", "isEnabled")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val text = savedInstanceState.getString("counter") ?: "0"
        val isMax = savedInstanceState.getBoolean("isEnabled")

        if(isMax){
            uiState = UiState.Max(text)
            uiState.show(binding)
        } else{
            uiState = UiState.Base(text)
            uiState.show(binding)
        }
    }
}