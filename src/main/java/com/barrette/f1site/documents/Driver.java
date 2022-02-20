package com.barrette.f1site.documents;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="drivers")
public class Driver {

	@Id
	private String id;
	private String name;
	private String nationality;
	private String code;
	private String number;
	private String dob;
	private Integer raceCount;
	private Integer wins;
	private Integer podiums;
	private Integer poles;
	private Integer fastestLaps;
	private Double points;
	private String firstWin;
	private String lastWin;
	private Integer championships;
	
	public Driver() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public Integer getPoles() {
		return poles;
	}

	public void setPoles(Integer poles) {
		this.poles = poles;
	}

	public Integer getFastestLaps() {
		return fastestLaps;
	}

	public void setFastestLaps(Integer fastestLaps) {
		this.fastestLaps = fastestLaps;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public String getFirstWin() {
		return firstWin;
	}

	public void setFirstWin(String firstWin) {
		this.firstWin = firstWin;
	}

	public String getLastWin() {
		return lastWin;
	}

	public void setLastWin(String lastWin) {
		this.lastWin = lastWin;
	}

	public Integer getChampionships() {
		return championships;
	}

	public void setChampionships(Integer championships) {
		this.championships = championships;
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
		Driver other = (Driver) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", nationality=" + nationality + ", code=" + code + ", number="
				+ number + ", dob=" + dob + ", raceCount=" + raceCount + ", wins=" + wins + ", podiums=" + podiums
				+ ", poles=" + poles + ", fastestLaps=" + fastestLaps + ", points=" + points + ", firstWin=" + firstWin
				+ ", lastWin=" + lastWin + ", championships=" + championships + "]";
	}
	
	
}
