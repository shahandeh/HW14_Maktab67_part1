package com.example.hw14_maktab67_part1.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.hw14_maktab67_part1.R
import com.example.hw14_maktab67_part1.databinding.FragmentSearchBinding

class SearchFragment : Fragment (R.layout.fragment_search) {

    private val searchUiStateViewModel : SearchUiState by activityViewModels()

    private lateinit var bind : FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val searchView = view.findViewById<androidx.appcompat.widget.SearchView>(R.id.search_view)

        val recyclerView = bind.searchRecycler

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchUiStateViewModel.searchTitle.value = query
                searchUiStateViewModel.searchImage()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchUiStateViewModel.searchTitle.value = newText
                return false
            }
        })

        searchUiStateViewModel.listOfUrlsSearch.observe(viewLifecycleOwner){
            recyclerView.adapter = SearchAdapter(it)
        }

    }

}