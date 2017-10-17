package com.xylink.util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by maolizhi on 12/13/2016.
 */
public class HttpUtil {

    public static Result getResponse(String surl,String method,String jsonEntity,Class<?>clazz) throws IOException {
        HttpURLConnection conn = HttpUtil.getHttpURLConnection(jsonEntity,surl,method);
        InputStream is = null;
        int status = conn.getResponseCode();
        if(status == 200 || status == 204) {
            is = conn.getInputStream();
        }else{
            is = conn.getErrorStream();
        }
        String respData = HttpUtil.getResponseData(is);
        conn.disconnect();
        return getResult(status, respData,  clazz);
    }

    public static Result getByteStreamResponse(String surl,String method,String jsonEntity) throws IOException {
        HttpURLConnection conn = HttpUtil.getHttpURLConnection(jsonEntity,surl,method);
        InputStream is = null;
        int status = conn.getResponseCode();
        if(status == 200 || status == 204) {
            is = conn.getInputStream();
        }else{
            is = conn.getErrorStream();
        }
        byte[] bytes = HttpUtil.getStreamResponse(is);
        conn.disconnect();
        return getByteResult(status, bytes);
    }

    /**
     * convert byte array to image or video
     * @param bytes
     * @param path
     */
    public static void convertByteArrayToImageOrVideo(byte[] bytes,String path){
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


    private static  HttpURLConnection getHttpURLConnection(String jsonEntity,String surl, String method) throws IOException {
        URL url = new URL(surl);
        HttpURLConnection   conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.addRequestProperty("Accept", "application/json");
        conn.addRequestProperty("Accept-Charset", "UTF-8");
        conn.addRequestProperty("Content-Type", "application/json;charset=utf-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        if(jsonEntity != null && !"".equals(jsonEntity.trim())) {
            conn.getOutputStream().write(jsonEntity.getBytes("utf-8"));
        }
        conn.connect();
        return conn;
    }

    private static String getResponseData(InputStream is) throws IOException {
        if(is != null) {
            StringBuffer out = new StringBuffer();
            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1; ) {
                out.append(new String(b, 0, n));
            }
            return out.toString();
        }else{
            return "";
        }

    }


    private static Result getResult(int status, String respData, Class<?> clazz ) {
        ObjectMapper objectMapper = new ObjectMapper();
        int responseCode = 200;
        RestMessage restMessage = null;
        Result result = new Result();
        if(status == 200 || status == 204) {
            try {
                result.setSuccess(true);
                if(clazz != null) {
                    if(!clazz.getName().equals(String.class.getName())) {
                        if(respData != null && !"".equals(respData.trim()))
                        result.setData(objectMapper.readValue(respData, clazz));
                    }else{
                        result.setData(respData);
                    }
                }
                result.setErrorStatus(responseCode);
            } catch (Exception e) {
                System.out.println("JSon String convert to Object error!");
            }
        }else{
            try {
                restMessage = objectMapper.readValue(respData, RestMessage.class);
                responseCode = restMessage.getErrorCode();
                result.setSuccess(false);
                result.setData(restMessage);
                result.setErrorStatus(responseCode);
            }catch(Exception e){
                System.out.println("JSon String convert to RestMessage error!");
            }
        }

        return result;
    }




    private static byte[] getStreamResponse(InputStream is) throws IOException {
        if(is != null) {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024]; //buff用于存放循环读取的临时数据
            int rc = 0;
            while ((rc = is.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            byte[] bytes = swapStream.toByteArray(); //bytes为转换之后的结果
            return bytes;
        }
        return null;

    }

    private static Result getByteResult( int status, byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        int responseCode = 200;
        RestMessage restMessage = null;
        Result result = new Result();
        if(status == 200 || status == 204) {
            result.setSuccess(true);
            result.setData(bytes);
            result.setErrorStatus(200);

        }else{
            try {
                String respData = new String(bytes);
                restMessage = objectMapper.readValue(respData, RestMessage.class);
                responseCode = restMessage.getErrorCode();
                result.setSuccess(false);
                result.setData(restMessage);
                result.setErrorStatus(responseCode);
            }catch(Exception e){
                System.out.println("JSon String convert to RestMessage error!");
            }
        }

        return result;
    }

}
