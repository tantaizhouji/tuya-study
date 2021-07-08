package com.example.tuya.connector;

import com.example.tuya.model.DeviceRes;
import com.example.tuya.model.DeviceStatusRes;
import com.example.tuya.model.DeviceUpdateReq;
import com.example.tuya.model.PageDeviceRes;
import com.example.tuya.model.SubDeviceRes;
import com.tuya.connector.api.annotations.Body;
import com.tuya.connector.api.annotations.GET;
import com.tuya.connector.api.annotations.PUT;
import com.tuya.connector.api.annotations.Path;
import com.tuya.connector.api.annotations.Query;

import java.util.List;
import java.util.Map;

/**
 * 设备连接器
 *
 * @author mario
 */
public interface DeviceConnector {

    /**
     * 根据设备ID修改设备名称
     *
     * @param id  设备ID
     * @param req 设备更新请求
     * @return true or false
     */
    @PUT("/v1.0/iot-03/devices/{device_id}")
    Boolean updateDevice(@Path("device_id") String id, @Body DeviceUpdateReq req);

    /**
     * 根据设备ID获取设备信息
     *
     * @param id 设备ID
     * @return 设备信息
     */
    @GET("/v1.0/iot-03/devices/{device_id}")
    DeviceRes getById(@Path("device_id") String id);

    /**
     * 根据设备ID列表获取多个设备信息
     *
     * @param ids 设备ID列表
     * @return 多个设备信息
     */
    @GET("/v1.0/iot-03/devices")
    PageDeviceRes getByIds(@Query("device_ids") String ids);

    /**
     * 根据设备ID获取设备状态
     *
     * @param id 设备ID
     * @return 设备状态
     */
    @GET("/v1.0/iot-03/devices/{device_id}/status")
    List<DeviceStatusRes> getStatusById(@Path("device_id") String id);

    /**
     * 根据设备ID获取该设备下的自设备列表
     *
     * @param id 设备ID
     * @return 子设备列表
     */
    @GET("/v1.0/iot-03/devices/{device_id}/sub-devices")
    List<SubDeviceRes> getSubById(@Path("device_id") String id);

    /**
     * 根据资产ID分页获取该资产下的所有设备信息
     *
     * @param id         资产ID
     * @param pageSize   每页最后一条数据行号
     * @param lastRowKey 每页大小
     * @return 分页设备信息
     */
    @GET("/v1.0/iot-02/assets/{asset_id}/devices")
    Map<Object, Object> getByAssetId(@Path("asset_id") String id,
                                     @Query("page_size") Integer pageSize,
                                     @Query("last_row_key") String lastRowKey);
}
