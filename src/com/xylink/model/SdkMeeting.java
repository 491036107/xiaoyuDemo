package com.xylink.model;

import java.io.Serializable;

public class SdkMeeting implements Serializable {

	private static final long serialVersionUID = -4116669862379638007L;

	private String meetingNumber;
	private String password;
	private String shareUrl;
	
	public SdkMeeting() {
		
	}
	
	public SdkMeeting(String number) {
		this.meetingNumber = number;
	}
	
	public String getMeetingNumber() {
		return meetingNumber;
	}
	public void setMeetingNumber(String meetingNumber) {
		this.meetingNumber = meetingNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}
	
}
