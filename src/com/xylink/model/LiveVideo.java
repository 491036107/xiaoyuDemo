package com.xylink.model;

/**
 * Created by maolizhi on 12/15/2016.
 */
import org.apache.commons.lang3.StringUtils;

public class LiveVideo {
    public static final int TITLE_WIDTH = 32;
    public static final int DETAIL_WIDTH = 128;
    public static final int LOCATION_WIDTH = 64;

    private String enterpriseId;
    private String nemoNumber;
    private String confNo;

    private String title;
    private long startTime;
    private long endTime;
    private String detail;
    private boolean autoRecording;
    private boolean autoPublishRecording;
    private String location;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getNemoNumber() {
        return nemoNumber;
    }

    public void setNemoNumber(String nemoNumber) {
        this.nemoNumber = nemoNumber;
    }

    public String getConfNo() {
        return confNo;
    }

    public void setConfNo(String confNo) {
        this.confNo = confNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isAutoRecording() {
        return autoRecording;
    }

    public void setAutoRecording(boolean autoRecording) {
        this.autoRecording = autoRecording;
    }

    public boolean isAutoPublishRecording() {
        return autoPublishRecording;
    }

    public void setAutoPublishRecording(boolean autoPublishRecording) {
        this.autoPublishRecording = autoPublishRecording;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean valid(){
        long now = System.currentTimeMillis();
        if(now >= startTime){
            return false;
        }
        if(startTime >= endTime){
            return false;
        }

        if(StringUtils.isBlank(title)){
            return false;
        }
        if(title.length() > TITLE_WIDTH){
            return false;
        }

        if(!StringUtils.isBlank(detail) && detail.length() > DETAIL_WIDTH){
            return false;
        }

        if(!StringUtils.isBlank(location) && location.length() > LOCATION_WIDTH){
            return false;
        }

        return true;
    }

    public boolean invalid(){
        return !valid();
    }

    @Override
    public String toString() {
        return "LiveVideo{" +
                "enterpriseId='" + enterpriseId + '\'' +
                ", nemoNumber='" + nemoNumber + '\'' +
                ", confNo='" + confNo + '\'' +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", detail='" + detail + '\'' +
                ", autoRecording=" + autoRecording +
                ", autoPublishRecording=" + autoPublishRecording +
                ", location='" + location + '\'' +
                '}';
    }
}