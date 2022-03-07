package com.example.hw14_maktab67_part1.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hw14_maktab67_part1.repository.FlickrApiModel
import com.example.hw14_maktab67_part1.repository.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchUiState : ViewModel() {

    private val _listOfUrlsSearch : MutableLiveData<List<String>> = MutableLiveData()
    val listOfUrlsSearch : LiveData<List<String>> get() = _listOfUrlsSearch

    val status = MutableLiveData<Int>()

    var searchTitle = MutableLiveData<String>()

    private val query = hashMapOf(
        "api_key" to "1c04e05bce6e626247758d120b372a73",
        "user_id" to "34427466731@N01",
        "extras" to "url_s",
        "format" to "json",
        "method" to "flickr.photos.search",
        "nojsoncallback" to "1"
    )

    fun searchImage(){
        query["text"] = searchTitle.value.toString()
        imageDownloader()
    }

    private fun imageDownloader() {
        NetworkManager.service.getImage(
            query = query
        ).enqueue(object : Callback<FlickrApiModel?> {
            override fun onResponse(
                call: Call<FlickrApiModel?>,
                response: Response<FlickrApiModel?>
            ) {
                status.value = response.code()
                _listOfUrlsSearch.postValue(response.body()?.photos?.photo?.map {
                    it.url_s
                })
            }

            override fun onFailure(call: Call<FlickrApiModel?>, t: Throwable) {
            }
        })
    }

}