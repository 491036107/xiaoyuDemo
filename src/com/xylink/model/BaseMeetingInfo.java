package com.xylink.model;

import java.io.Serializable;

/**
 * Created by wenya on 17/9/9.
 */
public class BaseMeetingInfo implements Serializable{

    private String meetingRoomState;
    private int autoMute;
    private String meettingRoomName;
    private long expireTime;
    private String password;
    private String meetingControlPwd;

    public String getMeetingRoomState() {
        return meetingRoomState;
    }

    public void setMeetingRoomState(String meetingRoomState) {
        this.meetingRoomState = meetingRoomState;
    }

    public int getAutoMute() {
        return autoMute;
    }

    public void setAutoMute(int autoMute) {
        this.autoMute = autoMute;
    }

    public String getMeettingRoomName() {
        return meettingRoomName;
    }

    public void setMeettingRoomName(String meettingRoomName) {
        this.meettingRoomName = meettingRoomName;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMeetingControlPwd() {
        return meetingControlPwd;
    }

    public void setMeetingControlPwd(String meetingControlPwd) {
        this.meetingControlPwd = meetingControlPwd;
    }

    @Override
    public String toString() {
        return "MeetingInfo{" +
                "meetingRoomState='" + meetingRoomState + '\'' +
                ", autoMute=" + autoMute +
                ", meettingRoomName=" + meettingRoomName +
                ", expireTime=" + expireTime +
                '}';
    }

}
