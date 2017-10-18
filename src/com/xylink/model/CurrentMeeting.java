package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by wenya on 17/6/27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentMeeting {

    private String meetingRoomNumber;
    private long startTime;
    private int participantCount;
    private String scheduledMeetingId;

    public String getMeetingRoomNumber() {
        return meetingRoomNumber;
    }

    public void setMeetingRoomNumber(String meetingRoomNumber) {
        this.meetingRoomNumber = meetingRoomNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public String getScheduledMeetingId() {
        return scheduledMeetingId;
    }

    public void setScheduledMeetingId(String scheduledMeetingId) {
        this.scheduledMeetingId = scheduledMeetingId;
    }
}
