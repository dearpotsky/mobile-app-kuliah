package com.example.mobileapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapp.databinding.FragmentListMahasiswaBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ListMahasiswaFragment : Fragment() {

    private var _binding: FragmentListMahasiswaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListMahasiswaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Data Dummy
        val dataMahasiswa = listOf(
            Mahasiswa("2021001", "Ahmad Fauzi", "Informatika"),
            Mahasiswa("2021002", "Siti Nurhaliza", "Sistem Informasi"),
            Mahasiswa("2021003", "Budi Santoso", "Informatika"),
            Mahasiswa("2021004", "Dewi Lestari", "Teknik Komputer"),
            Mahasiswa("2021005", "Eko Prasetyo", "Informatika")
        )

        // 2. Setup RecyclerView & Adapter
        val adapter = MahasiswaAdapter(dataMahasiswa) { mhs ->
            tampilkanDialogDetail(mhs)
        }
        binding.rvMahasiswa.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMahasiswa.adapter = adapter

        // Tambah padding atas programatik agar card pertama tidak mepet toolbar
        val dp24 = (24 * resources.displayMetrics.density).toInt()
        binding.rvMahasiswa.setPadding(0, dp24, 0, 0)
        binding.rvMahasiswa.clipToPadding = false
    }

    // 3. Menampilkan Dialog pilihan/detail
    private fun tampilkanDialogDetail(mahasiswa: Mahasiswa) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Detail Mahasiswa")
            .setMessage("NIM: ${mahasiswa.nim}\nNama: ${mahasiswa.nama}\nProdi: ${mahasiswa.prodi}")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("Batal", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

