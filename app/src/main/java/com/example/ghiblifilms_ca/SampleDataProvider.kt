package com.example.ghiblifilms_ca

import com.example.ghiblifilms_ca.data.GhibliEntity

class SampleDataProvider {

    companion object {
        private val sampleTitle1 = "Howl's Moving Castle"
        private val sampleTitle2 = "Spirited Away"
        private val sampleTitle3 = "Princess Mononoke"

        private val sampleDirector1 = "Tanjiro Kamado"
        private val sampleDirector2 = "Nezuko Kamado"
        private val sampleDirector3 = "Ichigo Kurosaki"

        fun getFilms() = arrayListOf(
            GhibliEntity(sampleTitle1, sampleDirector1),
            GhibliEntity(sampleTitle2, sampleDirector2),
            GhibliEntity(sampleTitle3, sampleDirector3),
        )
    }
}