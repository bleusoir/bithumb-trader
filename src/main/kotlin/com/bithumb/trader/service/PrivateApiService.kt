package com.bithumb.trader.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class PrivateApiService {

    @Value("\${BITHUMB_API_KEY}")
    private lateinit var BITHUMB_API_KEY: String

    fun getAccountInfo(): Any {
        val endPoint = "https://api.bithumb.com/info/account"
        val apiNonce: Long = System.currentTimeMillis()
        val apiKey: String = BITHUMB_API_KEY
        val apiSign: String = endPoint + "params" + apiNonce + apiKey

//            .url("https://api.bithumb.com/info/account")
//            .addHeader("accept", "application/json")
//            .addHeader("content-type", "application/x-www-form-urlencoded")
//            .addHeader("Api-Key", "Access Key")
//            .addHeader("Api-Nonce", "(ms)")
//            .addHeader("Api-Sign", apiSign)

        return ""
    }
}