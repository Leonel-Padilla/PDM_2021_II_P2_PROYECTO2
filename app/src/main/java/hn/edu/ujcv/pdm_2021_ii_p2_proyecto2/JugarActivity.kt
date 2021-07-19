package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_ii_p2_proyecto2.Clases.Palabra
import kotlinx.android.synthetic.main.activity_jugar.*

class JugarActivity : AppCompatActivity() {
    var palabraActual       = Palabra()
    var letrasPalabra       = ArrayList<Char>()
    var numeroGuiones       = ""
    var todosGuines         = ArrayList<String>()
    var contadorVictoria    = 0
    var contadorDerrota     = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugar)
        inicializar()
        btnProbar.setOnClickListener { probar() }
    }

    private fun probar() {
        numeroGuiones = ""
        if (txtLetra.text.isEmpty()){
            Toast.makeText(applicationContext, "Por favor, introduzca una letra", Toast.LENGTH_SHORT).show()
        }else if (txtLetra.text.length > 1){
            Toast.makeText(applicationContext, "Introduzca solo una letra", Toast.LENGTH_SHORT).show()
        }else{
            contadorDerrota++
            var contador = 0

            for (letraAcual in letrasPalabra){
              if (letraAcual.toString().equals(txtLetra.text.toString())){
                  todosGuines[contador] = "$letraAcual"
                  contadorDerrota--
                  contadorVictoria++
              }
                contador++
            }

            for (guion in todosGuines){
                numeroGuiones = numeroGuiones+guion
            }
            txvCantidadLetras.text = numeroGuiones
            Hangman(contadorDerrota)

            if (contadorVictoria == palabraActual.Palabra.length){
                val intent  = Intent(this, GanarActivity::class.java)
                startActivity(intent)
            }

            if (contadorDerrota == 6){
                val intent  = Intent(this, PerderActivity::class.java)
                startActivity(intent)
            }

        }
        txtLetra.setText("")
    }//--
    private fun Hangman(contadorDerrota:Int) {
        if (contadorDerrota == 0) {
            IVLife2.visibility = View.VISIBLE
            IVLife3.visibility = View.VISIBLE
            IVLife4.visibility = View.VISIBLE
            IVLife5.visibility = View.VISIBLE
            IVLife6.visibility = View.VISIBLE
            IVFase6.visibility = View.INVISIBLE
            IVFase1.visibility = View.VISIBLE
        }else if (contadorDerrota == 1){
            IVFase1.visibility = View.INVISIBLE
            IVFase2.visibility = View.VISIBLE
            IVLife6.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "5 vidas restantes", Toast.LENGTH_SHORT).show()
        }else if(contadorDerrota == 2){
            IVFase2.visibility = View.INVISIBLE
            IVFase3.visibility = View.VISIBLE
            IVLife5.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "4 vidas restantes", Toast.LENGTH_SHORT).show()
        }else if(contadorDerrota == 3){
            IVFase3.visibility = View.INVISIBLE
            IVFase4.visibility = View.VISIBLE
            IVLife4.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "3 vidas restantes", Toast.LENGTH_SHORT).show()
        }else if(contadorDerrota == 4){
            IVFase4.visibility = View.INVISIBLE
            IVFase5.visibility = View.VISIBLE
            IVLife3.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "2 vidas restantes", Toast.LENGTH_SHORT).show()
        }else if(contadorDerrota == 5){
            IVFase5.visibility = View.INVISIBLE
            IVFase6.visibility = View.VISIBLE
            IVLife2.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "1 vida restante", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inicializar(){

            val range = IntRange(0, Palabra.Palabras.size+1)
            val numeroNuevo = (0..Palabra.Palabras.size).random()

            palabraActual = Palabra.Palabras[numeroNuevo]

            val palabra1 = palabraActual.Palabra
            txvPistaDetalle.text = palabraActual.Pista

            for (letra in palabra1){
                numeroGuiones = numeroGuiones+"-"
                todosGuines.add("-")
                letrasPalabra.add(letra)
            }
            txvCantidadLetras.text = numeroGuiones
        }

}