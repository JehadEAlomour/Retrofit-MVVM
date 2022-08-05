package com.example.myreqres.viewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myreqres.di.Repopsitry
import com.example.myreqres.model.Req
import kotlinx.coroutines.launch

class ReqResViewModel @ViewModelInject constructor(private val repopsitry: Repopsitry) : ViewModel() {
    val mutableLiveData = MutableLiveData<ArrayList<Req>>()
    fun getData() {
        viewModelScope.launch {

            mutableLiveData.value=repopsitry.getReq()

        }


    }
}