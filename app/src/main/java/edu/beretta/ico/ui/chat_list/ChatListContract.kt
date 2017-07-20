package edu.beretta.ico.ui.chat_list

import edu.beretta.ico.arch.view.IBaseArchView
import edu.beretta.ico.arch.viewmodel.IBaseViewModel


interface ChatListContract {
    interface View : IBaseArchView {

    }

    interface ViewModel : IBaseViewModel<View> {
        fun refreshChats()

    }
}