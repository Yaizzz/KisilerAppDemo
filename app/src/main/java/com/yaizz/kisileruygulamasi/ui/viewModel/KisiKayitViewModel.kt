package com.yaizz.kisileruygulamasi.ui.viewModel

import androidx.lifecycle.ViewModel
import com.yaizz.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor (var krepo: KisilerRepository): ViewModel() {


    fun kaydet(kisi_ad : String, kisi_tel : String){
        //suspend geldi buraya kadar ondan kurtulmak için yazdık
        //main arayüz işlemlerde
        CoroutineScope(Dispatchers.Main).launch {
            krepo.kaydet(kisi_ad,kisi_tel)
        }
    }

}