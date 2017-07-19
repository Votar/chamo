package edu.beretta.ico.arch.view

import android.arch.lifecycle.LifecycleFragment
import android.content.Context
import android.view.View
import edu.beretta.ico.arch.viewmodel.IBaseViewModel

abstract class BaseArchFragment<in V : IBaseArchView, T : IBaseViewModel<V>> : LifecycleFragment(),
        IBaseArchView {
    protected abstract var mPresenter: T
    abstract override val rootView: View
    override fun onStart() {
        super.onStart()
        mPresenter.attachView(this as V)
    }

    override fun onStop() {
        super.onStop()
        mPresenter.detachView()
    }


    override fun getActivityContext(): Context = activity

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

}