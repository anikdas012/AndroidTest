package tk.anikdas.anikdas012.androidtestguruklub.model

import com.google.gson.annotations.SerializedName

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

data class Image(
        @SerializedName("medium") val medium: String,
        @SerializedName("original") val original: String
)
