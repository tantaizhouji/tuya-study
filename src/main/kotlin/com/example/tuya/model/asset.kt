package com.example.tuya.model

data class PageAssetRes(val hasMore: Boolean, val assets: List<AssetRes>, val projectName: String)

data class AssetRes(
    val assetId: String,
    val assetName: String,
    val parentAssetId: String,
    val permission: String,
    val currentAssetDeviceNum: Int
)
   