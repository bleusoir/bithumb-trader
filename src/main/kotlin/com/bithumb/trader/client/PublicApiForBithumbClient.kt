package com.bithumb.trader.client

import com.bithumb.trader.config.FeignConfig
import com.bithumb.trader.dto.AllTickerDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "allCurrency",
    url = "https://api.bithumb.com/public/ticker",
    configuration = [FeignConfig::class]
)
interface PublicApiForBithumbClient {

    @GetMapping("/ALL_KRW")
    fun getAllCurrency(): AllTickerDto

    @GetMapping("/{coinCode}_KRW")
    fun getKrwCurrencyByCoinCode(@PathVariable coinCode: String): Any
}