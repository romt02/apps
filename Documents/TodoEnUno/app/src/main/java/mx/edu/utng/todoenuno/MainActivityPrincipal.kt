package mx.edu.utng.todoenuno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnViaje.setOnClickListener{
            val intento = Intent(this, MainViaje::class.java)
            startActivity(intento)
        }

        btnPrestamo.setOnClickListener{
            val intento2 = Intent(this, MainPrestamo::class.java)
            startActivity(intento2)
        }

        btnJuego.setOnClickListener{
            val intento3 = Intent(this, MainJuego ::class.java)
            startActivity(intento3)
        }

        btnSalir.setOnClickListener{
            System.exit(0)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg: String = ""
        when(item.itemId){

            R.id.itmViaje->{
                msg="Viaje Seleccionado"
                startActivity(Intent(this, MainViaje::class.java))
            }
            R.id.itmPrestamo->{
                msg="Préstamo Seleccionado"
                startActivity(Intent(this, MainPrestamo::class.java))
            }
            R.id.itmJuego->{
                msg="Juego Seleccionado"
                startActivity(Intent(this, MainJuego::class.java))
            }
            R.id.itmSalir->{
                System.exit(0)
            }
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

}
