package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by maolizhi on 12/18/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VodInfo implements Serializable {
    private long vodId;
    private String displayName;
    private long startTime;
    private long endTime;
    private long fileSize;
    private String meetingRoomNumber;
    private String nemoNumber;

    public VodInfo() {
    }

    public long getVodId() {
        return this.vodId;
    }

    public void setVodId(long vodId) {
        this.vodId = vodId;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMeetingRoomNumber() {
        return this.meetingRoomNumber;
    }

    public void setMeetingRoomNumber(String meetingRoomNumber) {
        this.meetingRoomNumber = meetingRoomNumber;
    }

    public String getNemoNumber() {
        return this.nemoNumber;
    }

    public void setNemoNumber(String nemoNumber) {
        this.nemoNumber = nemoNumber;
    }
}

