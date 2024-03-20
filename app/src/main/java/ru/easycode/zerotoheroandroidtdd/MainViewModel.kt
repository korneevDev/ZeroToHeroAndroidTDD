package ru.easycode.zerotoheroandroidtdd

import android.widget.TextView
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var state: String = "Hello World!"
    fun changeState(state: String){
        this.state = state
    }

    fun setState(textView: TextView){
        textView.text = state
    }
}