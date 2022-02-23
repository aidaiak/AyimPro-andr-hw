package com.aid.ayimpro_andr_hw.customview

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.aid.ayimpro_andr_hw.databinding.ViewSeasonBinding
import com.aid.ayimpro_andr_hw.ext.viewBinding
import java.util.Calendar

class SeasonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : ConstraintLayout(context, attrs) {

    private val binding = viewBinding(ViewSeasonBinding::inflate)

    init {

        binding.apply {
            btnAction.setOnClickListener {
                textSeason.text = getSeason(editDate.text.toString())
            }
        }
    }

    private fun getSeason(date: String): String {
        return date.calendarFrom("dd.MM.yyyy")?.let {
            when (it.get(Calendar.MONTH)) {
                Calendar.DECEMBER, Calendar.JANUARY, Calendar.FEBRUARY ->
                    "Winter"
                Calendar.MARCH, Calendar.APRIL, Calendar.MAY ->
                    "Spring"
                Calendar.JUNE, Calendar.JULY, Calendar.AUGUST ->
                    "Summer"
                Calendar.SEPTEMBER, Calendar.OCTOBER, Calendar.NOVEMBER ->
                    "Fall"
                else -> "Unknown"
            }
        } ?: "Unknown"
    }
}