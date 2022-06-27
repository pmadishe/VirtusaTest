package com.example.virtusatest.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RoomsResponse{

	@SerializedName("RoomsResponse")
	private List<RoomsResponseItem> roomsResponse;

	public List<RoomsResponseItem> getRoomsResponse(){
		return roomsResponse;
	}
}