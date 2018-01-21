package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class Dimensions(

        @field:SerializedName("max_1920")
        val max1920: Max1920,

        @field:SerializedName("original")
        val original: Original,

        @field:SerializedName("1400")
        val jsonMember1400: JsonMember1400,

        @field:SerializedName("max_1240")
        val max1240: Max1240,

        @field:SerializedName("disp")
        val disp: Disp,

        @field:SerializedName("max_1200")
        val max1200: Max1200
)

data class Disp(

        @field:SerializedName("width")
        val width: Int,

        @field:SerializedName("height")
        val height: Int
)

data class JsonMember1400(

        @field:SerializedName("width")
        val width: Int,

        @field:SerializedName("height")
        val height: Int
)

data class Max1200(

        @field:SerializedName("width")
        val width: Int,

        @field:SerializedName("height")
        val height: Int
)

data class Max1240(

        @field:SerializedName("width")
        val width: Int,

        @field:SerializedName("height")
        val height: Int
)

data class Max1920(

        @field:SerializedName("width")
        val width: Int,

        @field:SerializedName("height")
        val height: Int
)

data class Original(

        @field:SerializedName("width")
        val width: Int,

        @field:SerializedName("height")
        val height: Int
)