package co.edu.uniquindio.android.abc.simpson.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Clase que representa un personaje
 */
class Personaje (var id:String, var nombre:String, var fecha: Date, var descripcion: String, var urlVideo: String):Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readSerializable() as Date,
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nombre)
        parcel.writeSerializable(fecha)
        parcel.writeString(descripcion)
        parcel.writeString(urlVideo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Personaje> {
        override fun createFromParcel(parcel: Parcel): Personaje {
            return Personaje(parcel)
        }

        override fun newArray(size: Int): Array<Personaje?> {
            return arrayOfNulls(size)
        }
    }


}//Cierre de la clase