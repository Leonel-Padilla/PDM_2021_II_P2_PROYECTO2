package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_ii_p2_proyecto2.Clases.Palabra
import kotlinx.android.synthetic.main.activity_crear_palabra.*

class CrearPalabraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_palabra)
        btnGuardar.setOnClickListener { Guardar() }
    }

    private fun Guardar() {
        if(txtPalabra.text.isEmpty()){
            Toast.makeText(applicationContext, "La palabra no puede estar vacia", Toast.LENGTH_SHORT).show()
        }else if (txtPista.text.isEmpty()){
            Toast.makeText(applicationContext, "La pista no puede estar vacia", Toast.LENGTH_SHORT).show()
        }else if(txtPalabra.text.length > 10){
            Toast.makeText(applicationContext, "La palabra no puede tener más de YYYYYYY letras", Toast.LENGTH_SHORT).show()
        }else{
            val palabra = Palabra()
            palabra.Palabra = txtPalabra.text.toString()
            palabra.Pista = txtPista.text.toString()
            Palabra.Palabras.add(palabra)
            Toast.makeText(applicationContext, "Palabra agregada!", Toast.LENGTH_SHORT).show()
        }
    }
}