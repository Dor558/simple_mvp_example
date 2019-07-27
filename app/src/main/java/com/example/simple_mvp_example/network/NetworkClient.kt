package com.example.simple_mvp_example.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class NetworkClient: NetworkContract.Client  {

    override var client: Retrofit = Retrofit.Builder()
       .addConverterFactory(GsonConverterFactory.create())
       .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
       .baseUrl(NetworkContract.BASE_URL)
       .build()

}