package com.xylink.sdk.vod;

import com.xylink.config.SDKConfigMgr;
import com.xylink.model.VodInfo;
import com.xylink.util.HttpUtil;
import com.xylink.util.Result;
import com.xylink.util.SignatureSample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by maolizhi on 12/18/2016.
 */
public class VodApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/";

    /**
     * get all videos int the day,startTime is greater than 0,startTime is less than endTime,
     * endTime-startTime is less than the millisecond number of one day.
     * @param enterpriseId
     * @param token
     * @param startTime
     * @param endTime
     * @return
     * @throws IOException
     */
    public Result<VodInfo[]> getVods(String enterpriseId, String token,long startTime,long endTime)throws IOException{
        String surl = getPrefixUrl()  + "vods?enterpriseId=" + enterpriseId + "&startTime=" + startTime + "&endTime="
                + endTime;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,VodInfo[].class);
    }

    /**
     * get the nemo's all videos, if startTime is less than or equal to 0,return the nemo's all videos,ignore endTime;
     * if startTime is greater than 0 ,the endTime must be bigger than the startTime;there is no other limits for
     * startTime and endTime
     * @param enterpriseId
     * @param token
     * @param nemoNumber
     * @param startTime
     * @param endTime
     * @return
     * @throws IOException
     */
    public Result<VodInfo[]> getNemoVods(String enterpriseId, String token,String nemoNumber,long startTime,
                              long endTime)throws IOException{
        String surl = getPrefixUrl()  + "nemo/"+nemoNumber+"/vods?enterpriseId=" + enterpriseId +
                "&startTime="+startTime+"&endTime="+endTime;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,VodInfo[].class);
    }

    /**
     * get all videos for the meeting room during the time ,the time limits is same as the method of
     * getNemoVods
     * @param enterpriseId
     * @param token
     * @param meetingRoomNumber
     * @param startTime
     * @param endTime
     * @return
     * @throws IOException
     */
    public Result<VodInfo[]> getMeetingRoomVods(String enterpriseId, String token,String meetingRoomNumber,long startTime,
                              long endTime)throws IOException{
        String surl = getPrefixUrl()  + "meetingroom/" + meetingRoomNumber + "/vods?enterpriseId=" + enterpriseId +
                "&startTime="+startTime+"&endTime="+endTime;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,VodInfo[].class);
    }

    /**
     * get video default thumbnail according to video id,
     * if success,the data type of result is byte[]; if failed ,the data type of result is
     * RestMessage. If success,you can convert the byte[] to image file.
     * @param enterpriseId
     * @param token
     * @param vodId
     * @return
     * @throws IOException
     */
    public Result getVodThumbnail(String enterpriseId, String token,String vodId)throws IOException{
        String surl = getPrefixUrl()  + "vods/"+ vodId+ "/thumbnail?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getByteStreamResponse(surl,"GET", null);
    }

    /**
     * convert byte array to image or video
     * @param bytes
     * @param path
     */
    public void convertByteArrayToImageOrVideo(byte[] bytes,String path){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            System.out.println("File Path not found!");
        } catch (IOException e) {
            System.out.println("Convert byte array to image,IO Errot!");
        }

    }

    /**
     * download the video according to video id
     * if success,the data type of result is byte[]; if failed ,the data type of result is
     * RestMessage. If success,you can call  convertByteArrayToImageOrVideo(byte[] bytes,String path)
     * convert the byte[] to video file.
     * @param enterpriseId
     * @param token
     * @param vodId
     * @return
     * @throws IOException
     */
    public Result videoDownload(String enterpriseId, String token,String vodId)throws IOException{
        String surl = getPrefixUrl()  + "vods/"+ vodId+ "/download?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getByteStreamResponse(surl,"GET", null);
    }

    /**
     * delete the video according to video id
     * @param enterpriseId
     * @param token
     * @param vodId
     * @return
     * @throws IOException
     */
    public  Result deleteVideo(String enterpriseId, String token,String vodId)throws IOException{
        String surl = getPrefixUrl()  + "vods/"+ vodId+ "?enterpriseId=" + enterpriseId ;
        String signature = signatureSample.computeSignature("","DELETE",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"DELETE", null,null);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
