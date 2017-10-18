package com.xylink.sdk.test;


import com.xylink.config.SDKConfigMgr;
import com.xylink.model.*;
import com.xylink.sdk.conferenceControl.ConferenceControlApi;
import com.xylink.sdk.conferenceControl.CreateMeetingApi;
import com.xylink.util.Result;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//import java.beans.Transient;

/**
 * Created by wenya on 17/9/13.
 */
public class ConferenceControlTest {

    private static SdkMeeting sdkMeeting = null;
    private String enterpriseid = "3807773d9c7d3b70351a1dcb92c08e9558eeb6d9";
    private String token = "72bcc56c87169cac623acb8d5c28dd1053cd0d9cc96dc57cab3ee5cb6a88774c";
    private String callNumber ="913581819843";
    private String nemoNumber ="702301";

    @BeforeClass
    public static void setup() {
        SDKConfigMgr.setServerHost("https://cloud.xylink.com");
    }

    @Test
    public void testCreateRoom() {
        CreateMeetingApi createMeetingApi = new CreateMeetingApi();
        SdkMeetingReq sdkMeetingReq = new SdkMeetingReq();
        sdkMeetingReq.setMeetingName("test");
        try {
            sdkMeeting = createMeetingApi.createMeeting(enterpriseid, token,
                    sdkMeetingReq);
            assertNotNull(sdkMeeting);
            assertNotNull(sdkMeeting.getMeetingNumber());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void InviteCall() {
        ConferenceControlApi cca=new ConferenceControlApi();

        CallInviteRequest callInviteRequest=new CallInviteRequest();
        List<DeviceInfo> devices=new ArrayList<DeviceInfo>();
        DeviceInfo device=new DeviceInfo();
        device.setNumber(nemoNumber);
        devices.add(device);
        callInviteRequest.setCallNumber(callNumber);
        callInviteRequest.setDeviceList(devices);
        Result result=null;
        try {
            result = cca.inviteCall(enterpriseid, token, callInviteRequest);
        }catch (IOException e){
            fail(e.getMessage());
        }
        int errStatus = result.getErrorStatus();
        assertEquals(200, errStatus);
    }
    @Test
    public void getMeetingStatus(){
        ConferenceControlApi cca=new ConferenceControlApi();
        try {
             Result<MeetingStatus> meetingStatus = cca.getMeetingStatus(enterpriseid, token, callNumber);
             assertNotNull(meetingStatus);
        }catch (IOException e){
            fail(e.getMessage());
        }
    }

    //邀请一个设备进入会议
    @Test
    public void inviteNemoCall(){
        ConferenceControlApi cca=new ConferenceControlApi();

        MeetingRoom  meetingRoomNo =new MeetingRoom();
        meetingRoomNo.setMeetingRoomNumber(callNumber);
        Result result=null;
        try {
            result= cca.inviteNemoCall(enterpriseid, token, nemoNumber,meetingRoomNo);
        }catch (IOException e){
            e.printStackTrace();
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        assertTrue(isSuccess);
    }

    //设置主画面
    @Test
    public void setMainImage(){
        ConferenceControlApi cca=new ConferenceControlApi();
        String meetingRoomNo = callNumber;
        Device device =new Device();
        device.setId(100120772);
        device.setType(2);
        device.setParticipantNumber(nemoNumber);
        device.setExternalUserId(null);
        Result result=null;
        try {
            result = cca.setMainImage(enterpriseid, token, meetingRoomNo,device);
        }catch (IOException e){
            fail(e.getMessage());
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        assertTrue(isSuccess);
    }
    //获取某公司当前正在进行的会议
    @Test
    public void getEnterpriseCurrentMeeting(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Result<CurrentMeeting[]> result=null;
        try {
            result = cca.getEnterpriseCurrentMeeting(enterpriseid, token);
        }catch (IOException e){
            e.printStackTrace();
            fail(e.getMessage());
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        assertTrue(isSuccess);
        CurrentMeeting [] currentMeetings= result.getData();
        for(CurrentMeeting currentMeeting:currentMeetings){
            System.out.println("===="+currentMeeting.getMeetingRoomNumber());
        }
        if(errStatus<300){
            System.out.println("测试成功！"+errStatus);
        }else {
            System.out.println("测试失败！"+errStatus);
        }
    }
    //静音
    @Test
    public void mute(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Device device=new Device();
        device.setId(100120772);
        device.setType(2);
        device.setParticipantId("393344");
        device.setParticipantNumber("702301");
        device.setExternalUserId(null);
        Device[] devices={device};
        Result result=null;
        try {
            result = cca.mute(enterpriseid, token,callNumber,devices);
        }catch (IOException e){
            System.out.println("testMute--"+e);
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        if(errStatus<300){
            System.out.println("测试成功！"+errStatus);
        }else {
            System.out.println("测试失败！"+errStatus);
        }
    }
    //全部静音
    @Test
    public void muteall(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Result result=null;
        try {
            result = cca.muteall(enterpriseid, token,callNumber);
        }catch (IOException e){
            System.out.println("testMuteall--"+e);
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        if(errStatus<300){
            System.out.println("测试成功！"+errStatus);
        }else {
            System.out.println("测试失败！"+errStatus);
        }
    }
    //取消静音
    @Test
    public void unmute(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Device device=new Device();
        device.setId(100120772);
        device.setType(2);
        device.setParticipantId("393344");
        device.setParticipantNumber("702301");
        device.setExternalUserId(null);
        Device[] devices={device};
        Result result=null;
        try {
            result = cca.unmute(enterpriseid, token,callNumber,devices);
        }catch (IOException e){
            System.out.println("testUnmute--"+e);
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        if(errStatus<300){
            System.out.println("测试成功！"+errStatus);
        }else {
            System.out.println("测试失败！"+errStatus);
        }
    }
    //结束会议
    @Test
    public void end(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Result result=null;
        try {
            result =
                    cca.end(enterpriseid, token,callNumber);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        if(errStatus<300){
            System.out.println("测试成功！"+errStatus);
        }else {
            System.out.println("测试失败！"+errStatus);
        }
    }
    //结束会议
    @Test
    public void endandrelease(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Result result=null;
        try {
            result = cca.endAndReleaseNumber(enterpriseid, token,callNumber);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        if(errStatus<300){
            System.out.println("测试成功！"+errStatus);
        }else {
            System.out.println("测试失败！"+errStatus);
        }
    }
    //发通知
    @Test
    public void notifyDevice(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Device device=new Device();
        device.setId(100120772);
        device.setType(2);
        device.setParticipantId("393344");
        device.setParticipantNumber("702301");
        device.setExternalUserId(null);
        List<Device> devices=new ArrayList<Device>();
        devices.add(device);
        DeviceNotification deviceNotification=new DeviceNotification();
        deviceNotification.setDeviceList(devices);
        deviceNotification.setContent("我二哈恶搞");
        deviceNotification.setNotificationType(1);
        Result result=null;
        try {
            result = cca.notifyDevice(enterpriseid, token,deviceNotification);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        if(errStatus<300){
            System.out.println("测试成功！"+errStatus);
        }else {
            System.out.println("测试失败！"+errStatus);
        }
    }
    //授权分享权限
    @Test
    public void contentAuthShare(){
        ConferenceControlApi cca=new ConferenceControlApi();
        ShareAuthTarget sat=new ShareAuthTarget();
        Device device=new Device();
        device.setId(100120772);
        device.setType(2);
        device.setParticipantId("393344");
        device.setParticipantNumber("702301");
        device.setExternalUserId(null);
        Device[] devices={device};
        sat.setIsAll(false);
        sat.setDevice(device);
        Result result=null;
        try {
            result = cca.authShare(enterpriseid, token,callNumber,sat);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
        if(result!=null) {
            int errStatus = result.getErrorStatus();
            boolean isSuccess = result.isSuccess();
            if (errStatus < 300) {
                System.out.println("测试成功！" + errStatus);
            } else {
                System.out.println("测试失败！" + errStatus);
            }
        }
    }
    //会议锁定
    @Test
    public void lock(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Result result=null;
        try {
            result = cca.meetingLock(enterpriseid, token,callNumber);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        if(errStatus<300){
            System.out.println("测试成功！"+errStatus);
        }else {
            System.out.println("测试失败！"+errStatus);
        }
    }
    //会议解锁
    @Test
    public void unlock(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Result result=null;
        try {
            result = cca.meetingUnlock(enterpriseid, token,callNumber);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
        int errStatus = result.getErrorStatus();
        boolean isSuccess = result.isSuccess();
        if(errStatus<300){
            System.out.println("测试成功！"+errStatus);
        }else {
            System.out.println("测试失败！"+errStatus);
        }
    }
    //发送消息
    @Test
    public void sendMsg(){
        ConferenceControlApi cca=new ConferenceControlApi();
        MeetingSubtitleRequest msr=new MeetingSubtitleRequest();
        Device device=new Device();
        device.setId(100120772);
        device.setType(2);
        device.setParticipantId("393344");
        device.setParticipantNumber("702301");
        device.setExternalUserId(null);
        Device[] devices={device};
        msr.setDevices(devices);
        MeetingSubtitle meetingSubtitle =new MeetingSubtitle();
        meetingSubtitle.setContent("发月闭关！！！");
        meetingSubtitle.setLocation("middle");
        meetingSubtitle.setAction("cancel");
        meetingSubtitle.setScroll("1");
        msr.setMeetingSubtitle(meetingSubtitle);
        Result result=null;
        try {
            result = cca.sendMessage(enterpriseid, token,callNumber, msr);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
        if(result!=null) {
            int errStatus = result.getErrorStatus();
            boolean isSuccess = result.isSuccess();
            if (errStatus < 300) {
                System.out.println("测试成功！" + errStatus);
            } else {
                System.out.println("测试失败！" + errStatus);
            }
        }
    }
    //删除人员：在会议过程中删除与会人员
    @Test
    public void disconnect(){
        ConferenceControlApi cca=new ConferenceControlApi();
        Device device =new Device();
        device.setId(20358075);
        device.setType(2);
//        device.setParticipantId("393344");
        device.setParticipantNumber("852369");
        device.setExternalUserId(null);
        Device[] devices={device};
        Result result=null;
        try {
            result = cca.disconnect(enterpriseid, token, callNumber,devices);
        }catch (IOException e){
            fail(e.getMessage());
        }
    }
}
