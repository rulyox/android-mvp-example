package com.rulyox.mvp

import com.rulyox.mvp.memo.Memo

interface MainContract {

    interface View {

        fun setList(memoList: ArrayList<Memo>)

        fun updateView()

    }

    interface Presenter {

        fun setView(view: View)

        fun addItem(memo: Memo)

        fun loadList()

    }

}
