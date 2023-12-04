package com.example.shemajamebeli_4.fragments

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli_4.adapters.MessagingAdapter
import com.example.shemajamebeli_4.databinding.FragmentMainBinding
import com.example.shemajamebeli_4.dataclasses.MessagingItem
import com.example.shemajamebeli_4.fragments.baseFragment.BaseFragment
import com.example.shemajamebeli_4.viewModel.MessagingViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val moshi = Moshi.Builder().build()
    private val viewModel: MessagingViewModel by viewModels()
    private val adapter = MessagingAdapter()


    override fun setupListeners() {
    }

    override fun setupUI() {
        parseJsonData()
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.rvMessages.adapter = adapter
        binding.rvMessages.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeViewModel() {
        viewModel.messagingItems.observe(viewLifecycleOwner) { items ->
            adapter.submitList(items)
        }
    }

    private fun parseJsonData() {

        val jsonString = requireContext().assets.open("data.json").bufferedReader()
            .use { it.readText() }

        val adapter: JsonAdapter<List<MessagingItem>> = moshi.adapter(
            Types.newParameterizedType(List::class.java, MessagingItem::class.java)
        )

        val chatItemList: List<MessagingItem> = adapter.fromJson(jsonString) ?: emptyList()

        viewModel.setMessagingItems(chatItemList)

    }


}

