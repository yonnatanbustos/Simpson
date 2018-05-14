package co.edu.uniquindio.android.abc.simpson.fragmento

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.edu.uniquindio.android.abc.simpson.R
import co.edu.uniquindio.android.abc.simpson.vo.Personaje
import kotlinx.android.synthetic.main.fragment_detalle_de_personaje.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * Fragmento que representa el detalle de un personaje
 *
 */
class DetalleDePersonajeFragment() : Fragment(), View.OnClickListener {

    /**
     * Variable que representa el personaje
     */
    lateinit var personaje: Personaje

    /**
     * Funcion que permite la creacion del fragmento
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_personaje, container, false)
    }

    /**
     * Funcion que les da accion a los componentes del fragmento
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    /**
     * Funcion que ejecuta las funciones a cada compoenete
     */
    override fun onClick(v: View?) {
        var intent: Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=hP3fmnMuZZU"))
        startActivity(intent)
    }

    /**
     * Funcion que da los detalles de informacion al fragmento del personaje
     */
    fun darDetalle(personaje: Personaje) {
        this.personaje = personaje
        txtTituloDetalle.text = personaje.nombre
        txtDescripcionDetalle.text = personaje.descripcion
        btnIrAVideo.setOnClickListener(this)
    }

}//Cierre del fragmento



