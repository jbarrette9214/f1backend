package com.barrette.f1site.documents;

import java.util.List;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.barrette.f1site.pojos.Standing;

@Document
public class ConstructorStandings {

	@Id
	private String id;
	private Integer year;
	private List<Standing> standings;
	
	public ConstructorStandings() {}

	public ConstructorStandings(String id, Integer year, List<Standing> standings) {
		super();
		this.id = id;
		this.year = year;
		this.standings = standings;
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

	public List<Standing> getStandings() {
		return standings;
	}

	public void setStandings(List<Standing> standings) {
		this.standings = standings;
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
		ConstructorStandings other = (ConstructorStandings) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConstructorStandings [id=" + id + ", year=" + year + ", standings=" + standings + "]";
	}
	
	
}
