package com.zrcoding.indatacore.ui.shared

import androidx.annotation.DrawableRes
import com.zrcoding.indatacore.R
import java.util.*

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val type: String,
    @DrawableRes val image: Int, // TODO change to url later
    val price: Double,
    var quantity: Int = 0,
)

val fakeProductList = listOf(
    Product(
        name = "PACK REFLEX 25",
        description = ".Retraits et paiements au Maroc et à l’étranger \n.E-paiement sur les sites nationaux et internationaux",
        type = "CARTE VISA",
        image = R.drawable.card1,
        price = 100.0
    ),
    Product(
        name = "PACK ENERGY 35",
        description = ".Retraits et paiements au Maroc et à l’étranger \n.E-paiement sur les sites nationaux et internationaux",
        type = "CARTE VISA",
        image = R.drawable.card2,
        price = 150.0
    ),
    Product(
        name = "PACK REFLEX 25",
        description = ".Retraits et paiements au Maroc et à l’étranger \n.E-paiement sur les sites nationaux et internationaux",
        type = "CARTE VISA",
        image = R.drawable.card1,
        price = 150.0
    ),
    Product(
        name = "PACK ENERGY 35",
        description = ".Retraits et paiements au Maroc et à l’étranger \n.E-paiement sur les sites nationaux et internationaux",
        type = "CARTE VISA",
        image = R.drawable.card2,
        price = 100.0
    ),
    Product(
        name = "PACK REFLEX 25",
        description = ".Retraits et paiements au Maroc et à l’étranger \n.E-paiement sur les sites nationaux et internationaux",
        type = "CARTE VISA",
        image = R.drawable.card1,
        price = 150.0
    ),
    Product(
        name = "PACK ENERGY 35",
        description = ".Retraits et paiements au Maroc et à l’étranger \n.E-paiement sur les sites nationaux et internationaux",
        type = "CARTE VISA",
        image = R.drawable.card2,
        price = 100.0
    ),
)