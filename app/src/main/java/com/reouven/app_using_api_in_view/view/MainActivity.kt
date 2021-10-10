package com.reouven.app_using_api_in_view.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reouven.app_using_api_in_view.R
import com.reouven.app_using_api_in_view.view.adapter.NumberAdapter
import com.reouven.app_using_api_in_view.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    //Declare the recyclerview who will be initialized with the function initRecyclerView()
    lateinit var recyclerView: RecyclerView

    //Init ViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerview()
    }

    /**
     * Init the [RecyclerView] contained in your [MainActivity]
     */
    private fun initRecyclerview() {
        recyclerView = findViewById(R.id.intRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        //use the viewModel to update the list data of the recycler view using observeForever function
        viewModel.numbers.observeForever {
            recyclerView.adapter = NumberAdapter(it.numbers)
        }
    }
}


