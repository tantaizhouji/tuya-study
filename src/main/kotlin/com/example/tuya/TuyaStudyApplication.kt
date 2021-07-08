package com.example.tuya

import com.example.tuya.connector.DeviceConnector
import com.tuya.connector.spring.annotations.ConnectorScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.full.memberFunctions

@ConnectorScan(basePackages = ["com.example.tuya.connector"])
@SpringBootApplication
class TuyaStudyApplication

fun main(args: Array<String>) {
    runApplication<TuyaStudyApplication>(*args)
}

data class Message(val id: String, val name: String)

@RestController
class MessageController {

    @GetMapping("/")
    fun index() : List<Message> {
        return listOf(
            Message("1", "Hello"),
            Message("2", "Yang"),
            Message("3", "World"),
        )
    }
}

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/devices")
class DeviceController(val connector: DeviceConnector) {

    @GetMapping("/{device_id}")
    fun getById(@PathVariable("device_id") id: String): Map<Any, Any> = connector.getById(id)
}
