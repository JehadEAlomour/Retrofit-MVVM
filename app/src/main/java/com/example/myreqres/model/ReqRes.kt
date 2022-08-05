package com.example.myreqres.model

data class ReqRes
    (
    var page: Int,
    var per_page: Int,
    var total_pages: Int,
    var data: ArrayList<Req>,
)
