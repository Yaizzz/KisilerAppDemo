package com.yaizz.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels

import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.yaizz.kisileruygulamasi.R
import com.yaizz.kisileruygulamasi.data.entity.Kisiler
import com.yaizz.kisileruygulamasi.databinding.FragmentAnaSayfaBinding
import com.yaizz.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.yaizz.kisileruygulamasi.ui.viewModel.AnasayfaViewModel
import com.yaizz.kisileruygulamasi.ui.viewModel.KisiKayitViewModel


class AnaSayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa ,container, false)
        binding.anasayfaFragment = this

        binding.anasayfaToolbarBaslik = "Kişiler"

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val kisilerAdapter =
                KisilerAdapter(requireContext(), it,viewModel) //adapter bilgileri düzenler
            binding.kisilerAdapter = kisilerAdapter

            /*binding.rv.adapter = kisilerAdapter // bu olmazsa görüntüleme olmaz*/

        }


        /*binding.rv.layoutManager =
            LinearLayoutManager(requireContext())//fragment içinde context kullanimi
        //cardların ekranda nasıl gözükeceiğ LinearLayout olan*/





        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener { //harf girdikçe
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean { //ara butonuna basınca
               viewModel.ara(query)
                return true
            }

        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel = KisiKayitViewModel by viewModels() normalde böyle tanımlarız

        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
    }

    override fun onResume() { //ana sayfaya dönünce kişileri yükle
        super.onResume()
        viewModel.kisileriYukle()
    }

}