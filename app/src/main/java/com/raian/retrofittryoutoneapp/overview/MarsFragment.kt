package com.raian.retrofittryoutoneapp.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raian.retrofittryoutoneapp.Adapter.MarsPhotoAdapter
import com.raian.retrofittryoutoneapp.R
import com.raian.retrofittryoutoneapp.databinding.FragmentMarsBinding
import com.raian.retrofittryoutoneapp.network.MarsPhoto

class MarsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMarsBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.photos_grid)
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        viewModel.photos.observe(viewLifecycleOwner) {
            recyclerView.adapter = MarsPhotoAdapter(
                it as ArrayList<MarsPhoto>
            )
        }
    }


}