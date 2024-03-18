package com.yaizz.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.yaizz.kisileruygulamasi.R
import com.yaizz.kisileruygulamasi.data.entity.Kisiler
import com.yaizz.kisileruygulamasi.databinding.CardTasarimBinding
import com.yaizz.kisileruygulamasi.databinding.FragmentAnaSayfaBinding
import com.yaizz.kisileruygulamasi.ui.fragment.AnaSayfaFragmentDirections
import com.yaizz.kisileruygulamasi.ui.viewModel.AnasayfaViewModel
import com.yaizz.kisileruygulamasi.utils.gecisYap

class KisilerAdapter(var mcontext : Context,var kisilerListesi : List<Kisiler>, var viewModel : AnasayfaViewModel)
    :RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>()
{

    //kart tasarımını.xml i  temsil eden bir class
    //cardın içerisindeki görsel nesnelere erişmemizi sağlayan yapı bu olacak
    inner class CardTasarimTutucu(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    //parent yazılımsal tasarım false başka yazılım eklemeyeceğiz
    //view binding kurulumu yapılır
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        //data binding kurulumunu yaptık
        val binding : com.yaizz.kisileruygulamasi.databinding.CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mcontext),
            R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }


    //carda tıkladığımızda ne olacak gibi
    //cardla ilgili işlemler burada olacak
    //holder sayesinde tasarim a ordan -> cardTasarımBindinge oradan da -> card içerisindeki viewlara erişeceğiz
    //position gelen liste elemanlarını belirtecek
    //döngü gibi çalışır
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int)/*position ile listeden kişilerin yerini alırız*/ {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim //bindinge erişmek için
        t.kisiNesnesi = kisi

        t.cardViewSatir.setOnClickListener{
            val gecis = AnaSayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi" , Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(kisi_id = kisi.kisi_id)
                }
                .show()
        }

    }

    //kaç veri göstereceğiz
    override fun getItemCount(): Int {
        return kisilerListesi.size
    }
}

