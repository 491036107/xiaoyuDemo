package com.xylink.sdk.conferenceControl;

import com.xylink.config.SDKConfigMgr;
import com.xylink.model.MeetingInfo;
import com.xylink.model.SdkMeeting;
import com.xylink.model.SdkMeetingReq;
import com.xylink.util.HttpUtil;
import com.xylink.util.Result;
import com.xylink.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by wenya on 16/12/29.
 */
public class CreateMeetingApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrlMeetingInfo = "/api/rest/external/v1/meetingInfo/";

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
    /**
     * get meeting room status,if success,the data type of Result is MeetingInfo;if failed ,
     * the data type of Result is RestMessage
     *
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @return
     * @throws IOException
     */
    public Result<MeetingInfo> getMeetingInfo(String enterpriseId, String token, String meetingRoomNumber) throws IOException {
        String surl = getMeetingInfoPrefixUrl() + meetingRoomNumber + "?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, MeetingInfo.class);
    }

    /**
     * update meeting room status
     *
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @param meetingInfo
     * @return
     * @throws IOException
     */
    public Result updateMeetingInfo(String enterpriseId, String token, String meetingRoomNumber,
                                    MeetingInfo meetingInfo) throws IOException {
        String surl = getMeetingInfoPrefixUrl() + meetingRoomNumber + "?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(meetingInfo);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, null);
    }

    /**
     * get meetingInfo array according to meeting room number array
     *
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumbers
     * @return
     * @throws IOException
     */
    public Result<MeetingInfo[]> getBatchMeetingInfo(String enterpriseId, String token, String[] meetingRoomNumbers)
            throws IOException {
        String surl = getMeetingInfoPrefixUrl() + "batch?enterpriseId=" + enterpriseId;
        String jsonEntity = new ObjectMapper().writeValueAsString(meetingRoomNumbers);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, MeetingInfo[].class);
    }

    /**
     * 通过会议室号删除会议室
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @return
     * @throws IOException
     */
    public Result deleteMeetingInfo(String enterpriseId, String token, String meetingRoomNumber) throws IOException {
        String surl = getMeetingInfoPrefixUrl() + meetingRoomNumber + "?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "DELETE", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "DELETE", null, null);
    }

    /**
     * 根据enterpriseId获取通过SDK建立的会议***
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<MeetingInfo> getSdkMeetingRooms(String enterpriseId, String token) throws IOException {
        String surl = getMeetingInfoPrefixUrl() + enterpriseId + "/meetingRoomInfo?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("", "GET", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "GET", null, MeetingInfo.class);
    }


    public static void main(String[] args) throws Exception {
        SdkMeetingReq sdkMeetingReq = new SdkMeetingReq();
        sdkMeetingReq.setMeetingName("test");
        CreateMeetingApi createMeetingApi = new CreateMeetingApi();
        SdkMeeting sdkMeeting = createMeetingApi.createMeeting("779632f52bf06fd8df7580e90b966a765fa3aa77",
                "b70888e280eda97eebc7e5510559dcf42414f77b4196b2fc7903c26740031575", sdkMeetingReq);
        System.out.println(sdkMeeting);
    }

    private String getMeetingInfoPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrlMeetingInfo;
    }
}
