package com.maxi.genericlistadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _textList = MutableLiveData<List<String>>()
    val textList: LiveData<List<String>> = _textList

    init {
        _textList.value = listOf(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                    " when an unknown printer took a galley of type and scrambled it to make a " +
                    "type specimen book.",
            "It has survived not only five centuries, " +
                    "but also the leap into electronic typesetting, " +
                    "remaining essentially unchanged.",
            "It was popularised in the 1960s with the release of Letraset " +
                    "sheets containing Lorem Ipsum passages, and more " +
                    "recently with desktop publishing software like Aldus " +
                    "PageMaker including versions of Lorem Ipsum.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "Nunc rhoncus lectus a molestie suscipit.",
            "Sed a nibh luctus massa mollis vehicula vel ac massa.",
            "Curabitur in felis quis orci dignissim facilisis.",
            "Curabitur vitae ligula sit amet orci maximus blandit."
        )
    }
}