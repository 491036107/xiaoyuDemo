package com.xylink.sdk.test.suite;

import com.xylink.config.SDKConfigMgr;
import com.xylink.sdk.test.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by wenya on 17/9/13.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ConferenceControlTest.class,
                RecordingTest.class,
                CallNumberTest.class,
                CreateMeetingTest.class,
                DeviceStatusTest.class,
                ScheduleMeetingTest.class
        }
)
public class SDKTestSuite {

    @BeforeClass
    public static void beforeClass() {
            SDKConfigMgr.setServerHost("http://10.44.41.45:8080");
    }

}
