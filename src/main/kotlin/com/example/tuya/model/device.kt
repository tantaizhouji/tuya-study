package com.example.tuya.model

data class DeviceRes(
    val id: String,
    val uuid: String,
    val category: String,
    val name: String,
    val productId: String,
    val productName: String,
    val localKey: String,
    val sub: Boolean,
    val assetId: String,
    val ip: String,
    val lon: String,
    val lat: String,
    val model: String,
    val timeZone: String,
    val activeTime: Long,
    val updateTime: Long,
    val createTime: Long,
    val online: Boolean
)

data class PageDeviceRes(val hasMore: Boolean, val total: Long, val list: List<DeviceRes>)

data class SubDeviceRes(
    val id: String,
    val name: String,
    val online: Boolean,
    val activeTime: Long,
    val updateTime: Long,
    val productId: String,
    val category: String,
    val nodeId: String,
    val assetId: String,
    val ico: String
)

data class DeviceStatusRes(val code: String, val value: Any)

data class DeviceUpdateReq(val name: String)
   