package com.bithumb.trader.controller

import com.bithumb.trader.dto.TickerDto
import com.bithumb.trader.service.PublicApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PublicApiController(private val publicApiService: PublicApiService) {

    @GetMapping
    fun getAllCurrency(): Map<String, TickerDto> = publicApiService.getAllCurrency()

    @GetMapping("/{coinCode}")
    fun getKrwCurrencyByCoinCode(@PathVariable coinCode: String): Any =
        publicApiService.getKrwCurrencyByCoinCode(coinCode)

    @GetMapping("/orderbooks", "/orderbooks/")
    fun getAllOrderbooks() = publicApiService.getAllOrderbooks()

    @GetMapping("/orderbooks/{coinCode}")
    fun getKrwOrderbookByCoinCode(@PathVariable coinCode: String) =
        publicApiService.getKrwOrderbookByCoinCode(coinCode)

    @GetMapping("/transaction/history/{coinCode}")
    fun getTransactionHistoryByCoinCode(@PathVariable coinCode: String) =
        publicApiService.getTransactionHistoryByCoinCode(coinCode)

    @GetMapping("/assets/status/{coinCode}")
    fun getAssetsStatusByCoinCode(@PathVariable coinCode: String) =
        publicApiService.getAssetsStatusByCoinCode(coinCode)
}