package com.example.myreqres.di
import android.util.Log
import com.example.myreqres.api.ReqApiClint
import com.example.myreqres.model.Req
import kotlinx.coroutines.coroutineScope

class Repopsitry {
    private var dataList=ArrayList<Req>()
     suspend fun getReq(): ArrayList<Req> {
       coroutineScope {
           dataList=ReqApiClint.getData()
    }
         Log.d("reposotry",dataList.get(1).first_name)
         return dataList
     }

}