package com.example.convertidordemonedas
//librerias generadas para la aplicacion
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
//Creacion de las diferentes constantes para la conversion
const val PCaUs = 0.00027
const val USaPC = 3727.50
const val PCaLE = 0.00021
const val LEaPC = 4653.93
const val LEaUS = 1.25
const val USaLE = 0.80
//Clase principal de Android
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Atributo que detecta cuando al objeto botton es presionado
        BT_cambio.setOnClickListener {
            /*Definicion de variables necesarias para la extraccion, comparacion y coversion de valores
            * asociados a los diferentes objetos usados en la aplicacion*/
            val valores: Array<String> = arrayOf("Peso Colombiano", "Dolar", "Libra Esterlina")
            val ingreso: String = SP_moneda_inicio.selectedItem.toString()
            val monedas: String = SP_moneda_salida.selectedItem.toString()
            val valor_moneda = (ET_valor_in.text.toString())
            //Opciones de validacion y comparacion
            if (valor_moneda.isEmpty()) {
                TV_imprimir.text = "Por favor ingrese un valor de moneda a cambiar"
            } else {
                //Varable con la cual se relizan las multilicaciones para las conversiones
                var valor_money = (valor_moneda).toDouble()
                if (ingreso == monedas) {
                    TV_imprimir.text = "las monedas son iguales"
                    TV_valor_out.text = (valor_money).toString()
                } else {
                    TV_imprimir.text = ""
                    if (ingreso == valores[0] && monedas == valores[1]) {           //conversion de peso colombiano a dolar
                        TV_valor_out.text = (valor_money * PCaUs).toString()
                    } else if (ingreso == valores[0] && monedas == valores[2]) {    //conversion de peso colombiano a libra
                        TV_valor_out.text = (valor_money * PCaLE).toString()
                    } else if (ingreso == valores[1] && monedas == valores[0]) {    //conversion de dolar a peso colombiano
                        TV_valor_out.text = (valor_money * USaPC).toString()
                    } else if (ingreso == valores[1] && monedas == valores[2]) {    //conversion de dolar a peso libra
                        TV_valor_out.text = (valor_money * USaLE).toString()
                    } else if (ingreso == valores[2] && monedas == valores[0]) {    //conversion de libra a peso colombiano
                        TV_valor_out.text = (valor_money * LEaPC).toString()
                    } else if (ingreso == valores[2] && monedas == valores[1]) {    //conversion de libra a dolar
                        TV_valor_out.text = (valor_money * LEaUS).toString()
                    }
                }
            }

        }

    }

}