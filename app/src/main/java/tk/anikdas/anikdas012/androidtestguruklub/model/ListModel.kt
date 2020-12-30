package tk.anikdas.anikdas012.androidtestguruklub.model

import com.google.gson.annotations.SerializedName

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

data class ListModel(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("language") val language: String,
        @SerializedName("genres") val genres: List<String>,
        @SerializedName("image") val image: Image
)
