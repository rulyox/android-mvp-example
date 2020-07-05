package com.rulyox.mvp

interface Contract {

    interface View {

        fun updateView()

    }

    interface Presenter {

        fun setView(view: View)

    }

}
