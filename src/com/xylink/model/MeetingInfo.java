package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by maolizhi on 12/19/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingInfo extends BaseMeetingInfo {

    private int smartMutePerson;
    private boolean autoRecord;

    public int getSmartMutePerson() {
        return smartMutePerson;
    }

    public void setSmartMutePerson(int smartMutePerson) {
        this.smartMutePerson = smartMutePerson;
    }

    public boolean isAutoRecord() {
        return autoRecord;
    }

    public void setAutoRecord(boolean autoRecord) {
        this.autoRecord = autoRecord;
    }

    @Override
    public String toString() {
        return "MeetingInfo{" +
                "meetingRoomState='" + getMeetingRoomState() + '\'' +
                ", autoMute=" + getAutoMute() +
                ", smartMutePerson=" + smartMutePerson +
                ", autoRecord=" + autoRecord +
                ", meettingRoomName=" + getMeettingRoomName() +
                ", expireTime=" + getExpireTime() +
                '}';
    }
}
