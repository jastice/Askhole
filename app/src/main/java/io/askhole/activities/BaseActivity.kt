package io.askhole.activities

import android.content.Intent
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        setup(savedInstanceState)
    }


    @CallSuper
    open fun setup(savedInstanceState: Bundle?) {
        if (getTitleResId() != 0) {
            setTitle(getTitleResId())
        }
    }

    abstract fun getLayoutResId(): Int
    abstract fun getTitleResId(): Int

    open fun goToActivity(intent: Intent){
        this.startActivity(intent)
    }
}