package com.onsale.onsaleapi

import com.onsale.onsaleapi.core.bootstrap.Bootstrap
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OnSaleApiApplication

fun main(args: Array<String>) {
    Bootstrap.initApp()
    runApplication<OnSaleApiApplication>(*args)
}
