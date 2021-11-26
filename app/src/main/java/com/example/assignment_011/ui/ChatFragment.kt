package com.example.assignment_011.ui

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_011.Resource
import com.example.assignment_011.Resource2
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
//            setObserver()
        }
        binding.btnLoad2.setOnClickListener {
            setObserver2()
        }

    }


//    private fun setObserver(){
//        viewModel.loadChat()
//        viewLifecycleOwner.lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED){
//
//                viewModel.chat.collect{
//                    when(it){
//                        is Resource.Loading -> {
//                            Log.d("message", "Loading1")
//                        }
//                        is Resource.Success -> {
//                            Log.d("message", it.data!!.email)
//                        }
//                        is Resource.Error -> {
//                            Log.d("message", "error 1")
//                        }
//
//                    }                    }
//                }
//            }
//    }

    private fun setObserver2() {

        viewModel.loadChat2()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){

                viewModel.chatSFlow.collect {
                    when(it){
                        is Resource2.Loading -> {

                        }
                        is Resource2.Success -> {
//                            Log.d("message", "success")
                            adapter.setData(it.data)
                           // binding.progressBar.visibility = View.INVISIBLE
                        }
                        is Resource2.Error -> {

                            Log.d("message", "Error777")
                        }
                        is Resource2.Empty -> Unit
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