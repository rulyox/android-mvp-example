package com.rulyox.mvp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rulyox.mvp.Contract
import com.rulyox.mvp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), Contract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        initUI()

    }

    private fun initUI() {

        // recycler view
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.addItemDecoration(DividerItemDecoration(main_recycler.context, DividerItemDecoration.VERTICAL))

    }

    override fun updateView() {

    }

}
