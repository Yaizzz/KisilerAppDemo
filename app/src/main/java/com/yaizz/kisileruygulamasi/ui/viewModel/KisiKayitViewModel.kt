package com.yaizz.kisileruygulamasi.ui.viewModel

import androidx.lifecycle.ViewModel
import com.yaizz.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiKayitViewModel: ViewModel() {
    var kRepo = KisilerRepository()

    fun kaydet(kisi_ad : String, kisi_tel : String){
        //suspend geldi buraya kadar ondan kurtulmak için yazdık
        //main arayüz işlemlerde
        CoroutineScope(Dispatchers.Main).launch {
            kRepo.kaydet(kisi_ad,kisi_tel)
        }
    }

}