package com.example.alarmmanager

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class AllUserModel (
    @SerializedName("id") var id     : Int?    = null,
    @SerializedName("name") var name   : String? = null,
    @SerializedName("email") var email  : String? = null,
    @SerializedName("gender") var gender : String? = null,
    @SerializedName("status") var status : String? = null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(gender)
        parcel.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AllUserModel> {
        override fun createFromParcel(parcel: Parcel): AllUserModel {
            return AllUserModel(parcel)
        }

        override fun newArray(size: Int): Array<AllUserModel?> {
            return arrayOfNulls(size)
        }
    }
}
