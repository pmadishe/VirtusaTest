package com.example.virtusatest.model;

import com.google.gson.annotations.SerializedName;

public class RoomsResponseItem{

	@SerializedName("isOccupied")
	private boolean isOccupied;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("maxOccupancy")
	private int maxOccupancy;

	@SerializedName("id")
	private String id;

	public boolean isIsOccupied(){
		return isOccupied;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getMaxOccupancy(){
		return maxOccupancy;
	}

	public String getId(){
		return id;
	}
}