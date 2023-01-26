package com.percyku.restaurant.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="status")
	private String status;
	@Column(name="customer")
	private String customer;
	@Column(name="contents")
	private String contents;


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomer() {
		return customer;
	}



	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
