package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wenya on 16/10/10.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallInviteRequest implements Serializable {

    private List<DeviceInfo> deviceList;
    private String callNumber;

    public CallInviteRequest() {

    }

    public CallInviteRequest(List<DeviceInfo> deviceList, String callNumber) {
        this.callNumber = callNumber;
        this.deviceList = deviceList;
    }

    public List<DeviceInfo> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<DeviceInfo> deviceList) {
        this.deviceList = deviceList;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    @Override
    public String toString() {
        return "CallInviteRequest{" +
                ", callNumber='" + callNumber + '\'' +
                '}';
    }
}
