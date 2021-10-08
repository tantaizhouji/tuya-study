package com.example.tuya.controller

import com.example.tuya.connector.AssetConnector
import com.example.tuya.model.PageAssetRes
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/assets")
class AssetController(val connector: AssetConnector) {

    @GetMapping
    fun assets(
        @RequestParam(value = "parent_asset_id", required = false) parentAssetId: String?,
        @RequestParam(value = "page_size", required = false, defaultValue = "20") pageSize: Int,
        @RequestParam(value = "page_no", required = false, defaultValue = "1") pageNo: Int
    ): PageAssetRes = connector.assets(null, pageSize, pageNo)
}