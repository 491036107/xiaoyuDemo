package com.xylink.model;

/**
 * Created by changxiangyang on 2017/6/8.
 * 授权分享屏幕接口的参数类
 */
public class ShareAuthTarget {
    private Device device;
    private boolean isAll;

    public Boolean getIsAll() {
        return isAll;
    }

    public void setIsAll(Boolean isAll) {
        this.isAll = isAll;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }


}
