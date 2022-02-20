package com.barrette.f1site.dtos;

import com.barrette.f1site.documents.Race;

public class RaceDTO {
	
	private String raceId;
	private String date;
	private String circuitName;
	private Integer year;
	private Integer round;
	private String circuitLocation;
	private String country;
	private String name;

	public RaceDTO() {}
	

	public RaceDTO(String raceId, String date, String circuitName, Integer year, Integer round, String circuitLocation,
			String country, String name) {
		super();
		this.raceId = raceId;
		this.date = date;
		this.circuitName = circuitName;
		this.year = year;
		this.round = round;
		this.circuitLocation = circuitLocation;
		this.country = country;
		this.name = name;
	}



	public String getRaceId() {
		return raceId;
	}



	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getCircuitName() {
		return circuitName;
	}



	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}



	public Integer getRound() {
		return round;
	}



	public void setRound(Integer round) {
		this.round = round;
	}



	public String getCircuitLocation() {
		return circuitLocation;
	}



	public void setCircuitLocation(String circuitLocation) {
		this.circuitLocation = circuitLocation;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((circuitLocation == null) ? 0 : circuitLocation.hashCode());
		result = prime * result + ((circuitName == null) ? 0 : circuitName.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((raceId == null) ? 0 : raceId.hashCode());
		result = prime * result + ((round == null) ? 0 : round.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		RaceDTO other = (RaceDTO) obj;
		if (circuitLocation == null) {
			if (other.circuitLocation != null)
				return false;
		} else if (!circuitLocation.equals(other.circuitLocation))
			return false;
		if (circuitName == null) {
			if (other.circuitName != null)
				return false;
		} else if (!circuitName.equals(other.circuitName))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (raceId == null) {
			if (other.raceId != null)
				return false;
		} else if (!raceId.equals(other.raceId))
			return false;
		if (round == null) {
			if (other.round != null)
				return false;
		} else if (!round.equals(other.round))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "RaceDTO [raceId=" + raceId + ", date=" + date + ", circuitName=" + circuitName + ", year=" + year
				+ ", round=" + round + ", circuitLocation=" + circuitLocation + ", country=" + country + ", name="
				+ name + "]";
	}
	
	public static RaceDTO convertToDTO(Race doc) {
		return new RaceDTO(doc.getRaceId(), doc.getDate(), doc.getCircuitName(), doc.getYear(), doc.getRound(), 
				doc.getCircuitLocation(), doc.getCountry(), doc.getName());
	}

	public static Race convertToDoc(RaceDTO dto) {
		return new Race(dto.getRaceId(), dto.getDate(), dto.getCircuitName(), dto.getYear(), dto.getRound(), 
				dto.getCircuitLocation(), dto.getCountry(), dto.getName());
	}
}
