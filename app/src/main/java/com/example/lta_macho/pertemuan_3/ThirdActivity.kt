package com.example.lta_macho.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lta_macho.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Menggunakan ViewBinding menggantikan R.layout.activity_third
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // OnClickListener untuk btnKirim (Menampilkan Toast & Intent ke ThirdResultActivity)
        binding.btnKirim.setOnClickListener {
            val inputNo = binding.inputNoTujuan.text.toString()

            if (inputNo.isEmpty()) {
                Toast.makeText(this, "Harap isi nomor tujuan terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Toast sesuai instruksi Warming Up
                Toast.makeText(this, "Nomor Tujuan: $inputNo", Toast.LENGTH_SHORT).show()

                // Intent berpindah ke ThirdResultActivity sesuai instruksi modul
                val intent = Intent(this, ThirdResultActivity::class.java)
                startActivity(intent)
            }
        }
    }
}