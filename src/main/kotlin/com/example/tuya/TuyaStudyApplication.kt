package com.example.tuya

import com.tuya.connector.spring.annotations.ConnectorScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@ConnectorScan(basePackages = ["com.example.tuya.connector"])
@SpringBootApplication
class TuyaStudyApplication

fun main(args: Array<String>) {
    runApplication<TuyaStudyApplication>(*args)
}
