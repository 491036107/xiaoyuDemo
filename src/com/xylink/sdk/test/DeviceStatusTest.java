package com.xylink.sdk.test;

import com.xylink.sdk.device.DeviceStatusApi;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by changxiangyang on 2017/9/19.
 */
public class DeviceStatusTest {
    //按照nemoNo
    @Test
    public void getDeviceInfo(){
        DeviceStatusApi dsa=new DeviceStatusApi();
        String enterpriseid="fadfadfadfasdfadsfasdfa";
        String token = "fsdfasjdfkajfkadfajdfajf";
        String number="689509";
        try {
            dsa.getDeviceInfo(enterpriseid, token);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
    }
    //获取所有鱼类状态
    @Test
    public void getDeviceInfos(){
        DeviceStatusApi dsa=new DeviceStatusApi();
        String enterpriseid="fadfadfadfasdfadsfasdfa";
        String token = "fsdfasjdfkajfkadfajdfajf";
        try {
            dsa.getDeviceInfo(enterpriseid, token);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
    }
    //通过sn列表查询设备信息
    @Test
    public void getDeviceInfoBySn(){
        DeviceStatusApi dsa=new DeviceStatusApi();
        String enterpriseid="fadfadfadfasdfadsfasdfa";
        String token = "fsdfasjdfkajfkadfajdfajf";
        List<String> snLst=new ArrayList<String>();
        snLst.add("2D1510907");
        try {
            dsa.getDeviceInfo(enterpriseid, token,snLst);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
    }
}
