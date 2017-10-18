package com.xylink.sdk.test;

/**
 * Created by wenya on 17/9/13.
 */
public class TestConfig {

    private final String enterpriseId;

    private final String token;

    private static TestConfig testConfig = new TestConfig("fadfadfadfasdfadsfasdfa",
            "fsdfasjdfkajfkadfajdfajf");

    private TestConfig(String enterpriseId, String token) {
        this.enterpriseId = enterpriseId;
        this.token = token;
    }

    public static TestConfig getInstance() {
        return testConfig;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public String getToken() {
        return token;
    }
}
