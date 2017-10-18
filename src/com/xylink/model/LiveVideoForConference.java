package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by maolizhi on 3/14/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveVideoForConference {
    String liveId;
    String enterpriseId;
    String confNo;
    String status;
    String title;
    long startTime;
    long endTime;
    String detail;
    boolean autoRecording;
    boolean autoPublishRecording;
    String location;
    String flv;
    String hls;
    String viewUrl;

    public String getLiveId() {
        return liveId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public String getConfNo() {
        return confNo;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public String getDetail() {
        return detail;
    }

    public boolean isAutoRecording() {
        return autoRecording;
    }

    public boolean isAutoPublishRecording() {
        return autoPublishRecording;
    }

    public String getLocation() {
        return location;
    }

    public String getFlv() {
        return flv;
    }

    public String getHls() {
        return hls;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setLiveId(String liveId) {
        this.liveId = liveId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public void setConfNo(String confNo) {
        this.confNo = confNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setAutoRecording(boolean autoRecording) {
        this.autoRecording = autoRecording;
    }

    public void setAutoPublishRecording(boolean autoPublishRecording) {
        this.autoPublishRecording = autoPublishRecording;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFlv(String flv) {
        this.flv = flv;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }
}
