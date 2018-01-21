package com.cutta.kehance.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by CuneytCarikci on 10/01/2018.
 */

abstract class BaseActivity<VM : ViewModel> : DaggerAppCompatActivity() {


    protected lateinit var viewModel: VM

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun getViewModel(): Class<VM>

    @LayoutRes
    abstract fun getLayoutId(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}