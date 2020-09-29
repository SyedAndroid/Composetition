package com.foodie.composetition.di

import android.content.Context
import com.foodie.composetition.BuildConfig
import com.foodie.composetition.network.AuthInterceptor
import com.foodie.composetition.network.RemoteRestaurantService
import com.foodie.composetition.network.RemoteRestaurants
import com.foodie.composetition.repository.RestaurantDao
import com.foodie.composetition.repository.RestaurantRepository
import com.foodie.composetition.repository.RestaurantRoomDatabase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAnalyticsService(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): RemoteRestaurantService {
        return Retrofit.Builder()
            .baseUrl("https://secure-apir.viamichelin.com/apir/2/findPoi.JSON2/RESTAURANT/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(RemoteRestaurantService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }


    @Singleton
    @Provides
    fun giveMeHttpLogging(): HttpLoggingInterceptor {
        val logLevel =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return HttpLoggingInterceptor().setLevel(logLevel)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        RestaurantRoomDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideRestaurantDao(db: RestaurantRoomDatabase) = db.restaurantDao()

    @Singleton
    @Provides
    fun provideRestaurantRepository(
        restaurantDao: RestaurantDao,
        remoteRestaurants: RemoteRestaurants
    ): RestaurantRepository {
        return RestaurantRepository(restaurantDao, remoteRestaurants)
    }

}