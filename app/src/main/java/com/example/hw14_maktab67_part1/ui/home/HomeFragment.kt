package com.example.hw14_maktab67_part1.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.hw14_maktab67_part1.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeFragmentViewModel: HomeUiState by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeFragmentViewModel.loadExtraImage()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        homeFragmentViewModel.listOfUrls.observe(viewLifecycleOwner){
            recyclerView.adapter = HomeAdapter(it)
            recyclerView.adapter?.notifyItemInserted(homeFragmentViewModel.perPage)
        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    homeFragmentViewModel.loadExtraImage()
                }
            }
        })
    }
}