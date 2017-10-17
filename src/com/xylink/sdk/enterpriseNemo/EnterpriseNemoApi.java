package com.xylink.sdk.enterpriseNemo;
import com.xylink.config.SDKConfigMgr;
import com.xylink.model.NemoDto;
import com.xylink.util.HttpUtil;
import com.xylink.util.Result;
import com.xylink.util.SignatureSample;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

/**
 * created by maolizhi at 03/14/2017
 * get Enterprise Nemos
 */
public class EnterpriseNemoApi {
    private static SignatureSample signatureSample = new SignatureSample();
    private static final String prefixUrl = "/api/rest/external/v1/buffet/nemos";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * get enterprise all nemos(only nemo) acording to enterpriseId.
     * @param enterpriseId
     * @param token
     * @return
     * @throws IOException
     */
    public Result<NemoDto[]> getEnterpriseNemos(String enterpriseId, String token) throws IOException{

        String surl = SDKConfigMgr.getServerHost() + prefixUrl + "?enterprise_id=" + enterpriseId;
        String signature = signatureSample.computeSignature("","GET",token,surl);
        surl += "&signature=" + signature;
        return HttpUtil.getResponse(surl,"GET", null,NemoDto[].class);

    }

}
