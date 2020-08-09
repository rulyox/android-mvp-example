package com.rulyox.mvp.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.rulyox.mvp.R
import com.rulyox.mvp.memo.Memo
import com.rulyox.mvp.memo.MemoStore
import kotlinx.android.synthetic.main.dialog.*

class AddActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog)

        initUI()

    }

    private fun initUI() {

        dialog_ok.setOnClickListener {

            val title: String = dialog_title.text.toString()
            val text: String = dialog_text.text.toString()

            // add memo
            val memo = Memo(MemoStore.getNewId(), title, text)
            MemoStore.add(memo)

            setResult(RESULT_OK, Intent())
            finish()

        }

        dialog_cancel.setOnClickListener {

            finish()

        }

    }

}
