package com.example.kotlintask2

import android.os.Parcel
import android.os.Parcelable

class Object(val title: String?, val description: String?, val im: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(im)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Object> {
        override fun createFromParcel(parcel: Parcel): Object {
            return Object(parcel)
        }

        override fun newArray(size: Int): Array<Object?> {
            return arrayOfNulls(size)
        }
    }

}