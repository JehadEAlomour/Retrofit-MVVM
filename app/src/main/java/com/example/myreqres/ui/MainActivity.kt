package com.example.myreqres.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myreqres.adapter.ReqAdapter
import com.example.myreqres.databinding.ActivityMainBinding
import com.example.myreqres.di.Repopsitry
import com.example.myreqres.model.Req
import com.example.myreqres.viewModel.ReqResViewModel
import com.example.myreqres.viewModel.ReqViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var reqAdapter: ReqAdapter
    private lateinit var reqResViewModel:ReqResViewModel
    private lateinit var reqViewModelFactory: ReqViewModelFactory
    private lateinit var repopsitry: Repopsitry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        InitializeVar()
        getDataFromRetroift()



    }
    fun InitializeVar()
    {
        repopsitry= Repopsitry()
        reqViewModelFactory=ReqViewModelFactory(repopsitry)
        reqResViewModel =ViewModelProvider(this, reqViewModelFactory).get(ReqResViewModel::class.java)
        reqAdapter = ReqAdapter()
    }
    fun getDataFromRetroift()
    {
        reqResViewModel.getData()
        binding.tvReq.adapter = reqAdapter
        reqResViewModel.mutableLiveData.observe(this
        ) { t ->
            if (t != null) {
                reqAdapter.setList(t)
                reqAdapter.notifyDataSetChanged()

            }
        }
    }

}