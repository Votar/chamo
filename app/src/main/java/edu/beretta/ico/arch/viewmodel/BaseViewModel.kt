package edu.beretta.ico.arch.viewmodel

import android.arch.lifecycle.ViewModel
import edu.beretta.ico.arch.view.IBaseArchView


class BaseViewModel : ViewModel(), IBaseViewModel<IBaseArchView> {
    var mView: IBaseArchView? = null
    override fun attachView(view: IBaseArchView) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}