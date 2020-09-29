package com.foodie.composetition.di

import com.foodie.composetition.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule {

    @Provides
    fun provideAnalyticsService(
    ): ApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://secure-apir.viamichelin.com/apir/2/findPoi.xml/RESTAURANT/eng")
            .build()
            .create(ApiService::class.java)
    }
}