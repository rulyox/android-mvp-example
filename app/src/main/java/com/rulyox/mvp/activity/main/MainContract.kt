package com.rulyox.mvp.activity.main

import com.rulyox.mvp.memo.Memo

interface MainContract {

    interface View {

        fun setList(memoList: ArrayList<Memo>)

        fun updateView()

    }

    interface Presenter {

        fun setView(view: View)

        fun deleteItem(position: Int)

        fun loadList()

    }

}
