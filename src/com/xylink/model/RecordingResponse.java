package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by maolizhi on 4/7/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordingResponse  implements Serializable {
    private RecordingStatusResponse recordingStatusResponse;
    private String downLoadRestApi;

    public RecordingResponse() {
    }

    public RecordingResponse(RecordingStatusResponse recordingStatusResponse, String downLoadRestApi) {
        this.recordingStatusResponse = recordingStatusResponse;
        this.downLoadRestApi = downLoadRestApi;
    }

    public RecordingStatusResponse getRecordingStatusResponse() {
        return recordingStatusResponse;
    }

    public void setRecordingStatusResponse(RecordingStatusResponse recordingStatusResponse) {
        this.recordingStatusResponse = recordingStatusResponse;
    }

    public String getDownLoadRestApi() {
        return downLoadRestApi;
    }

    public void setDownLoadRestApi(String downLoadRestApi) {
        this.downLoadRestApi = downLoadRestApi;
    }
}
