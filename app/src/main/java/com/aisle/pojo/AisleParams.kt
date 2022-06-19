package com.aisle.pojo

import com.google.gson.annotations.SerializedName

data class AisleParams(

    @field:SerializedName("number")
    var number: String? = null,

    @field:SerializedName("otp")
    var otp: String? = null
)
