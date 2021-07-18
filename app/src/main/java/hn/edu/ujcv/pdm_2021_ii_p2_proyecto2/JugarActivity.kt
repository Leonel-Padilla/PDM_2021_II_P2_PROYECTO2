package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_ii_p2_proyecto2.Clases.Palabra
import kotlinx.android.synthetic.main.activity_jugar.*
import kotlin.random.Random.Default.nextInt

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
        palabras()
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
                Toast.makeText(applicationContext, "$letraAcual", Toast.LENGTH_SHORT).show()
              if (letraAcual.toString().equals(txtLetra.text.toString())){
                  todosGuines[contador] = "$letraAcual"
                  Toast.makeText(applicationContext, "Es igual", Toast.LENGTH_SHORT).show()
                  contadorDerrota--
                  contadorVictoria++
              }
                contador++
            }
            Toast.makeText(applicationContext, "todosGuines Listo", Toast.LENGTH_SHORT).show()

            for (guion in todosGuines){
                numeroGuiones = numeroGuiones+guion
            }
            txvCantidadLetras.text = numeroGuiones


            //if (contadorVictoria == palabraActual.Palabra.length){
            //}

            //if (contadorDerrota == palabraActual.Palabra.length){
            //}

        }
    }//--

    private fun palabras() {
        val palabra1 = Palabra()
        palabra1.Palabra = "Gato"
        palabra1.Pista   = "El animal mas mierda que hay"

        val palabra2 = Palabra()
        palabra2.Palabra = "Perro"
        palabra2.Pista   = "El animal mas hermoso, picioso, cosita hermosa que hay"

        val palabra3 = Palabra()
        palabra3.Palabra = "Carro"
        palabra3.Pista   = "La mamalona"

        Palabra.Palabras.add(palabra1)
        Palabra.Palabras.add(palabra2)
        Palabra.Palabras.add(palabra3)

        val prueba = Palabra.Palabras
//        Toast.makeText(applicationContext, "Ya mero", Toast.LENGTH_SHORT).show()
    }

    private fun inicializar(){
        val range = IntRange(0, Palabra.Palabras.size+1)
        val numeroNuevo = (0..Palabra.Palabras.size).random()

        palabraActual = Palabra.Palabras[numeroNuevo]
        Toast.makeText(applicationContext, "Numero  $numeroNuevo Palabra ${palabraActual.Palabra}", Toast.LENGTH_SHORT).show()

        val palabra1 = palabraActual.Palabra
        txvPistaDetalle.text = palabraActual.Pista

        for (letra in palabra1){
            numeroGuiones = numeroGuiones+"-"
            todosGuines.add("-")
            letrasPalabra.add(letra)
        }
        txvCantidadLetras.text = numeroGuiones

//        Toast.makeText(applicationContext, "Ya terminó", Toast.LENGTH_SHORT).show()
    }//--

}//-----