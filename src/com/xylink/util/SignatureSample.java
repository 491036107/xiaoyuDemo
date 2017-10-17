package com.xylink.util;

import com.xylink.config.SDKConfigMgr;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.*;

/**
 * Created by wenya on 16/9/10.
 */
public class SignatureSample {

    private String requestUriPrefix="/api/rest/external/v1/";

    protected String computeStringToSign(String requestPath, Map<String, String> reqParams, String reqJsonEntity, String reqMethod) throws Exception{
        String prefix = SDKConfigMgr.getServerHost() + requestUriPrefix;
        //1. request method
        StringBuffer strToSign = new StringBuffer(reqMethod);
        strToSign.append("\n");
        //2. request path
        strToSign.append(requestPath.substring(prefix.length()));
        strToSign.append("\n");
        //3. sorted request param and value
        List<String> params = new ArrayList<String>(reqParams.keySet());
        Collections.sort(params);
        for(String param : params) {
            strToSign.append(param);
            strToSign.append("=");
            strToSign.append(reqParams.get(param));
            strToSign.append("&");
        }
        strToSign.deleteCharAt(strToSign.length()-1);
        strToSign.append("\n");
        //4. request entity
        byte[] reqEntity = reqJsonEntity.getBytes("utf-8");
        printArray(reqEntity);
        if(reqEntity.length == 0) {
            byte[] entity = DigestUtils.sha256("");
            strToSign.append(Base64.encodeBase64String(entity));
        } else {
            byte[] data = null;
            if(reqEntity.length <= 100) {
                data = reqEntity;
            } else {
                data = Arrays.copyOf(reqEntity, 100);
            }
            byte[] entity = DigestUtils.sha256(data);
            printArray(entity);
            strToSign.append(Base64.encodeBase64String(entity));
        }

        String ret = strToSign.toString();
        System.out.println(ret);
        System.out.println("------------------");
        return ret;
    }

    private void printArray(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for(byte d : data) {
            sb.append(d);
            sb.append(",");
        }
        System.out.println(sb.toString());
    }

    private String calculateHMAC(String data, String key) throws SignatureException {
        try {
            SecretKeySpec e = new SecretKeySpec(key.getBytes("UTF8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(e);
            byte[] rawHmac = mac.doFinal(data.getBytes("UTF8"));
            String result = Base64.encodeBase64String(rawHmac);
            return result;
        } catch (Exception var6) {
            throw new SignatureException("Failed to generate HMAC : " + var6.getMessage());
        }
    }

    public String computeSignature(String jsonEntity, String method, String token, String reqPath) {
        try {
            Map<String, String> reqParams = new HashMap<String, String>();
            int idx = reqPath.indexOf("?");
            String[] params = reqPath.substring(idx + 1).split("&");
            for(String param : params) {
                String[] pair = param.split("=");
                reqParams.put(pair[0], pair[1]);
            }
            reqPath = reqPath.substring(0, idx);
            String strToSign = computeStringToSign(reqPath, reqParams, jsonEntity, method);
            String mySignature = calculateHMAC(strToSign, token);
            mySignature = mySignature.replace(" ", "+");
            return URLEncoder.encode(mySignature, "utf-8");
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        String url = "https://cloud.xylink.com/api/rest/external/v1/meetingroom/918813020407/vods?endTime=0&enterpriseId=123f7b15161e26feb231e45e96e457e7c2774a1b&startTime=0";
        String token = "6f1e0891d5b413900bbcf94be78e979368cf3789b9919bc59de4de729185bec0";
        String jsonEntity = "[{" +
                "\"title\":\"企业sdk测试\"," +
                "\"startTime\":177796400000," +
                "\"endTime\":1797803600000," +
                "\"participants\":[\"957140\"," +
                "\"469632\"" +
                "]," +
                "\"conferenceNumber\":\"915737369402\"," +
                "\"address\":\"北京\"," +
                "\"details\":\"1029d\"," +
                "\"autoInvite\":1" +
                "}]";
        System.out.println(new SignatureSample().computeSignature(jsonEntity, "GET", token, url));
        System.out.println(DigestUtils.md5Hex("QT1jZ3Albl3LiiErQFkhWuH2hVVEiKHkI+t6aBcxcPA="));

    }
}
