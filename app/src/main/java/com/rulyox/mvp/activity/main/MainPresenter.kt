package com.rulyox.mvp.activity.main

import com.rulyox.mvp.memo.MemoStore

class MainPresenter: MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun setView(view: MainContract.View) {

        this.view = view

    }

    override fun deleteItem(position: Int) {

        MemoStore.delete(position)

    }

    override fun loadList() {

        view?.setList(MemoStore.getList())
        view?.updateView()

    }

}
