package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hn.edu.ujcv.pdm_2021_ii_p2_proyecto2.R
import kotlinx.android.synthetic.main.activity_ganar.*

class GanarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganar)
        btnJugardeNuevo.setOnClickListener { Jugar() }
        btnMenuPrincipal.setOnClickListener { Menu() }
    }

    private fun Jugar() {
        val intent  = Intent(this, JugarActivity::class.java)
        startActivity(intent)
    }
    private fun Menu() {
        val intent  = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}