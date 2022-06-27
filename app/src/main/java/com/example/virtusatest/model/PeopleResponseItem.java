package com.example.virtusatest.model;


import com.google.gson.annotations.SerializedName;

public class PeopleResponseItem{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFavouriteColor(String favouriteColor) {
		this.favouriteColor = favouriteColor;
	}

	@SerializedName("jobtitle")
	private String jobtitle;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("id")
	private String id;

	@SerializedName("email")
	private String email;

	@SerializedName("favouriteColor")
	private String favouriteColor;

	@SerializedName("data")
	private Data data;

	@SerializedName("fromName")
	private String fromName;

	@SerializedName("to")
	private String to;

	public String getCreatedAt(){
		return createdAt;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getJobtitle(){
		return jobtitle;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getFavouriteColor(){
		return favouriteColor;
	}

	public Data getData(){
		return data;
	}

	public String getFromName(){
		return fromName;
	}

	public String getTo(){
		return to;
	}
}