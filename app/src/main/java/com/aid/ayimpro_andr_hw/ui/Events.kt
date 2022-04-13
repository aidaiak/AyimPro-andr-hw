package com.aid.ayimpro_andr_hw.ui

import androidx.annotation.StringRes
import com.aid.ayimpro_andr_hw.database.CharacterEntity

sealed class Events {
    class ShowToast(@StringRes val resId: Int): Events()
    object ShowLoading: Events()
    object StopLoading: Events()
    class FetchedCharacter(val character: CharacterEntity) : Events()
}
