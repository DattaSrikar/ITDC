package com.dxc.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hotel 
{
	@Id
	private int id;
	private String name;
	private String address;
	private int totalrooms;
	private int avaliablerooms;
	private double costofroom;
	
	public Hotel() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalrooms() {
		return totalrooms;
	}

	public void setTotalrooms(int totalrooms) {
		this.totalrooms = totalrooms;
	}

	public double getCostofroom() {
		return costofroom;
	}

	public void setCostofroom(double costofroom) {
		this.costofroom = costofroom;
	}
	
	

	public int getAvaliablerooms() {
		return avaliablerooms;
	}

	public void setAvaliablerooms(int avaliablerooms) {
		this.avaliablerooms = avaliablerooms;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", totalrooms=" + totalrooms
				+ ", avaliablerooms=" + avaliablerooms + ", costofroom=" + costofroom + "]";
	}

	
	
}
