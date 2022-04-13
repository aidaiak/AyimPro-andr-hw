package com.aid.ayimpro_andr_hw.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aid.ayimpro_andr_hw.App
import com.aid.ayimpro_andr_hw.ui.Events
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterViewModel(application: Application): AndroidViewModel(application) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var id: Long = -1
    fun setId(id: Long?) {
        this.id = id ?: -1
    }

    private val _event = MutableLiveData<Events?>()
    val event: LiveData<Events?>
        get() = _event

    fun fetchCharacter() {
        compositeDisposable.add(
            getApplication<App>()
                .database.characterDao().getById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    _event.value = Events.FetchedCharacter(it)
                }
                .subscribe()
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}