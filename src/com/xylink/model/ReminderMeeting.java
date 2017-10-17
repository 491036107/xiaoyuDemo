package com.xylink.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by maolizhi on 12/16/2016.
 */

public class ReminderMeeting implements Serializable {
    private String id;
    private long startTime;
    private long endTime;
    private String title;
    private String address;
    private String details;
    private long owner;
    private int autoInvite;
    private String conferenceNumber;
    private long createTime;
    private String password;
    private String conferenceControlPassword;
    private Set<String> participants = new HashSet<String>();
    private int week;
    private int meetingRoomType = -1;
    private int autoRecord;

    public ReminderMeeting() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    public int getAutoInvite() {
        return autoInvite;
    }

    public void setAutoInvite(int autoInvite) {
        this.autoInvite = autoInvite;
    }

    public String getConferenceNumber() {
        return conferenceNumber;
    }

    public void setConferenceNumber(String conferenceNumber) {
        this.conferenceNumber = conferenceNumber;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Set<String> getParticipants() {return participants;}

    public void setParticipants(Set<String> participants) {this.participants = participants;}

    public int getWeek() {return week;}

    public void setWeek(int week) {this.week = week;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMeetingRoomType() {
        return meetingRoomType;
    }

    public void setMeetingRoomType(int meetingRoomType) {
        this.meetingRoomType = meetingRoomType;
    }

    public String getConferenceControlPassword() {
        return conferenceControlPassword;
    }

    public void setConferenceControlPassword(String conferenceControlPassword) {
        this.conferenceControlPassword = conferenceControlPassword;
    }

    public int getAutoRecord() {
        return autoRecord;
    }

    public void setAutoRecord(int autoRecord) {
        this.autoRecord = autoRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReminderMeeting that = (ReminderMeeting) o;

        if (startTime != that.startTime) return false;
        if (endTime != that.endTime) return false;
        if (owner != that.owner) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!title.equals(that.title)) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        return conferenceNumber != null ? conferenceNumber.equals(that.conferenceNumber) : that.conferenceNumber == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (int) (startTime ^ (startTime >>> 32));
        result = 31 * result + (int) (endTime ^ (endTime >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (int) (owner ^ (owner >>> 32));
        result = 31 * result + (conferenceNumber != null ? conferenceNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReminderMeeting{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", details='" + details + '\'' +
                ", owner=" + owner +
                ", autoInvite=" + autoInvite +
                ", conferenceNumber='" + conferenceNumber + '\'' +
                ", createTime=" + createTime +
                ", participants=" + participants +
                ", week=" + week +
                ", meetingRoomType=" + meetingRoomType +
                ", autoRecord=" + autoRecord +
                '}';
    }
}
