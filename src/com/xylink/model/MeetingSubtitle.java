package com.xylink.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by changxiangyang on 2017/6/8.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingSubtitle {

    /** 字幕内容. */
    private String content;

    /** 字幕显示位置:top/middle/bottom. */
    private String location = "top";

    /** 动作:push/cancel. */
    private String action  = "push";

    /** 是否滚动,1-滚动, 0-固定. */
    private String scroll = "0";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getScroll() {
        return scroll;
    }

    public void setScroll(String scroll) {
        this.scroll = scroll;
    }
}
