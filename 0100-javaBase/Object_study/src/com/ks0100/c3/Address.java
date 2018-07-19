package com.ks0100.c3;

public class Address {
	private String place;
	public Address(String place) {
		this.place=place;
	}
	
	public String toString(){
		return place;
	}
	
	public void setPlace(String place){
		this.place=place;
	}
}
