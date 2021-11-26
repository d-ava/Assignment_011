package com.example.assignment_011.ui

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_011.Resource
import com.example.assignment_011.databinding.FragmentChatBinding
import com.example.testprojectusinghilt.ChatAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChatFragment : BaseFragment<FragmentChatBinding>(FragmentChatBinding::inflate) {

    private val viewModel: ChatViewModel by activityViewModels()

    private lateinit var adapter: ChatAdapter

    override fun start() {

        setRecycler()
        setListener()

    }

    private fun setListener() {
        binding.btnLoad.setOnClickListener {
            setObserver()
        }
    }

    private fun setObserver() {
        Log.d("message", "from fragment setObserver")
        viewModel.loadChat()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){

                viewModel.chat.collect {
                    when(it){
                        is Resource.Loading -> {
                            Log.d("message", "Loading")
                        }
                        is Resource.Success -> {
                            Log.d("message", "Success")
                        }
                        is Resource.Error -> {
                            Log.d("message", it.data!!.messageType)
                            Log.d("message", "Error")
                        }
                    }
                }
            }
        }
    }

    private fun setRecycler() {
        adapter = ChatAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
    }
}