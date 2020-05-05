package com.lucas.graphqlteste.activity.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.coroutines.EmptyCoroutineContext


open class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, titleIdRes: Int, showBackButton: Boolean = false){
       toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbar)
        if (showBackButton){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}