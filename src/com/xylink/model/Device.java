package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

/**
 * Created by mlz on 9/12/16.
 */
public class Device implements Serializable {

    public static final int TYPE_SOFT = 1;
    public static final int TYPE_HARD = 2;
    public static final int TYPE_DESK = 5;
    public static final int TYPE_H323 = 6;
    public static final int TYPE_BRUCE = 7;
    public static final int TYPE_TVBOX = 8;

    private  long id;
    private  int type;
    private  String participantId;
    private String externalUserId;
    private String participantNumber;

    public Device() {

    }

    public Device(long id, int type) {
        this.id = id;
        this.type = type;
    }


    boolean isHardDevice() {
        return this.type == 2;
    }

    boolean isSoftDevice() {
        return this.type == 1;
    }

    boolean isDeskDevice() {
        return type == TYPE_DESK;
    }
    @JsonIgnore
    public boolean isH323Device() {
        return type == TYPE_H323;
    }
    @JsonIgnore
    public boolean isBruceDevice() {
        return type == TYPE_BRUCE;
    }
    @JsonIgnore
    public boolean isTvBox() {
        return type == TYPE_TVBOX;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getExternalUserId() {
        return externalUserId;
    }

    public void setExternalUserId(String externalUserId) {
        this.externalUserId = externalUserId;
    }

    public String getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(String participantNumber) {
        this.participantNumber = participantNumber;
    }
}
