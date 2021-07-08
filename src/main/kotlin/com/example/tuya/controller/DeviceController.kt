package com.example.tuya.controller

import com.example.tuya.connector.DeviceConnector
import com.example.tuya.model.DeviceRes
import com.example.tuya.model.DeviceStatusRes
import com.example.tuya.model.PageDeviceRes
import com.example.tuya.model.SubDeviceRes
import org.springframework.web.bind.annotation.*

/**
 * @author Mario
 * @since 2021/7/8 10:22 上午
 */
@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/devices")
class DeviceController(val connector: DeviceConnector) {

    @GetMapping("/{device_id}")
    fun getById(@PathVariable("device_id") id: String): DeviceRes = connector.getById(id)

    @GetMapping
    fun getByIds(@RequestParam("device_ids") ids: String): PageDeviceRes = connector.getByIds(ids)

    @GetMapping("/{device_id}/sub")
    fun getSubById(@PathVariable("device_id") id: String): List<SubDeviceRes> = connector.getSubById(id)

    @GetMapping("/{device_id}/status")
    fun getStatusById(@PathVariable("device_id") id: String): List<DeviceStatusRes> = connector.getStatusById(id)

    @GetMapping("/asset/{asset_id}")
    fun getByAssetId(
        @PathVariable("asset_id") id: String,
        @RequestParam("last_row_key", required = false) lastRowKey: String?
    ): Map<Any, Any> = connector.getByAssetId(id, 20, lastRowKey)
}