package com.example.virtusatest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleResponse {

	@SerializedName("PeopleResponse")
	private List<PeopleResponseItem> peopleResponse;

	public void setPeopleResponse(List<PeopleResponseItem> peopleResponse) {
		this.peopleResponse = peopleResponse;
	}

	public List<PeopleResponseItem> getPeopleResponse(){
		return peopleResponse;
	}
}