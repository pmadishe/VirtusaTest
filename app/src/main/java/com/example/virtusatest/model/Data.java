package com.example.virtusatest.model;

import com.google.gson.annotations.SerializedName;

public class Data {

	@SerializedName("toId")
	private String toId;

	@SerializedName("meetingid")
	private String meetingid;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("fromId")
	private String fromId;

	public String getToId(){
		return toId;
	}

	public String getMeetingid(){
		return meetingid;
	}

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getBody(){
		return body;
	}

	public String getFromId(){
		return fromId;
	}
}