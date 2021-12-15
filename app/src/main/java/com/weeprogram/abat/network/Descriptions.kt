package com.weeprogram.abat.network

import com.squareup.moshi.Json

data class Descriptions(@Json(name = "http://www.w3.org/2000/01/rdf-schema#comment") val descriptions: List<DescriptionInDiffLang>)