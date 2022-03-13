package com.na.sadapay.di.network

import com.na.sadapay.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Reusable
    fun provideRetrofitClientBuilder(
        converterFactory: GsonConverterFactory,
        httpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .client(httpClient)
        .addConverterFactory(converterFactory)
        .baseUrl(BuildConfig.baseUrl)
        .build()

    @Provides
    @Reusable
    fun providesGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Reusable
    fun providesOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Reusable
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            val loggingLevel = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
            setLevel(loggingLevel)
        }
}
