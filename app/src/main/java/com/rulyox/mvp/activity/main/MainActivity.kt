package com.rulyox.mvp.activity.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rulyox.mvp.R
import com.rulyox.mvp.activity.add.AddActivity
import com.rulyox.mvp.adapter.MemoAdapter
import com.rulyox.mvp.memo.Memo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), MainContract.View {

    companion object {
        private const val RESULT_ADD = 1
    }

    private val presenter = MainPresenter()
    private lateinit var memoAdapter: MemoAdapter
    private var memoList: ArrayList<Memo>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        initUI()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == RESULT_ADD) {

            presenter.loadList()

        }

    }

    private fun initUI() {

        // presenter
        presenter.setView(this)

        // adapter
        val itemClickListener = object: MemoAdapter.ItemClickListener {

            override fun onItemClick(position: Int, view: View) {

                AlertDialog.Builder(view.context)
                    .setTitle(R.string.dialog_delete_memo)
                    .setMessage(R.string.dialog_delete_text)
                    .setPositiveButton(R.string.dialog_delete) { dialog, _ ->

                        presenter.deleteItem(position)
                        presenter.loadList()

                        dialog.dismiss()

                    }
                    .setNegativeButton(R.string.dialog_cancel) { dialog, _ ->

                        dialog.dismiss()

                    }
                    .show()

            }

        }
        memoAdapter = MemoAdapter(itemClickListener)

        // recycler view
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.addItemDecoration(DividerItemDecoration(main_recycler.context, DividerItemDecoration.VERTICAL))
        main_recycler.adapter = memoAdapter

        // add button
        main_fab.setOnClickListener {

            val addIntent = Intent(this@MainActivity, AddActivity::class.java)
            startActivityForResult(addIntent, RESULT_ADD)

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
