package com.rulyox.mvp

import com.rulyox.mvp.memo.Memo
import com.rulyox.mvp.memo.MemoStore

class MainPresenter: MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun setView(view: MainContract.View) {

        this.view = view

    }

    override fun addItem(memo: Memo) {

        MemoStore.add(memo)

    }

    override fun loadList() {

        view?.setList(MemoStore.getList())
        view?.updateView()

    }

}
