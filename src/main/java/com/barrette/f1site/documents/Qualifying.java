package com.barrette.f1site.documents;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Qualifying {

	@Id
	private String id;
	private Integer year;
	private String raceName;
	private String driverName;
	private Integer position;
	private String q1;
	private String q2;
	private String q3;
	
	public Qualifying() {}

	public Qualifying(String id, Integer year, String raceName, String driverName, Integer position, String q1,
			String q2, String q3) {
		super();
		this.id = id;
		this.year = year;
		this.raceName = raceName;
		this.driverName = driverName;
		this.position = position;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Qualifying other = (Qualifying) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Qualifying [id=" + id + ", year=" + year + ", raceName=" + raceName + ", driverName=" + driverName
				+ ", position=" + position + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3 + "]";
	}

		
}
