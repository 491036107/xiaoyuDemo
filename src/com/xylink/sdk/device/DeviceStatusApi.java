package com.xylink.sdk.device;

import com.xylink.config.SDKConfigMgr;
import com.xylink.model.DeviceInfo;
import com.xylink.util.HttpUtil;
import com.xylink.util.Result;
import com.xylink.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maolizhi on 12/15/2016.
 * Nemo(Device) Status API
 */
public class DeviceStatusApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/deviceInfo";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * get one nemo status according to nemoNumber,if Result Object's success is true,the "data" type of Result is DeviceInfo;if not, the "data" type of Result is RestMessage
     * @param enterpriseId
     * @param token
     * @param number
     * @return
     * @throws IOException
     */
    public Result<DeviceInfo> getDeviceInfo(String enterpriseId,String token,String number) throws IOException{

        String surl = getPrefixUrl() + "/" + number + "?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,DeviceInfo.class);

    }

    /**
     * get all nemo status in the enterprise,if Result Object's success is true,the "data" type of Result is DeviceInfo[];if not, the "data" type of Result is RestMessage
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<DeviceInfo[]> getDeviceInfo(String enterpriseId,String token) throws IOException{

        String surl = getPrefixUrl()  + "?enterpriseId=" + enterpriseId;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,DeviceInfo[].class);

    }

    /**
     * 根据小鱼SN列表获取小鱼信息，所有的sn必须已经导入企业管理平台
     * @param enterpriseId
     * @param token
     * @param snList
     * @return
     * @throws IOException
     */
    public Result<DeviceInfo[]> getDeviceInfo(String enterpriseId, String token, List<String> snList) throws IOException {
        if(snList == null || snList.size() <= 0) {
            return null;
        }
        String surl = getPrefixUrl()  + "?enterpriseId=" + enterpriseId;
        String jsonEntity = objectMapper.writeValueAsString(snList);
        String signature = signatureSample.computeSignature(jsonEntity, "PUT", token, surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl, "PUT", jsonEntity, DeviceInfo[].class);
    }

    private String getPrefixUrl() {
        return SDKConfigMgr.getServerHost() + prefixUrl;
    }
}
