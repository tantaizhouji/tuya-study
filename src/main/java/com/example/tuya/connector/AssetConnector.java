package com.example.tuya.connector;

import com.example.tuya.model.PageAssetRes;
import com.tuya.connector.api.annotations.GET;
import com.tuya.connector.api.annotations.Query;

/**
 * 资产连接器
 *
 * @author Mario
 * @since 2021/7/14 8:17 下午
 */
public interface AssetConnector {

    @GET("/v1.0/iot-03/users/assets")
    PageAssetRes assets(@Query("parent_asset_id") String parentAssetId,
                        @Query("page_no") Integer pageNo,
                        @Query("page_size") Integer pageSize);
}
