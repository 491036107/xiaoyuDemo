package com.xylink.model;

import com.xylink.util.PinyinUtil;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by maolizhi on 3/14/17.
 */
@JsonIgnoreProperties({ "nameCode" })
public class NemoDto implements Comparable<NemoDto> {
    private String name;
    @SuppressWarnings("unused")
    private String nameCode;
    private String number;
    private String sn;

    private String adminName;
    private String avatar;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCode() {

        return PinyinUtil.getPinYin(name);
    }

    @Override
    public String toString() {
        return "NemoDto [number=" + number + ", sn=" + sn + ", adminName=" + adminName + ", avatar=" + avatar + ", name=" + name + "]";
    }

    @Override
    public int compareTo(NemoDto nemo) {

        if (null != nemo && null != this.getNameCode()) {

            return this.getNameCode().compareToIgnoreCase(nemo.getNameCode());
        }

        return 0;
    }
}
