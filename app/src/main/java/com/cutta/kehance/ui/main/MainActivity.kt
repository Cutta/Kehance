package com.cutta.kehance.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import com.cutta.kehance.R
import com.cutta.kehance.databinding.ActivityMainBinding
import com.cutta.kehance.ui.base.BaseActivity
import com.cutta.kehance.util.delegation.contentView
import com.cutta.kehance.util.extension.reObserve

class MainActivity : BaseActivity<MainViewModel>() {

    //private val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    override fun getViewModel(): Class<MainViewModel> {

        return MainViewModel::class.java
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.projects.reObserve(this, Observer { Log.d("PROJECTS", "" + it) })
    }

}
