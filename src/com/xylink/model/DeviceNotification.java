package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wenya on 16/12/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceNotification implements Serializable {

    private List<Device> deviceList;

    private int notificationType;

    private String content;

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
