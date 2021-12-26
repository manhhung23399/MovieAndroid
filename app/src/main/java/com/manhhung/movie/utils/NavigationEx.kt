package com.manhhung.movie.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class NavigationEx {
    fun Fragment.getNavigationResult(key: String = "result") =
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Long>(key)

    fun Fragment.setNavigationResult(result: Long, key: String = "result") {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
    }
}