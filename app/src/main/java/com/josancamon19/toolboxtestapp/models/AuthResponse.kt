package com.josancamon19.toolboxtestapp.models

data class AuthResponse(
    val sub: String,
    val token: String,
    val type: String
)