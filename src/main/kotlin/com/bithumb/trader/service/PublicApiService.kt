package com.bithumb.trader.service

import com.bithumb.trader.client.PublicApiForBithumb
import com.bithumb.trader.dto.TickerDto
import com.fasterxml.jackson.databind.ObjectMapper
import mu.KotlinLogging
import org.springframework.stereotype.Service

val log = KotlinLogging.logger { }

@Service
class PublicApiService(
    private val mapper: ObjectMapper,
    private val publicApiForBithumb: PublicApiForBithumb,
) {

    fun getAllCurrency(): Map<String, TickerDto> {

        val tickerMap = mutableMapOf<String, TickerDto>()
        val allCurrency = publicApiForBithumb.getAllCurrency()
        val keys = allCurrency.data.keys.filter { it != "date" }

        log.info { "ALL CURRENCIES :: $keys" }

        keys.forEach {
            val value = allCurrency.data[it]
            val jsonString = mapper.writeValueAsString(value)

            val ticker = mapper.readValue(jsonString, TickerDto::class.java)
            tickerMap[it] = ticker
        }

        return tickerMap
    }
}