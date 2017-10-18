package com.xylink.sdk.test;

import com.xylink.config.SDKConfig;
import com.xylink.config.SDKConfigMgr;
import com.xylink.model.CallInviteRequest;
import com.xylink.model.DeviceInfo;
import com.xylink.model.MeetingStatus;
import com.xylink.sdk.conferenceControl.ConferenceControlApi;
import com.xylink.sdk.recordingControl.RecordingControlApi;
import com.xylink.util.Result;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by wenya on 17/9/25.
 */
public class RecordingTest {

    private static final String enterpriseid = TestConfig.getInstance().getEnterpriseId();
    private static final String token = TestConfig.getInstance().getToken();
    private static final String callNumber = "913466397075";

    @BeforeClass
    public static void setup() {
        SDKConfigMgr.setServerHost("http://10.165.127.50:8080");
    }

    @Test
    public void testStartRecord() {
        inviteCall();
        int count = 10;
        int retry = 0;
        while(retry ++ < 10) {
            MeetingStatus meetingStatus = getMeetingStatus();
            if(meetingStatus != null && meetingStatus.getDeviceStatusList() != null
                    && meetingStatus.getDeviceStatusList().size() > 0) {
                break;
            }
        }
        RecordingControlApi recordingControlApi = new RecordingControlApi();
        try {
            Result result = recordingControlApi.startRecording(TestConfig.getInstance().getEnterpriseId(),
                    TestConfig.getInstance().getToken(), callNumber);
            Assert.assertEquals(200, result.getErrorStatus());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
            recordingControlApi.stopRecording(TestConfig.getInstance().getEnterpriseId(),
                    TestConfig.getInstance().getToken(), callNumber);
        } catch (IOException e) {
            fail(e.getMessage());
        }

        end();
    }

    private MeetingStatus getMeetingStatus() {
        ConferenceControlApi cca=new ConferenceControlApi();

        try {
            Result<MeetingStatus> result = cca.getMeetingStatus(enterpriseid, token, callNumber);
            if(result.isSuccess()) {
                return result.getData();
            }
        }catch (IOException e){
            fail(e.getMessage());
        }

        return null;
    }

    private void inviteCall() {
        ConferenceControlApi cca=new ConferenceControlApi();
        CallInviteRequest callInviteRequest=new CallInviteRequest();
        List<DeviceInfo> devices=new ArrayList<DeviceInfo>();
        DeviceInfo device=new DeviceInfo();
        device.setNumber("702301");
        devices.add(device);
        callInviteRequest.setCallNumber(callNumber);
        callInviteRequest.setDeviceList(devices);

        try {
            cca.inviteCall(enterpriseid, token, callInviteRequest);
        }catch (IOException e){
            fail(e.getMessage());
        }
    }

    private void end() {
        ConferenceControlApi cca=new ConferenceControlApi();
        Result result=null;
        try {
            result =
                    cca.end(enterpriseid, token,callNumber);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
    }
}
