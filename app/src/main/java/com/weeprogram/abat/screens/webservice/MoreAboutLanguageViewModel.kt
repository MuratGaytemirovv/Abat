package com.weeprogram.abat.screens.webservice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weeprogram.abat.network.DescriptionInDiffLang
import com.weeprogram.abat.network.Descriptions
import com.weeprogram.abat.network.LanguageApi
import com.weeprogram.abat.network.Language
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import kotlin.random.Random

enum class LanguageApiStatus { LOADING, ERROR, DONE }

class MoreAboutLanguageViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()


    val response: LiveData<String>
        get() = _response

    private val _status = MutableLiveData<LanguageApiStatus>()

    val status: LiveData<LanguageApiStatus>
        get() = _status


    init {
        getLanguageDescriptions()
    }

    private fun getLanguageDescriptions() {

        viewModelScope.launch {
            try {
                val listResult = LanguageApi.retrofitService.getDescriptions().language.descriptions
                val randomIndex = Random.nextInt(listResult.size)
                _response.value = listResult[randomIndex].value
                _status.value = LanguageApiStatus.DONE
            } catch (e: Exception) {
                _response.value = "Please check your internet connection and try again.."
                _status.value = LanguageApiStatus.ERROR
            }
        }
    }
}