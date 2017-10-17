package com.xylink.model;

/**
 * Created by maolizhi on 12/19/2016.
 */
import java.io.Serializable;

public class MeetingInfo implements Serializable {
    private String meetingRoomState;
    private int autoMute;
    private int smartMutePerson;
    private boolean autoRecord;

    public MeetingInfo() {
    }

    public String getMeetingRoomState() {
        return this.meetingRoomState;
    }

    public void setMeetingRoomState(String meetingRoomState) {
        this.meetingRoomState = meetingRoomState;
    }

    public int getAutoMute() {
        return this.autoMute;
    }

    public void setAutoMute(int autoMute) {
        this.autoMute = autoMute;
    }

    public int getSmartMutePerson() {
        return this.smartMutePerson;
    }

    public void setSmartMutePerson(int smartMutePerson) {
        this.smartMutePerson = smartMutePerson;
    }

    public boolean isAutoRecord() {
        return this.autoRecord;
    }

    public void setAutoRecord(boolean autoRecord) {
        this.autoRecord = autoRecord;
    }

    public String toString() {
        return "MeetingInfo{meetingRoomState=\'" + this.meetingRoomState + '\'' + ", autoMute=" + this.autoMute + ", smartMutePerson=" + this.smartMutePerson + ", autoRecord=" + this.autoRecord + '}';
    }
}
