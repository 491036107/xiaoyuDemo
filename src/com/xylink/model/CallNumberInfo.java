package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by wenya on 16/6/1.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallNumberInfo implements Serializable {

    private int callNumberType;//0 nemonumber, 1 conference number
    private String nemoSN;
    private String displayName;

    public enum CallNumberType {
        NemoNumber(0), ConferenceNumber(1);
        private int type;
        CallNumberType(int type) {
            this.type = type;
        }
        public int getType() {
            return type;
        }
    }

    public int getCallNumberType() {
        return callNumberType;
    }

    public void setCallNumberType(int callNumberType) {
        this.callNumberType = callNumberType;
    }

    public String getNemoSN() {
        return nemoSN;
    }

    public void setNemoSN(String nemoSN) {
        this.nemoSN = nemoSN;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
