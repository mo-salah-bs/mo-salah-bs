package com.example.recipesapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipesapp.data.model.User

class LoginViewModel: ViewModel() {
    private val userMutable: MutableLiveData<User> = MutableLiveData(User())
    val user: LiveData<User> = userMutable
}