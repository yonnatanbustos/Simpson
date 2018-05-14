package co.edu.uniquindio.android.abc.simpson.fragmento

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*

import co.edu.uniquindio.android.abc.simpson.R
import co.edu.uniquindio.android.abc.simpson.util.AdaptadorDePersonaje
import co.edu.uniquindio.android.abc.simpson.util.selecionarIdioma
import co.edu.uniquindio.android.abc.simpson.vo.Personaje
import kotlinx.android.synthetic.main.fragment_lista_de_personajes.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * Fragmento el cual contiene varios fragmentos con los datellaes de los personajes
 *
 */
class ListaDePersonajesFragment : Fragment(), AdaptadorDePersonaje.OnClickAdaptadorDePersonaje {


    /**
     * Lista de personajes
     */
    lateinit var personajes: ArrayList<Personaje>
    /**
     * Adaptador personalizado de personaje
     */
    lateinit var adaptador: AdaptadorDePersonaje
    /*
    evento para comunicar info a la actividad
     */
    lateinit var listener: OnPersonajeSeleccionadoListener

    /*
    * Intergaz para realizar la conexion con la actividad
     */
    interface OnPersonajeSeleccionadoListener {
        fun onPersonajeSeleccionado(pos: Int)
    }


    /**
     * Funcion que permite la creacion del fragmento
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);


    }


    /**
     * Funcion que permite la creacion de la vista
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_personajes, container, false)
    }

    /**
     * Funcion que da accion a los ocmpnentes del fragmento
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adaptador = AdaptadorDePersonaje(personajes, this)
        listaPersonajes.adapter = adaptador
        listaPersonajes.layoutManager = LinearLayoutManager(context,

                LinearLayoutManager.VERTICAL, false)
    }


    /**
     * Funcion que crea el menu de opciones
     */
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    /**
     * Funcion en la cual se le da accion a cada uno de los items del menu
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_agregar -> {
                mostrarAgregarPersona()
                // personajes.add(0, Personaje("1", "Duffman", Date(), "", ""))
                //adaptador.notifyItemInserted(0)
            }
            R.id.menu_eliminar -> {
                personajes.removeAt(0)
                adaptador.notifyItemRemoved(0)
            }
            R.id.menu_modificar -> {
                val aux: Personaje = personajes.get(1)
                personajes.set(1, personajes.get(2))
                personajes.set(2, aux)
                adaptador.notifyItemMoved(1, 2)
            }

            R.id.menu_cambiar_idioma -> {
                selecionarIdioma(context)
                val intent = activity.intent
                intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_NEW_TASK)
                activity.finish()
                activity.startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    /**
     * Crea la instancia del interface
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Activity) {
            try {
                listener = context as OnPersonajeSeleccionadoListener
            } catch (e: ClassCastException) {
                throw ClassCastException("${activity.toString()} debe implementar la interfaz OnPersonajeSeleccionadoListener")
            }
        }
    }


    /**
     * Funcion que determinan la posicion del personaje seleccionado
     */
    override fun onClickPosition(pos: Int) {
        listener.onPersonajeSeleccionado(pos)
    }

    /**
     * Funcion que abre el fragmento donde se puede agregar una persona
     */
    fun mostrarAgregarPersona() {
        val agregarPersonaje = AgregarPersonajeFragment()
        agregarPersonaje.setStyle(DialogFragment.STYLE_NORMAL,
                R.style.DialogoTitulo)
        agregarPersonaje.show(fragmentManager, "AgregarPersonaje")
    }

}//Cierre del fragmento
