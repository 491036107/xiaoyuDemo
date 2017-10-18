package com.xylink.sdk.test;

import com.xylink.config.SDKConfigMgr;
import com.xylink.model.MeetingInfo;
import com.xylink.model.SdkMeetingReq;
import com.xylink.sdk.conferenceControl.CreateMeetingApi;
import com.xylink.util.Result;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by changxiangyang on 2017/9/19.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateMeetingTest {

    private String roomNumber = "910012345678";
    String enterpriseid="fd6c3449651e5eb25c80c38bde20be0aa5e9ab33";
    String token = "ba7868558b63eb2eea22a072c422397cfec7d1f58eaa301fa86ffa15b9929a1e";

    @BeforeClass
    public static void setup() {
        SDKConfigMgr.setServerHost("http://10.165.127.50:8080");
    }

    //创建会议
    @Test
    public void createMeeting(){
        CreateMeetingApi cma=new CreateMeetingApi();
        SdkMeetingReq smr=new SdkMeetingReq();
        smr.setAutoRecord(false);
        smr.setDuration(153435);
        smr.setMaxParticipantCount(5);
        smr.setMeetingName("room1");
        smr.setMeetingNumber(roomNumber);
        smr.setPassword("123456");
        smr.setStartTime(System.currentTimeMillis());
        try {
            cma.createMeeting(enterpriseid, token, smr);
        }catch (IOException e){
            System.out.println("testgetMeetingStatus--"+e);
        }
    }
    //按照会议号查询会议信息
    @Test
    public void getMeetingInfo(){
        CreateMeetingApi cma=new CreateMeetingApi();

        Result<MeetingInfo> result=null;
        try {
            result=cma.getMeetingInfo(enterpriseid, token, roomNumber);
        }catch (IOException e){
            e.printStackTrace();
            fail(e.getMessage());
        }
        if(result.getErrorStatus()<300) {
            if (result != null) {
                MeetingInfo meetingInfo = result.getData();
                assertEquals(meetingInfo.getMeettingRoomName(), "room1");
            }
        }else{
            fail(result.getErrorStatus() + "");
        }
    }
    //修改会议信息
    @Test
    public void updateMeetingInfo(){
        CreateMeetingApi cma=new CreateMeetingApi();
        MeetingInfo meetingInfo=new MeetingInfo();
        meetingInfo.setAutoRecord(false);
        meetingInfo.setAutoMute(2);
//        meetingInfo.setMeettingRoomName("aaaa");
        try {
            Result result = cma.updateMeetingInfo(enterpriseid, token, roomNumber,meetingInfo);
            assertEquals(200, result.getErrorStatus());
        }catch (IOException e){
            fail(e.getMessage());
        }
        try {
            Result<MeetingInfo> result = cma.getMeetingInfo(enterpriseid, token, roomNumber);
            meetingInfo = result.getData();
            assertEquals(result.getData().getAutoMute(), 2);
            assertFalse(result.getData().isAutoRecord());
        } catch (IOException e) {
            fail(e.getMessage());
        }

        meetingInfo.setMeettingRoomName("aaa");
        meetingInfo.setAutoRecord(true);
        try {
            Result result = cma.updateMeetingInfo(enterpriseid, token, roomNumber,meetingInfo);
            assertEquals(200, result.getErrorStatus());
        }catch (IOException e){
            fail(e.getMessage());
        }

        try {
            Result<MeetingInfo> result = cma.getMeetingInfo(enterpriseid, token, roomNumber);
            assertEquals(result.getData().getMeettingRoomName(), "aaa");
            assertTrue(result.getData().isAutoRecord());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    //批量查询会议信息
    @Test
    public void getBatchMeetingInfo(){
        CreateMeetingApi cma=new CreateMeetingApi();
        String [] meetingRoomNos={roomNumber};
        try {
            cma.getBatchMeetingInfo(enterpriseid, token, meetingRoomNos);
        }catch (IOException e){
            System.out.println("testGetBatchMeetingInfo--"+e);
        }
    }
    //删除会议
    @Test
    public void xdeleteMeetingInfo(){
        CreateMeetingApi cma=new CreateMeetingApi();

        try {
            cma.deleteMeetingInfo(enterpriseid, token, roomNumber);
        }catch (IOException e){
            fail(e.getMessage());
        }
    }
    //查询某公司的sdk创建的会议
    @Test
    public void getSdkMeetingRooms(){
        CreateMeetingApi cma=new CreateMeetingApi();
        try {
            cma.getSdkMeetingRooms(enterpriseid, token);
        }catch (IOException e){
            fail(e.getMessage());
        }
    }

}
