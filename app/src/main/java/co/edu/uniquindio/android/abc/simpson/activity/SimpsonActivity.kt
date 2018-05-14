package co.edu.uniquindio.android.abc.simpson.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.android.abc.simpson.R
import co.edu.uniquindio.android.abc.simpson.fragmento.AgregarPersonajeFragment
import co.edu.uniquindio.android.abc.simpson.fragmento.ListaDePersonajesFragment
import co.edu.uniquindio.android.abc.simpson.util.PARCEL_PERSONA
import co.edu.uniquindio.android.abc.simpson.vo.Personaje
import java.util.*

/**
 * Actividad que representa la aplicacion
 */
class SimpsonActivity : AppCompatActivity(), ListaDePersonajesFragment.OnPersonajeSeleccionadoListener, AgregarPersonajeFragment.OnClickAgregarPersonaje {


    /**
     * Lista de personajes
     */
    var personajes = ArrayList<Personaje>()
    var contador_personajes = 4
    lateinit var fragmentLista: ListaDePersonajesFragment

    /**
     * Constructor de la clase
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simpson)

        personajes.add(Personaje("1", "Bart", Date(), "", ""))
        personajes.add(Personaje("2", "Milhouse", Date(), "", ""))
        personajes.add(Personaje("3", "Homero", Date(), "", ""))

        fragmentLista =
                supportFragmentManager.findFragmentById(R.id.fragmentoListaPersonajes) as
                        ListaDePersonajesFragment
        fragmentLista.personajes = personajes

    }


    /**
     * Funcion que carga la informacion al menu, permitiendo el despliegue de este
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    /**
     * Funcion iniciada cada vez que se selecciona un item del menu
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }


    /**
     * Evento iniciado cada vez que se selecciona un personaje
     */
    override fun onPersonajeSeleccionado(pos: Int) {
        val intent: Intent = Intent(this, DetalleDePersonajeActivity::class.java)
        intent.putExtra(PARCEL_PERSONA, personajes[pos])
        startActivity(intent)

    }

    override fun registrarPersonaje(nombre: String, historia: String, URL: String) {
        personajes.add(0, Personaje("0", nombre, Date(), historia, URL))
        fragmentLista.adaptador.notifyItemInserted(0)
    }


}//Cierre de la actividad
