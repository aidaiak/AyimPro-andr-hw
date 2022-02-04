package com.aid.ayimpro_andr_hw

interface OnClick {
    fun goEmployeeList()
    fun goInputFragment()
    fun goEmployeeFragment(id: Long)
    fun editEmployee(id: Long)
    fun deleteEmployee(id: Long)
}