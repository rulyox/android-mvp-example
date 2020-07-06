package com.rulyox.mvp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rulyox.mvp.MainContract
import com.rulyox.mvp.MainPresenter
import com.rulyox.mvp.R
import com.rulyox.mvp.adapter.MemoAdapter
import com.rulyox.mvp.memo.Memo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), MainContract.View {

    companion object {

        val presenter: MainContract.Presenter = MainPresenter()

    }

    private val memoAdapter: MemoAdapter = MemoAdapter()
    private var memoList: ArrayList<Memo>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        initUI()

    }

    private fun initUI() {

        // presenter
        presenter.setView(this)

        // recycler view
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.addItemDecoration(DividerItemDecoration(main_recycler.context, DividerItemDecoration.VERTICAL))
        main_recycler.adapter = memoAdapter

        // add button
        main_fab.setOnClickListener {

            val addIntent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(addIntent)

        }

    }

    override fun setList(memoList: ArrayList<Memo>) {

        this.memoList = memoList

    }

    override fun updateView() {

        memoAdapter.setList(memoList ?: return)
        memoAdapter.notifyDataSetChanged()

    }

}
