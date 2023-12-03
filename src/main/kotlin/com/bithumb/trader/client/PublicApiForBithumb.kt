package com.bithumb.trader.client

import com.bithumb.trader.config.FeignConfig
import com.bithumb.trader.dto.AllTickerDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "allCurrency",
    url = "https://api.bithumb.com/public/ticker/ALL_KRW",
    configuration = [FeignConfig::class]
)
interface PublicApiForBithumb {

    @GetMapping
    fun getAllCurrency(): AllTickerDto
}