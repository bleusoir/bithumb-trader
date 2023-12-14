package com.bithumb.trader.controller

import com.bithumb.trader.service.PrivateApiService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PrivateApiController(private val privateApiService: PrivateApiService) {

    @PostMapping
    fun getAccountInfo() = privateApiService.getAccountInfo()
}