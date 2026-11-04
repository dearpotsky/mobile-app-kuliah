package com.example.mobileapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.databinding.ItemMahasiswaBinding

class MahasiswaAdapter(
    private val listMahasiswa: List<Mahasiswa>,
    private val onItemClick: (Mahasiswa) -> Unit
) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    inner class MahasiswaViewHolder(private val binding: ItemMahasiswaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mahasiswa: Mahasiswa) {
            binding.tvNama.text = mahasiswa.nama
            binding.tvNim.text = "NIM: ${mahasiswa.nim}"
            binding.tvProdi.text = "Prodi: ${mahasiswa.prodi}"
            binding.root.setOnClickListener {
                onItemClick(mahasiswa)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val binding = ItemMahasiswaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MahasiswaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        holder.bind(listMahasiswa[position])
    }

    override fun getItemCount(): Int = listMahasiswa.size
}

