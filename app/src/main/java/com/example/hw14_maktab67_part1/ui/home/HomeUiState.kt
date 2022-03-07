package com.example.hw14_maktab67_part1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hw14_maktab67_part1.repository.FlickrApiModel
import com.example.hw14_maktab67_part1.repository.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeUiState : ViewModel() {

    var perPage = 0

    private val _listOfUrls : MutableLiveData<List<String>> = MutableLiveData()
    val listOfUrls : LiveData<List<String>> get() = _listOfUrls

    val status = MutableLiveData<Int>()

    private val query = hashMapOf(
        "api_key" to "1c04e05bce6e626247758d120b372a73",
        "method" to "flickr.photos.getPopular",
        "user_id" to "34427466731@N01",
        "extras" to "url_s",
        "format" to "json",
        "nojsoncallback" to "1",
        "per_page" to "30"
    )

    fun loadExtraImage(){
        perPage += 30
        query["per_page"] = perPage.toString()
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
                _listOfUrls.postValue(response.body()?.photos?.photo?.map {
                    it.url_s
                })
            }

            override fun onFailure(call: Call<FlickrApiModel?>, t: Throwable) {
            }
        })
    }

}