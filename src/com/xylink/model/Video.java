package com.xylink.model;

public class Video {
    private String url;
    private long startTimestamp;
    private long endTimestamp;
    private long durationMs;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public long getDurationMs(){
        return endTimestamp-startTimestamp;
    }

    public void setDurationMs(long durationMs) {
        this.durationMs = durationMs;
    }
}
