package com.example.ghiblifilms_ca.data

import org.w3c.dom.Text

data class GhibliEntity(
    var title: String,
    var original_title: String,
    var original_title_romanised: String,
    var description: Text,
    var director: String,
    var producer: String,
    var release_date: Int,
    var running_time: Int
)
