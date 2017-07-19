package edu.beretta.ico.arch.view

import android.arch.lifecycle.LifecycleActivity
import android.content.Context
import android.os.Bundle
import edu.beretta.ico.arch.viewmodel.IBaseViewModel

/**
 * Realize attach/detach functions for our presentation layer
 */
abstract class BaseArchActivity<in V : IBaseArchView, T : IBaseViewModel<V>>
    : LifecycleActivity(), IBaseArchView {
    /**
     * Base ViewModel
     */
    protected abstract val mViewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.attachView(this as V)
    }

    override fun getActivityContext(): Context = this

    override fun showError(error: String?) {
        rootView.showMessage(error)
    }

    override fun showError(stringResId: Int) {
        rootView.showMessage(getString(stringResId))
    }

    override fun showMessage(srtResId: Int) {
        rootView.showMessage(getString(srtResId))
    }

    override fun showMessage(message: String) {
        rootView.showMessage(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.detachView()
    }
}