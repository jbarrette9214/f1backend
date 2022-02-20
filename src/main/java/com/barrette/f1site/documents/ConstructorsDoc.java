package com.barrette.f1site.documents;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="constructors")
public class ConstructorsDoc {

	@Id
	private String id;
	private String name;
	private String nationality;
	private Integer raceCount;
	private Integer wins;
	private Integer podiums;
	
	public ConstructorsDoc() {}

	public ConstructorsDoc(String constructorId, String name, String nationality, Integer raceCount, Integer wins,
			Integer podiums) {
		super();
		this.id = constructorId;
		this.name = name;
		this.nationality = nationality;
		this.raceCount = raceCount;
		this.wins = wins;
		this.podiums = podiums;
	}

	public String getId() {
		return id;
	}

	public void setId(String constructorId) {
		this.id = constructorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getRaceCount() {
		return raceCount;
	}

	public void setRaceCount(Integer raceCount) {
		this.raceCount = raceCount;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getPodiums() {
		return podiums;
	}

	public void setPodiums(Integer podiums) {
		this.podiums = podiums;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((podiums == null) ? 0 : podiums.hashCode());
		result = prime * result + ((raceCount == null) ? 0 : raceCount.hashCode());
		result = prime * result + ((wins == null) ? 0 : wins.hashCode());
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
		ConstructorsDoc other = (ConstructorsDoc) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (podiums == null) {
			if (other.podiums != null)
				return false;
		} else if (!podiums.equals(other.podiums))
			return false;
		if (raceCount == null) {
			if (other.raceCount != null)
				return false;
		} else if (!raceCount.equals(other.raceCount))
			return false;
		if (wins == null) {
			if (other.wins != null)
				return false;
		} else if (!wins.equals(other.wins))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Constructors [constructorId=" + id + ", name=" + name + ", nationality=" + nationality
				+ ", raceCount=" + raceCount + ", wins=" + wins + ", podiums=" + podiums + "]";
	}
	
	
}
