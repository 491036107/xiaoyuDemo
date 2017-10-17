package com.xylink.config;

import com.xylink.util.SslUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wenya on 17/9/11.
 */
public class SDKConfigMgr {

    private static final String CONFIG_FILE = "/com/xylink/config/config.json";

    private static String DEFAULT_SERVER_HOST = "https://cloud.xylink.com";

    private static SDKConfig sdkConfig;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        sdkConfig = loadConfigs();
        if(sdkConfig == null) {
            sdkConfig = new SDKConfig();
            sdkConfig.setServerHost(DEFAULT_SERVER_HOST);
        }
    }

    public static String getServerHost() {
        return sdkConfig.getServerHost();
    }

    public static void setServerHost(String host) {
        if(host == null || host.trim().isEmpty()) {
            throw new IllegalArgumentException("host cannot be empty.");
        }
        if(!DEFAULT_SERVER_HOST.equals(host.toLowerCase().trim())) {
            try {
                SslUtils.ignoreSsl();
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to ignore ssl cert.", e);
            }
        }
        sdkConfig.setServerHost(host);
    }

    private static SDKConfig loadConfigs() {
        InputStream inputStream = SDKConfigMgr.class.getResourceAsStream(CONFIG_FILE);
        try {
            SDKConfig sdkConfig = objectMapper.readValue(inputStream, SDKConfig.class);
            return sdkConfig;
        } catch (IOException e) {
            return new SDKConfig();
        }
    }

    public static void main(String[] args) {
        SDKConfig sdkConfig = new SDKConfig();
        sdkConfig.setServerHost("http://localhost");
    }
}
