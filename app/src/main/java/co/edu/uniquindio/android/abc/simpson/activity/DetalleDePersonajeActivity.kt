package co.edu.uniquindio.android.abc.simpson.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.abc.simpson.R
import co.edu.uniquindio.android.abc.simpson.fragmento.DetalleDePersonajeFragment
import co.edu.uniquindio.android.abc.simpson.util.PARCEL_PERSONA
import co.edu.uniquindio.android.abc.simpson.util.selecionarIdioma
import co.edu.uniquindio.android.abc.simpson.vo.Personaje

/**
 * Actividad que representa el detalle de los personajes
 */
class DetalleDePersonajeActivity : AppCompatActivity() {

    /**
     * Constructor de la clase, instancia la actividad
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selecionarIdioma(this);
        setContentView(R.layout.activity_detalle_de_personaje)

        val personaje: Personaje = intent.getParcelableExtra<Personaje>(PARCEL_PERSONA)
        val fragmentoDetalle =
                supportFragmentManager.findFragmentById(R.id.fragmentoDetallePersonaje) as
                        DetalleDePersonajeFragment
        fragmentoDetalle.darDetalle(personaje)
    }
}//Cierre de la actividad
