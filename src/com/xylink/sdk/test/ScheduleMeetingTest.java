package com.xylink.sdk.test;

import com.xylink.model.ReminderMeeting;
import com.xylink.sdk.dating.ScheduleMeetingApi;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by changxiangyang on 2017/9/19.
 */
public class ScheduleMeetingTest {
    //预约会议
    @Test
    public void remindMeeting(){
        ScheduleMeetingApi sma=new ScheduleMeetingApi();
        String enterpriseid="fadfadfadfasdfadsfasdfa";
        String token = "fsdfasjdfkajfkadfajdfajf";
        String callNumber ="702301";
        ReminderMeeting reminderMeeting=new ReminderMeeting();
        reminderMeeting.setStartTime(15058137777890l);
        reminderMeeting.setPassword("2345");
        reminderMeeting.setAddress("地中海");
        reminderMeeting.setAutoInvite(1);
        reminderMeeting.setAutoRecord(0);
        reminderMeeting.setEndTime(15058139897890l);
        int maxParticipantCount=5;
        try {
            sma.remindMeeting(enterpriseid, token,reminderMeeting,maxParticipantCount);
        }catch (IOException e){
            System.out.println("testRemindMeeting--"+e);
        }
    }
    //修改预约会议
    @Test
    public void updateMeeting(){
        ScheduleMeetingApi sma=new ScheduleMeetingApi();
        String enterpriseid="fadfadfadfasdfadsfasdfa";
        String token = "fsdfasjdfkajfkadfajdfajf";
        ReminderMeeting reminderMeeting=new ReminderMeeting();
        reminderMeeting.setStartTime(15058137777890l);
        reminderMeeting.setPassword("2345");
        reminderMeeting.setAddress("地中海");
        reminderMeeting.setAutoInvite(1);
        reminderMeeting.setAutoRecord(0);
        reminderMeeting.setEndTime(15058139897890l);
        int maxParticipantCount=5;
        String meetingId = "34436";
        try {
            sma.updateMeeting(enterpriseid, token,meetingId,reminderMeeting,maxParticipantCount);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
    }
    //删除会议
    @Test
    public void deleteMeeting(){
        ScheduleMeetingApi sma=new ScheduleMeetingApi();
        String enterpriseid="fadfadfadfasdfadsfasdfa";
        String token = "fsdfasjdfkajfkadfajdfajf";
        String meetingId = "34436";
        try {
            sma.deleteMeeting(enterpriseid, token,meetingId);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
    }
    //按照结束时间获取会议
    @Test
    public void getAllMeeting(){
        ScheduleMeetingApi sma=new ScheduleMeetingApi();
        String enterpriseid="fadfadfadfasdfadsfasdfa";
        String token = "fsdfasjdfkajfkadfajdfajf";
        long endtime =15058139897890l;
        try {
            sma.getAllMeeting(enterpriseid, token,endtime);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
    }
}
