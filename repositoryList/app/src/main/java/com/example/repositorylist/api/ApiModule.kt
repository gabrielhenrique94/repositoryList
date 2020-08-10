package com.example.repositorylist.api

import com.example.repositorylist.BuildConfig
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {
    val module = module {
        single {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
            okHttpClient.build()
        }

        single {
            Retrofit.Builder()
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()
                .create(GithubApi::class.java)
        }
    }
}