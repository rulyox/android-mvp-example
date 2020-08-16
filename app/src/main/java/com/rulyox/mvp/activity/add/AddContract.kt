package com.rulyox.mvp.activity.add

import com.rulyox.mvp.memo.Memo

interface AddContract {

    interface View

    interface Presenter {

        fun setView(view: View)

        fun addItem(memo: Memo)

    }

}
