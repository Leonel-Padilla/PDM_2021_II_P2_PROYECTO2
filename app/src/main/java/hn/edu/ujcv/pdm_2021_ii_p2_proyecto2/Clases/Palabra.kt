package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2.Clases

import android.os.Parcel
import android.os.Parcelable

class Palabra() : Parcelable {
    var Pista   = ""
    var Palabra = ""

    constructor(parcel: Parcel) : this() {
        Pista = parcel.readString().toString()
        Palabra = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Pista)
        parcel.writeString(Palabra)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Palabra> {
        override fun createFromParcel(parcel: Parcel): Palabra {
            return Palabra(parcel)
        }

        override fun newArray(size: Int): Array<Palabra?> {
            return arrayOfNulls(size)
        }
        var Palabras = ArrayList<Palabra>()
    }

}