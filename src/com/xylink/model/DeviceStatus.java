package com.xylink.model;

/**
 * Created by maolizhi on 12/12/2016.
 */
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceStatus implements Serializable {
    private String name;
    private int muteStatus;
    private Device device;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMuteStatus() {
        return muteStatus;
    }

    public void setMuteStatus(int muteStatus) {
        this.muteStatus = muteStatus;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}

