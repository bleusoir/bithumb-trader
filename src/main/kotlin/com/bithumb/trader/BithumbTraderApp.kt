package com.bithumb.trader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BithumbTraderApp

fun main(args: Array<String>) {
    runApplication<BithumbTraderApp>(*args)
}