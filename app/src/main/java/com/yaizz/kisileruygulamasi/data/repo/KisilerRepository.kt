package com.yaizz.kisileruygulamasi.data.repo

import com.yaizz.kisileruygulamasi.data.datasource.KisilerDataSource
import com.yaizz.kisileruygulamasi.data.entity.Kisiler

class KisilerRepository(var kds : KisilerDataSource) {
     //bağımlılık

    suspend fun kaydet(kisi_ad : String, kisi_tel : String) = kds.kaydet(kisi_ad,kisi_tel)// = yerine {}de olur

    suspend fun guncelle(kisi_id : Int, kisi_ad : String, kisi_tel : String) = kds.guncelle(kisi_id,kisi_ad,kisi_tel)

    suspend fun sil(kisi_id : Int) = kds.sil(kisi_id)

    suspend fun kisileriYukle() : List<Kisiler> = kds.kisileriYukle()

    suspend fun ara(aramaKelimesi: String): List<Kisiler> = kds.ara(aramaKelimesi)
}