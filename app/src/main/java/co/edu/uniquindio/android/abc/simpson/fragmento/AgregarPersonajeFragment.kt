package co.edu.uniquindio.android.abc.simpson.fragmento

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.edu.uniquindio.android.abc.simpson.R
import kotlinx.android.synthetic.main.fragment_agregar_personaje.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AgregarPersonajeFragment : DialogFragment(), View.OnClickListener {

    lateinit var listener: OnClickAgregarPersonaje

    /**
     * Interface creada para crear personajes
     */
    interface OnClickAgregarPersonaje {
        fun registrarPersonaje(nombre: String, historia: String, URL: String)
    }


    /**
     * Funcion que permite la creacion del fragmento
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dialog.setTitle(resources.getString(R.string.diag_agregar_titulo))

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar_personaje, container, false)
    }

    /**
     * Funcion que permite dar accion a los componentes del fragmento
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnRegistrar.setOnClickListener(this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Activity) {
            try {
                listener = context as OnClickAgregarPersonaje
            } catch (e: ClassCastException) {
                throw ClassCastException("${activity.toString()} debe implementar la interfaz OnClickAgregarPersonaje")
            }
        }
    }

    /**
     * Funcion en la cual se define lo que hara cada componente del fragmento
     */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnRegistrar -> {
                listener.registrarPersonaje(txtAddNombre.text.toString(), txtAddHistoria.text.toString(), txtAddURL.text.toString())
                dismiss()
            }
        }
    }


}//Cierre del fragmento
