package com.barrette.f1site.pojos;

import java.util.Date;

public class NameDate {

	private String name;
	private Date date;
	
	public NameDate() {}

	public NameDate(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "NameDate [name=" + name + ", date=" + date + "]";
	}
	
	
}
