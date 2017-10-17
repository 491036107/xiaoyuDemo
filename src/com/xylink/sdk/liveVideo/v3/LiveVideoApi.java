package com.xylink.sdk.liveVideo.v3;

import com.xylink.config.SDKConfigMgr;
import com.xylink.model.*;
import com.xylink.util.HttpUtil;
import com.xylink.util.Result;
import com.xylink.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * created by maolizhi at 03/14/2017
 */
public class LiveVideoApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/liveVideo3/enterprise/";

    /**
     * shcedule a live for conference
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveVideo
     * @return
     * @throws IOException
     */
    public Result<LiveVideoForConference> scheduleLive(String enterpriseId, String token, String confNo, String confPwd, LiveVideo liveVideo) throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live?enterpriseId="+enterpriseId + "&confPwd=" + confPwd;
        String jsonEntity = new ObjectMapper().writeValueAsString(liveVideo);
        String signature = signatureSample.computeSignature(jsonEntity,"POST",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"POST", jsonEntity, LiveVideoForConference.class);
    }

    /**
     * update live
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd , it is can be empty
     * @param liveId
     * @param liveVideo
     * @return
     * @throws IOException
     */
    public Result updateLive(String enterpriseId,String token,String confNo,String confPwd,String liveId,LiveVideo liveVideo)
            throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live/" +liveId
                + "?enterpriseId="+enterpriseId + "&confPwd=" + confPwd;
        String jsonEntity = new ObjectMapper().writeValueAsString(liveVideo);
        String signature = signatureSample.computeSignature(jsonEntity,"PUT",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"PUT", jsonEntity, null);
    }

    /**
     * delete live
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveId
     * @return
     * @throws IOException
     */
    public Result deleteLive(String enterpriseId,String token,String confNo,String confPwd,String liveId)throws IOException{
        String surl = getPrefixUrl()  + enterpriseId + "/conf/" + confNo + "/live/" +liveId
                + "?enterpriseId="+enterpriseId + "&confPwd=" + confPwd;
        String signature = signatureSample.computeSignature("","DELETE",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"DELETE", null, null);
    }

    /**
     * get the live
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveId
     * @return
     * @throws IOException
     */
    public Result<LiveVideoForConference> getLive(String enterpriseId,String token,String confNo,String confPwd,String liveId) throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live/" +liveId
                + "?enterpriseId="+enterpriseId + "&confPwd=" + confPwd;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null, LiveVideoForConference.class);
    }

    /**
     * get video list for the live
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveId
     * @return
     * @throws IOException
     */
    public Result<Video[]> getLiveVideoList(String enterpriseId, String token, String confNo, String confPwd, String liveId) throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live/" +liveId + "/videoswithduration"
                + "?enterpriseId="+enterpriseId + "&confPwd=" + confPwd;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        System.out.println(surl);
        return HttpUtil.getResponse(surl,"GET", null, Video[].class);
    }

    /**
     * start/end the live
     * @param enterpriseId
     * @param token
     * @param confNo
     * @param confPwd
     * @param liveId
     * @param status
     * @return
     * @throws IOException
     */
    public Result controlLive(String enterpriseId, String token, String confNo, String confPwd, String liveId,Status status)throws IOException{
        String surl = getPrefixUrl() + enterpriseId + "/conf/" + confNo + "/live/" + liveId + "/status"
                + "?enterpriseId="+enterpriseId + "&confPwd=" + confPwd;
        String jsonEntity = new ObjectMapper().writeValueAsString(status);
        String signature = signatureSample.computeSignature(jsonEntity,"PUT",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"PUT", jsonEntity, null);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }

    public static void main(String[] args) throws Exception {
        Status status = new Status();
        status.setStatus("start");
        new LiveVideoApi().controlLive("662782757532540cd3c2908206cb3d9398d68980", "8fd2c02d20b6b91e541f1227810f6351466a1022a8abfae3255bfd104f808a74",
                "913683308827", "", "ff8080815d914ccd015da12c05d0628f", status);
    }
}
