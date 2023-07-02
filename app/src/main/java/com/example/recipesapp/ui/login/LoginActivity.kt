package com.example.recipesapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.recipesapp.databinding.ActivityLoginBinding
import com.example.recipesapp.ui.recipes.RecipesActivity
import com.example.recipesapp.utils.hide
import com.example.recipesapp.utils.show

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by lazy { LoginViewModel() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        handleUI()
    }

    private fun handleUI() {
        binding.login.setOnClickListener {
            onLoginClicked()
        }
        binding.email.doOnTextChanged { _, _, _, _ ->
            binding.errorMessage.hide()
        }

        binding.password.doOnTextChanged { _, _, _, _ ->
            binding.errorMessage.hide()
        }
        binding.email.setText(viewModel.user.value?.email)
        binding.password.setText(viewModel.user.value?.password)
    }

    private fun onLoginClicked() {
        if (!validateData()) return
        navigateToRecipesListScreen()
    }

    private fun navigateToRecipesListScreen() {
        val intent = Intent(this, RecipesActivity::class.java)
        startActivity(intent)
    }

    private fun validateData(): Boolean {
        if (binding.email.text.isNullOrBlank() || binding.password.text.isNullOrBlank()) {
            binding.errorMessage.show()
            return false
        }
        if (binding.email.text.toString() != viewModel.user.value?.email ||
            binding.password.text.toString() != viewModel.user.value?.password
        ) {
            binding.errorMessage.show()
            return false
        }
        binding.errorMessage.hide()
        return true
    }
}