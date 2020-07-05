package com.rulyox.mvp

class MainPresenter: Contract.Presenter {

    private var view: Contract.View? = null

    override fun setView(view: Contract.View) {
        this.view = view
    }

}
