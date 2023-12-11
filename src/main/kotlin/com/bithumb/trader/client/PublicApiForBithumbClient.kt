package com.bithumb.trader.client

import com.bithumb.trader.config.FeignConfig
import com.bithumb.trader.dto.AllTickerDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "publicApiForBithumb",
    url = "https://api.bithumb.com/public",
    configuration = [FeignConfig::class]
)
interface PublicApiForBithumbClient {

    @GetMapping("/ticker/ALL_KRW")
    fun getAllCurrency(): AllTickerDto

    @GetMapping("/ticker/{coinCode}_KRW")
    fun getKrwCurrencyByCoinCode(@PathVariable coinCode: String): Any

    @GetMapping("/orderbook/ALL_KRW")
    fun getAllOrderbooks(): Any

    @GetMapping("/orderbook/{coinCode}_KRW")
    fun getKrwOrderbookByCoinCode(@PathVariable coinCode: String): Any

    @GetMapping("/transaction_history/{coinCode}_KRW")
    fun getTransactionHistoryByCoinCode(@PathVariable coinCode: String): Any

    @GetMapping("/assetsstatus/{coinCode}")
    fun getAssetsStatusByCoinCode(@PathVariable coinCode: String): Any

    @GetMapping("/candlestick/{coinCode}_KRW/{chartIntervals}")
    fun getCandleStickByCoinCodeAndChartIntervals(
        @PathVariable coinCode: String,
        @PathVariable chartIntervals: String
    ): Any

}