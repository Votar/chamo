package edu.beretta.ico.arch.viewmodel

import android.arch.lifecycle.ViewModel
import edu.beretta.ico.arch.view.IBaseArchView


open class BaseArchViewModel<V : IBaseArchView> : IBaseViewModel<V>, ViewModel(){

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}