package edu.beretta.ico.arch.viewmodel

import android.arch.lifecycle.ViewModel
import edu.beretta.ico.arch.view.IBaseArchView
import edu.beretta.ico.arch.viewmodel.IBaseViewModel


class BaseViewModel : ViewModel(), IBaseViewModel<IBaseArchView> {
    var mView: IBaseArchView? = null
    override fun attachView(view: IBaseArchView) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}