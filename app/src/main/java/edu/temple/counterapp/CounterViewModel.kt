package edu.temple.counterapp

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    val counterValue = mutableIntStateOf(0)
}