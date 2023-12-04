package com.bithumb.trader.config

import feign.Logger
import feign.Logger.Level.FULL
import feign.RequestInterceptor
import feign.Retryer
import feign.Retryer.NEVER_RETRY
import feign.codec.Decoder
import feign.codec.Encoder
import feign.codec.ErrorDecoder
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.server.ResponseStatusException


@Configuration
@EnableFeignClients(basePackages = ["com.bithumb.trader.client"])
class FeignConfig {

    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor {
            it.header("x-custom-secret", "-")
        }
    }

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return ErrorDecoder { _, response ->
            when (val status = response.status()) {
                in 400..499 -> throw ResponseStatusException(HttpStatus.valueOf(status))
                in 500..599 -> throw ResponseStatusException(INTERNAL_SERVER_ERROR)
                else -> throw RuntimeException()
            }
        }
    }

    @Bean
    fun loggerLevel(): Logger.Level = FULL

    @Bean
    fun decoder(): Decoder {
        return JacksonDecoder()
    }

    @Bean
    fun encoder(): Encoder {
        return JacksonEncoder()
    }

    @Bean
    @ConditionalOnMissingBean
    fun feignRetryer(): Retryer {
        return NEVER_RETRY
    }
}