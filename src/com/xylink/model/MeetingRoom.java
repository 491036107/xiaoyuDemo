package com.xylink.model;

/**
 * Created by maolizhi on 12/13/2016.
 */
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingRoom implements Serializable {
    private String meetingRoomNumber;
    private String nemoNumber;

    public MeetingRoom() {
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

    public String toString() {
        return "MeetingRoom{meetingRoomNumber=\'" + this.meetingRoomNumber + '\'' + ", nemoNumber=\'" + this.nemoNumber + '\'' + '}';
    }
}
