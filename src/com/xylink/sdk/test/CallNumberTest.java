package com.xylink.sdk.test;

import com.xylink.sdk.enterpriseNemo.CallNumberApi;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by changxiangyang on 2017/9/19.
 */
public class CallNumberTest {
    //获取小鱼号信息
    @Test
    public void getCallNumberInfo(){
        CallNumberApi cna=new CallNumberApi();
        String enterpriseid="fadfadfadfasdfadsfasdfa";
        String token = "fsdfasjdfkajfkadfajdfajf";
        String number="702301";
        try {
            cna.getCallNumberInfo(enterpriseid, token,number);
        }catch (IOException e){
            System.out.println("testEnd--"+e);
        }
    }
}
