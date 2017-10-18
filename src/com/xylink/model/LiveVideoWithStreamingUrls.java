package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by maolizhi on 12/15/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveVideoWithStreamingUrls extends LiveVideo{
    private String flv;
    private String hls;

    public String getFlv() {
        return flv;
    }

    public void setFlv(String flv) {
        this.flv = flv;
    }

    public String getHls() {
        return hls;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }

    @Override
    public String toString() {
        return "LiveVideoWithStreamingUrls{" +
                "flv='" + flv + '\'' +
                ", hls='" + hls + '\'' +
                "} " + super.toString();
    }
}
