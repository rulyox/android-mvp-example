package com.rulyox.mvp.activity.add

import com.rulyox.mvp.memo.Memo
import com.rulyox.mvp.memo.MemoStore

class AddPresenter: AddContract.Presenter {

    private var view: AddContract.View? = null

    override fun setView(view: AddContract.View) {

        this.view = view

    }

    override fun addItem(memo: Memo) {

        MemoStore.add(memo)

    }

}
