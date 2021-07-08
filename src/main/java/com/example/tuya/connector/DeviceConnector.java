package com.example.tuya.connector;

import com.tuya.connector.api.annotations.GET;
import com.tuya.connector.api.annotations.Path;

import java.util.Map;

public interface DeviceConnector {

    @GET("/v1.0/iot-03/devices/{device_id}")
    Map<Object, Object> getById(@Path("device_id") String id);
}
