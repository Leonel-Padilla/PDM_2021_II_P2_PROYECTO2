package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_ii_p2_proyecto2.Clases.Palabra
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCrear.setOnClickListener { crear() }
        btnJugar.setOnClickListener { jugar() }
    }


    private fun crear() {
        val intent  = Intent(this, CrearPalabraActivity::class.java)
        startActivity(intent)
    }

    private fun jugar() {
        if(Palabra.Palabras.size < 1){
            Toast.makeText(applicationContext, "No hay palabras registradas", Toast.LENGTH_SHORT).show()
        }else {
            val intent = Intent(this, JugarActivity::class.java)
            startActivity(intent)
        }
    }
}