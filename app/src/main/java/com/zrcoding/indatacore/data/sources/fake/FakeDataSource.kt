package com.zrcoding.indatacore.data.sources.fake

import com.zrcoding.indatacore.R
import com.zrcoding.indatacore.ui.shared.Product

class FakeDataSource {
    companion object {
        private val list = listOf(
            Product(
                name = "PACK REFLEX 25",
                description = ".Retraits et paiements au Maroc et à l’étranger\n" +
                        ".E-paiement sur les sites nationaux et internationaux\n" +
                        ".Des plafonds ajustables selon vos besoins : Au Maroc, jusqu’à 5 000 Dhs de retraits par jour et jusqu’à 10 000 Dhs de paiements par semaine et à l’étranger dans la limite de votre dotation à l’international\n" +
                        "..Vos retraits gratuits dans tous les Guichets automatiques bancaires BMCI\n",
                type = "CARTE VISA",
                image = R.drawable.card1,
                price = 100.0
            ),
            Product(
                name = "PACK ENERGY 35",
                description = ".Retraits et paiements au Maroc et à l’étranger\n" +
                        ".E-paiement sur les sites nationaux et internationaux\n" +
                        ".Des plafonds ajustables selon vos besoins : Au Maroc, jusqu’à 5 000 Dhs de retraits par jour et jusqu’à 10 000 Dhs de paiements par semaine et à l’étranger dans la limite de votre dotation à l’international\n" +
                        ".Vos retraits gratuits dans tous les Guichets automatiques bancaires BMCI\n",
                type = "CARTE VISA",
                image = R.drawable.card2,
                price = 150.0
            ),
            Product(
                name = "PACK REFLEX 25",
                description = ".Retraits et paiements au Maroc et à l’étranger\n" +
                        ".E-paiement sur les sites nationaux et internationaux\n" +
                        ".Des plafonds ajustables selon vos besoins : Au Maroc, jusqu’à 5 000 Dhs de retraits par jour et jusqu’à 10 000 Dhs de paiements par semaine et à l’étranger dans la limite de votre dotation à l’international\n" +
                        ".Vos retraits gratuits dans tous les Guichets automatiques bancaires BMCI\n",
                type = "CARTE VISA",
                image = R.drawable.card1,
                price = 150.0
            ),
            Product(
                name = "PACK ENERGY 35",
                description = ".Retraits et paiements au Maroc et à l’étranger\n" +
                        ".E-paiement sur les sites nationaux et internationaux\n" +
                        ".Des plafonds ajustables selon vos besoins : Au Maroc, jusqu’à 5 000 Dhs de retraits par jour et jusqu’à 10 000 Dhs de paiements par semaine et à l’étranger dans la limite de votre dotation à l’international\n" +
                        ".Vos retraits gratuits dans tous les Guichets automatiques bancaires BMCI\n",
                type = "CARTE VISA",
                image = R.drawable.card2,
                price = 100.0
            ),
            Product(
                name = "PACK REFLEX 25",
                description = ".Retraits et paiements au Maroc et à l’étranger\n" +
                        ".E-paiement sur les sites nationaux et internationaux\n" +
                        ".Des plafonds ajustables selon vos besoins : Au Maroc, jusqu’à 5 000 Dhs de retraits par jour et jusqu’à 10 000 Dhs de paiements par semaine et à l’étranger dans la limite de votre dotation à l’international\n" +
                        ".Vos retraits gratuits dans tous les Guichets automatiques bancaires BMCI\n",
                type = "CARTE VISA",
                image = R.drawable.card1,
                price = 150.0
            ),
            Product(
                name = "PACK ENERGY 35",
                description = ".Retraits et paiements au Maroc et à l’étranger\n" +
                        ".E-paiement sur les sites nationaux et internationaux\n" +
                        ".Des plafonds ajustables selon vos besoins : Au Maroc, jusqu’à 5 000 Dhs de retraits par jour et jusqu’à 10 000 Dhs de paiements par semaine et à l’étranger dans la limite de votre dotation à l’international\n" +
                        ".Vos retraits gratuits dans tous les Guichets automatiques bancaires BMCI\n",
                type = "CARTE VISA",
                image = R.drawable.card2,
                price = 100.0
            ),
        )
    }

    fun getProducts() = list
}