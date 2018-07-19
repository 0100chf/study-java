package com.ks0100_1.clone;

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
