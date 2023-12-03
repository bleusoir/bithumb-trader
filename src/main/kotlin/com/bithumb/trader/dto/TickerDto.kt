package com.bithumb.trader.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class TickerDto(
    @JsonProperty("opening_price", required = false)
    val openingPrice: BigDecimal?,

    @JsonProperty("closing_price", required = false)
    val closingPrice: BigDecimal?,

    @JsonProperty("min_price", required = false)
    val minPrice: BigDecimal?,

    @JsonProperty("max_price", required = false)
    val maxPrice: BigDecimal?,

    @JsonProperty("units_traded", required = false)
    val unitsTraded: BigDecimal?,

    @JsonProperty("acc_trade_value", required = false)
    val accTradeValue: BigDecimal?,

    @JsonProperty("prev_closing_price", required = false)
    val prevClosingPrice: BigDecimal?,

    @JsonProperty("units_traded_24H", required = false)
    val unitsTraded24H: BigDecimal?,

    @JsonProperty("acc_trade_value_24H", required = false)
    val accTradeValue24H: BigDecimal?,

    @JsonProperty("fluctate_24H", required = false)
    val fluctuate24H: BigDecimal?,

    @JsonProperty("fluctate_rate_24H", required = false)
    val fluctuateRate24H: BigDecimal?
)