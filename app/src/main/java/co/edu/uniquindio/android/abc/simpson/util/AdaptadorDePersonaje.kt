package co.edu.uniquindio.android.abc.simpson.util

import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.edu.uniquindio.android.abc.simpson.R
import co.edu.uniquindio.android.abc.simpson.vo.Personaje
import kotlinx.android.synthetic.main.resumen_personaje.view.*

/**
 * Adaptador de personajes
 */
class AdaptadorDePersonaje(var personajes: ArrayList<Personaje>, var fragmento: Fragment) : RecyclerView.Adapter<AdaptadorDePersonaje.PersonajeViewHolder>() {

    /**
     * Variable para añadir eventos al adaptador
     */
    private var listener: OnClickAdaptadorDePersonaje


    init {
        listener = fragmento as OnClickAdaptadorDePersonaje
    }

    /**
     * Funcon que ubica el personaje seleccionado
     */
    interface OnClickAdaptadorDePersonaje {
        fun onClickPosition(pos: Int)
    }


    /**
     * Funcion que crea el adaptador de personaje
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PersonajeViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.resumen_personaje, parent, false)
        return PersonajeViewHolder(v)
    }

    /**
     * Funcion que retorna el tamaño de la lista
     */
    override fun getItemCount(): Int {
        return personajes.size
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder?, position: Int) {
        holder?.bindPersonaje(personajes.get(position))
    }


    /**
     * Implementacion del PersonajeViewHolder
     */
    inner class PersonajeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        val nombre: TextView = itemView.nombre

        /**
         * se asigna el evento al item
         */
        init {
            listener = fragmento as OnClickAdaptadorDePersonaje
        }

        val fechaNacimiento: TextView = itemView.fecha_nacimiento
        fun bindPersonaje(personaje: Personaje) {
            nombre.text = personaje.nombre
            fechaNacimiento.text = personaje.fecha.toString()

        }


        /**
         * Funcion determina el elemento seleccionado
         */
        override fun onClick(v: View?) {
            Log.d("PERSONA", "Elemento " + adapterPosition + " clickeado. " + nombre.text)
            listener.onClickPosition(adapterPosition)
        }
    }

}

