package com.bithumb.trader.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AllTickerDto(
    @JsonProperty("status")

    val status: String,
    @JsonProperty("data")
    val data: Map<String, Any>
)