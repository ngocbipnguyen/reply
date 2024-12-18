package com.example.reply.di

import android.content.Context
import com.example.reply.data.source.remote.ApiInterface
import com.example.reply.data.source.remote.ApiInterfaceLocal
import com.example.reply.data.source.remote.intercepter.AssetInterceptor
import com.example.reply.data.source.remote.intercepter.OkHttpClientLocal
import com.example.reply.data.source.remote.intercepter.OkHttpClientScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetWordModule {

    //todo for local
    @OkHttpClientLocal
    @Provides
    @Singleton
    fun provideClientLocal(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AssetInterceptor(context))
            .connectTimeout(10000, TimeUnit.SECONDS)
            .readTimeout(10000, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterfaceLocal(@OkHttpClientLocal okHttpClient: OkHttpClient) : ApiInterfaceLocal {
        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://json")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(ApiInterfaceLocal::class.java)
    }

    // todo for remote

    @OkHttpClientScope
    @Provides
    @Singleton
    fun provideClient(@ApplicationContext context: Context) : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10000, TimeUnit.SECONDS)
            .readTimeout(10000, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterface(@OkHttpClientScope client: OkHttpClient): ApiInterface {
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://sdlkjaskd")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(ApiInterface::class.java)
    }

}