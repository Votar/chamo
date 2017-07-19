package edu.beretta.ico.arch.viewmodel

import edu.beretta.ico.arch.view.IBaseArchView


interface IBaseViewModel<in V : IBaseArchView> {
    fun attachView(view: V)
    fun detachView()
}