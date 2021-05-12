package com.maxi.genericlistadapter

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maxi.genericlistadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.rvText.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = object : BaseListAdapter<Any>() {
                override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder =
                    BaseViewHolder.create(view, viewType)

                override fun getLayoutId(position: Int, obj: Any): Int {
                    return when (obj) {
                        is String -> R.layout.row_item_text
                        else -> R.layout.row_item_text
                    }
                }
            }
        }
        _binding.rvText.layoutManager = LinearLayoutManager(this)

        _binding.rvText.adapter = object : BaseListAdapter<Any>() {
            override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder =
                BaseViewHolder.create(view, viewType)

            override fun getLayoutId(position: Int, obj: Any): Int =
                R.layout.row_item_text
        }.apply {
            submitList(
                viewModel.textList.value
            )
        }
    }
}