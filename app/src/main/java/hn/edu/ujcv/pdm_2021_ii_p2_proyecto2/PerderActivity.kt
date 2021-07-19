package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ganar.*
import kotlinx.android.synthetic.main.activity_ganar.btnJugardeNuevo
import kotlinx.android.synthetic.main.activity_ganar.btnMenuPrincipal
import kotlinx.android.synthetic.main.activity_perder.*

class PerderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perder)
        btnJugardeNuevo2.setOnClickListener { Jugar() }
        btnMenuPrincipal2.setOnClickListener { Menu() }
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