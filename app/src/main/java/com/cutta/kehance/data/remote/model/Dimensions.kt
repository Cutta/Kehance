package com.cutta.kehance.data.remote.model


import com.google.gson.annotations.SerializedName


data class Dimensions(

        @field:SerializedName("max_1920")
        val max1920: Max1920? = null,

        @field:SerializedName("original")
        val original: Original? = null,

        @field:SerializedName("1400")
        val jsonMember1400: JsonMember1400? = null,

        @field:SerializedName("max_1240")
        val max1240: Max1240? = null,

        @field:SerializedName("disp")
        val disp: Disp? = null,

        @field:SerializedName("max_1200")
        val max1200: Max1200? = null
)

data class Disp(

        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("height")
        val height: Int? = null
)

data class JsonMember1400(

        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("height")
        val height: Int? = null
)

data class Max1200(

        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("height")
        val height: Int? = null
)

data class Max1240(

        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("height")
        val height: Int? = null
)

data class Max1920(

        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("height")
        val height: Int? = null
)

data class Original(

        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("height")
        val height: Int? = null
)