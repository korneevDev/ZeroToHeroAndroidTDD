package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

interface UiState {

    fun show(binding: ActivityMainBinding)

    fun saveState(bundle: Bundle, keyText: String, keyButton: String)

    fun increment(counter: Count) : UiState

    object Init : UiState {
        override fun show(binding: ActivityMainBinding) {
            binding.countTextView.text = "0"
        }

        override fun saveState(bundle: Bundle, keyText: String, keyButton: String) {
            bundle.putString(keyText, "0")
            bundle.putBoolean(keyButton, false)
        }

        override fun increment(counter: Count): UiState =
            counter.increment("0")
    }

    open class Base(private val text: String) : UiState {
        override fun show(binding: ActivityMainBinding) {
            binding.countTextView.text = text
        }

        override fun saveState(bundle: Bundle, keyText: String, keyButton: String) {
            bundle.putString(keyText, text)
            bundle.putBoolean(keyButton, false)
        }

        override fun increment(counter: Count): UiState =
            counter.increment(text)

    }

    data class Max(private val text: String) : UiState {
        override fun show(binding: ActivityMainBinding) {
            binding.countTextView.text = text
            binding.incrementButton.isEnabled = false
        }

        override fun saveState(bundle: Bundle, keyText: String, keyButton: String) {
            bundle.putString(keyText, text)
            bundle.putBoolean(keyButton, true)
        }

        override fun increment(counter: Count): UiState =
            counter.increment(text)

    }

}
