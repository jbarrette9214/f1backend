package com.barrette.f1site.pojos;

public class Standing {

	private String driverName;
	private String constructor;
	private Float points;
	
	public Standing() {}

	public Standing(String driverName, String constructor, Float points) {
		super();
		this.driverName = driverName;
		this.constructor = constructor;
		this.points = points;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getConstructor() {
		return constructor;
	}

	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}

	public Float getPoints() {
		return points;
	}

	public void setPoints(Float points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Standing [driverName=" + driverName + ", constructor=" + constructor + ", points=" + points + "]";
	}
	
	
}
