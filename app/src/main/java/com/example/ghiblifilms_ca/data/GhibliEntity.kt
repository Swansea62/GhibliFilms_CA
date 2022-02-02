package com.example.ghiblifilms_ca.data

import android.os.Parcel
import android.os.Parcelable

data class GhibliEntity(
    var title: String?,
    var image: String?,
    var original_title: String?,
    var original_title_romanised: String?,
    var description: String?,
    var director: String?,
    var producer: String?,
    var release_date: String?,
    var running_time: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(image)
        parcel.writeString(original_title)
        parcel.writeString(original_title_romanised)
        parcel.writeString(description)
        parcel.writeString(director)
        parcel.writeString(producer)
        parcel.writeString(release_date)
        parcel.writeString(running_time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GhibliEntity> {
        override fun createFromParcel(parcel: Parcel): GhibliEntity {
            return GhibliEntity(parcel)
        }

        override fun newArray(size: Int): Array<GhibliEntity?> {
            return arrayOfNulls(size)
        }
    }
}
