package com.bithumb.trader.controller

import com.bithumb.trader.dto.TickerDto
import com.bithumb.trader.service.PublicApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PublicApiController(private val publicApiService: PublicApiService) {

    @GetMapping
    fun getAllCurrency(): Map<String, TickerDto> {
        return publicApiService.getAllCurrency()
    }

    @GetMapping("/{coinCode}")
    fun getKrwCurrencyByCoinCode(@PathVariable coinCode: String): Any {
        return publicApiService.getKrwCurrencyByCoinCode(coinCode)
    }
}