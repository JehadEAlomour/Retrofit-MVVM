package com.example.myreqres.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myreqres.di.Repopsitry

class ReqViewModelFactory(private val repopsitry: Repopsitry):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReqResViewModel(repopsitry) as T
    }
}