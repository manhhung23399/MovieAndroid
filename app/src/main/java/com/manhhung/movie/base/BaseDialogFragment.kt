package com.manhhung.movie.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.manhhung.movie.utils.showToast

abstract class BaseDialogFragment<V : ViewDataBinding> : DialogFragment() {

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
        initData()
        initActions()
    }

    protected abstract fun setupViews()

    protected abstract fun initData()

    protected abstract fun initActions()

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
