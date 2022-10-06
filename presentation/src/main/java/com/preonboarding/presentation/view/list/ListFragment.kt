package com.preonboarding.presentation.view.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.preonboarding.presentation.R
import com.preonboarding.presentation.common.base.BaseFragment
import com.preonboarding.presentation.databinding.FragmentListBinding
import com.preonboarding.presentation.view.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>(R.layout.fragment_list) {

    private val viewModel: ListViewModel by viewModels()
    private lateinit var adapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchMovieList()
        setupAdapter()


        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setupAdapter() {
        adapter = MovieAdapter()

        binding.rcvMovie.apply {
            this.adapter = this@ListFragment.adapter
            this.layoutManager = LinearLayoutManager(requireActivity())
            this.setHasFixedSize(true)
        }
    }
}
