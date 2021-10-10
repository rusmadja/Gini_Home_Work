package com.reouven.app_using_api_in_view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reouven.app_using_api_in_view.model.Numbers
import com.reouven.app_using_api_in_view.model.network.NumberApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // The internal MutableLiveData that stores the numbers of the most recent request
    private val _numbers = MutableLiveData<Numbers>()

    // The external immutable LiveData for the request numbers
    val numbers: LiveData<Numbers> = _numbers

    /**
     * Call getNumbers() on init so we can display numbers immediately.
     */
    init {
        getNumbers()
    }

    /**
     * Gets Numbers list from the API Retrofit service and updates the
     * [Numbers] [List] [LiveData].
     */
    private fun getNumbers(): MutableLiveData<Numbers> {

        viewModelScope.launch {
            try {
                val result =NumberApi.retrofitService.getNumbers()
                _numbers.value = result

                Log.d("retrofit response", "Success: ${result} ")

            } catch (e: Exception) {

                _numbers.value = Numbers(listOf())
                Log.d("retrofit response", "Failure: ${e.message}")
            }
        }
        return _numbers
    }
}
