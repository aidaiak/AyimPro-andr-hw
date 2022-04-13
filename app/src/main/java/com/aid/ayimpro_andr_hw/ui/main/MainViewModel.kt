package com.aid.ayimpro_andr_hw.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aid.ayimpro_andr_hw.App
import com.aid.ayimpro_andr_hw.R
import com.aid.ayimpro_andr_hw.database.CharacterEntity
import com.aid.ayimpro_andr_hw.extensions.toCharacterEntity
import com.aid.ayimpro_andr_hw.ui.Events
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.net.UnknownHostException

class MainViewModel (application: Application): AndroidViewModel(application) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val charactersLiveData: LiveData<List<CharacterEntity>> =
        getApplication<App>().database.characterDao().getAll()

    private val _event = MutableLiveData<Events?>()
    val event: LiveData<Events?>
        get() = _event

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        _event.value = Events.ShowLoading

        compositeDisposable.add(
            getApplication<App>().rickAndMortyApi.getCharacters()
                .subscribeOn(Schedulers.io())
                .map { response ->
                    val list = mutableListOf<CharacterEntity>()
                    response.results.forEach {
                        list.add(it.toCharacterEntity())
                    }
                    list.toList()
                }
                .map {
                    getApplication<App>().database.characterDao().insertList(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { _event.value = Events.StopLoading }
                .subscribe({}, {
                    handleError(it)
                })
        )
    }

    private fun handleError(it: Throwable) {
        _event.value = when (it) {
            is UnknownHostException -> Events.ShowToast(R.string.no_internet)
            else -> Events.ShowToast(R.string.unknown_error)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
