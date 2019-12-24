package com.josancamon19.toolboxtestapp.views.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josancamon19.toolboxtestapp.data.ToolBoxApi
import com.josancamon19.toolboxtestapp.models.AuthRequest
import com.josancamon19.toolboxtestapp.models.AuthResponse
import com.josancamon19.toolboxtestapp.models.Carousel
import kotlinx.coroutines.*
import timber.log.Timber

class MainViewModel : ViewModel() {

    private val jobViewModel: Job = Job()
    private val uiScope: CoroutineScope = CoroutineScope(Dispatchers.Main + jobViewModel)

    private lateinit var authData: AuthResponse

    private val _carouselsResponse = MutableLiveData<List<Carousel>>()
    val carouselsResponse: LiveData<List<Carousel>>
        get() = _carouselsResponse

    init {
        uiScope.launch {
            auth()
            loadData()
        }
    }

    private suspend fun auth() {
        withContext(Dispatchers.Main) {
            val response = ToolBoxApi.retrofitService.authAsync(AuthRequest())
            try {
                authData = response.await()
                Timber.d(authData.toString())
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    private suspend fun loadData() {
        withContext(Dispatchers.Main) {
            val response =
                ToolBoxApi.retrofitService.getCarouselsAsync("${authData.type} ${authData.token}")
            try {
                _carouselsResponse.value = response.await()
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}