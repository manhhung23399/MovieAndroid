package com.manhhung.movie.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.manhhung.movie.utils.showToast


abstract class BaseBottomSheetDialogFragment<V : ViewDataBinding> : BottomSheetDialogFragment() {

    @get:LayoutRes
    protected abstract val layoutResources: Int
    protected var binding: V? = null
    protected abstract val viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil
        .inflate<V>(inflater, layoutResources, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.errorMessage.observe(viewLifecycleOwner, {
            view.context.showToast(it)
        })
        setupViews()
        setupData()
        setupActions()
    }

    protected abstract fun setupViews()

    protected abstract fun setupData()

    protected abstract fun setupActions()

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
