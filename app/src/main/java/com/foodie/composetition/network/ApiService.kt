package com.foodie.composetition.network

import retrofit2.http.GET


interface ApiService {
    @GET("users/{user}/repos")
    fun listRepos()
}