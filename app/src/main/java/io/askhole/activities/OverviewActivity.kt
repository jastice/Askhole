package io.askhole.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.askhole.R
import kotlinx.android.synthetic.main.activity_overview.*

class OverviewActivity : BaseActivity() {

    override fun setup(savedInstanceState: Bundle?) {
        super.setup(savedInstanceState)
        btnStartGame.setOnClickListener { goToActivity(MainActivity.newInstance(this)) }
        btnAddSet.setOnClickListener {  }
        btnChooseSet.setOnClickListener {  }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_overview
    }

    override fun getTitleResId(): Int {
        return R.string.overview_activity
    }

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, OverviewActivity::class.java)
        }
    }
}
