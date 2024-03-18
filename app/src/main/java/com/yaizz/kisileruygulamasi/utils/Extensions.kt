package com.yaizz.kisileruygulamasi.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gecisYap(it : View ,id :Int){
    findNavController(it).navigate(id)
}

//Overloading yaptık aynı isimli fonksiyonu tekrar kullanıma sunduk
fun Navigation.gecisYap(it : View ,id :NavDirections){
    findNavController(it).navigate(id)
}