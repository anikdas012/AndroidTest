package tk.anikdas.anikdas012.androidtestguruklub.model

import com.google.gson.annotations.SerializedName

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

data class DetailsModel(
        @SerializedName("name") val name: String,
        @SerializedName("type") val type: String,
        @SerializedName("language") val language: String,
        @SerializedName("genres") val genres: List<String>,
        @SerializedName("summary") val summary: String,
        @SerializedName("image") val image: Image
)
