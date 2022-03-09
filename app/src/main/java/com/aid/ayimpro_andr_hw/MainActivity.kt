package com.aid.ayimpro_andr_hw

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aid.ayimpro_andr_hw.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val githubApi get() = Injector.githubApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        githubApi.getRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                Log.e("TAG", "Result= $it")
            }
            .subscribe()

    }
}