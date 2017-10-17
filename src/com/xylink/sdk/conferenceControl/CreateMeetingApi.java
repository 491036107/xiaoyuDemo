package com.xylink.sdk.conferenceControl;

import com.xylink.config.SDKConfigMgr;
import com.xylink.model.SdkMeeting;
import com.xylink.model.SdkMeetingReq;
import com.xylink.util.HttpUtil;
import com.xylink.util.Result;
import com.xylink.util.SignatureSample;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by wenya on 16/12/29.
 */
public class CreateMeetingApi {

    /**
     * 创建会议
     * @param enterpriseId
     * @param token
     * @param sdkMeetingReq
     * @return
     */
    public SdkMeeting createMeeting(String enterpriseId, String token, SdkMeetingReq sdkMeetingReq) throws IOException{
        String url = SDKConfigMgr.getServerHost() + "/api/rest/external/v1/create_meeting?enterprise_id=" + enterpriseId;
        if(sdkMeetingReq == null || sdkMeetingReq.getMeetingName() == null) {
            return null;
        }
        url += "&meeting_name=" + URLEncoder.encode(sdkMeetingReq.getMeetingName(), "utf-8");
        url += "&start_time=" + sdkMeetingReq.getStartTime();
        url += "&end_time=" + (sdkMeetingReq.getStartTime() + sdkMeetingReq.getDuration());
        url += "&max_participant=" + sdkMeetingReq.getMaxParticipantCount();
        url += "&require_password=" + sdkMeetingReq.isRequirePassword();
        url += "&autoRecord=" + sdkMeetingReq.isAutoRecord();
        if(sdkMeetingReq.getPassword() != null && !sdkMeetingReq.getPassword().trim().isEmpty()) {
            url += "&password=" + sdkMeetingReq.getPassword();
        }
        if(sdkMeetingReq.getMeetingNumber() != null && !sdkMeetingReq.getMeetingNumber().trim().isEmpty()) {
            url += "&meetingNumber=" + sdkMeetingReq.getMeetingNumber();
        }

        String signature = new SignatureSample().computeSignature("", "GET", token, url);
        url += "&signature=" + signature;
        try {
            Result<SdkMeeting> sdkMeeting = HttpUtil.getResponse(url, "GET", "", SdkMeeting.class);
            if(sdkMeeting.isSuccess()) {
                return sdkMeeting.getData();
            } else {
                throw new RuntimeException(sdkMeeting.getErrorStatus() + "");
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        SdkMeetingReq sdkMeetingReq = new SdkMeetingReq();
        sdkMeetingReq.setMeetingName("zhangy_meeting");
        sdkMeetingReq.setPassword("123456");
        CreateMeetingApi createMeetingApi = new CreateMeetingApi();
        SdkMeeting sdkMeeting = createMeetingApi.createMeeting("662782757532540cd3c2908206cb3d9398d68980",
                "8fd2c02d20b6b91e541f1227810f6351466a1022a8abfae3255bfd104f808a74", sdkMeetingReq);
        System.out.println(sdkMeeting);
    }
}
