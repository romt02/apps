package mx.edu.utng.todoenuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_viaje.*

class MainViaje : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_viaje)

        btnCalcularViaje.setOnClickListener{

            var kmRecor: Double = etxKmRecor.text.toString().toDouble()
            var gasxL: Double = etxGasxL.text.toString().toDouble()
            var dinGas: Double = etxDinGas.text.toString().toDouble()
            var horasV: Int = etxHorasV.text.toString().toInt()
            var minV: Int = etxMinV.text.toString().toInt()

            //Cálculo de consumo
            var totLit = (dinGas/gasxL)
            var cconUno = (kmRecor/totLit)
            var conUnoA = (1/cconUno) //Consumo 1 km litro
            var conUnoB = (conUnoA*gasxL) //Consumo 1 km peso

            var conDosA = (conUnoA*100) //Consumo 100 km litro
            var conDosB = (conDosA*gasxL) //Consumo 100 km peso

            //Cálculo de velocidad
            var minReal: Double = (minV.toDouble()/60)
            var tiempo: Double = (minReal+horasV.toDouble())
            var velocidad: Double = (kmRecor.toDouble()/tiempo)

            //Envío de variables
            txvGasKm.text = "Consumo: ${conUnoA} litros y ${conUnoB} pesos por km."
            txvGasx100K.text = "Consumo: ${conDosA} litros y ${conDosB} pesos por 100 km"
            txvVelMed.text = "La velocidad media es de: ${velocidad} km por hora"

        }

        btnRegresarViaje.setOnClickListener{
            //Finaliza o descarga de memoria la Activity: InfoActivity
            finish()
        }


    }

}
