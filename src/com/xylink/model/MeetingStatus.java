package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mlz on 12/12/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingStatus implements Serializable {
    private String meetingRoomNumber;
    private String meetingName;
    private int mode = 0;
    private Device mainVenue;
    private Device mainImage;
    List<DeviceStatus> deviceStatusList;
    List<Device> handUpList;

    public String getMeetingRoomNumber() {
        return meetingRoomNumber;
    }

    public void setMeetingRoomNumber(String meetingRoomNumber) {
        this.meetingRoomNumber = meetingRoomNumber;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public List<DeviceStatus> getDeviceStatusList() {
        return deviceStatusList;
    }

    public void setDeviceStatusList(List<DeviceStatus> deviceStatusList) {
        this.deviceStatusList = deviceStatusList;
    }

    public List<Device> getHandUpList() {
        return handUpList;
    }

    public void setHandUpList(List<Device> handUpList) {
        this.handUpList = handUpList;
    }

    public void setMainVenue(Device mainVenue) {
        this.mainVenue = mainVenue;
    }

    public Device getMainVenue() {
        return mainVenue;
    }

    public Device getMainImage() {
        return mainImage;
    }

    public void setMainImage(Device mainImage) {
        this.mainImage = mainImage;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }
}
