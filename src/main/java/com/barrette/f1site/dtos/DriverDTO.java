package com.barrette.f1site.dtos;

import com.barrette.f1site.documents.Driver;

public class DriverDTO {
	
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

	public DriverDTO() {}

	public DriverDTO(String id, String name, String nationality, String code, String number, String dob,
			Integer raceCount, Integer wins, Integer podiums, Integer poles, Integer fastestLaps, Double points,
			String firstWin, String lastWin, Integer championships) {
		super();
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.code = code;
		this.number = number;
		this.dob = dob;
		this.raceCount = raceCount;
		this.wins = wins;
		this.podiums = podiums;
		this.poles = poles;
		this.fastestLaps = fastestLaps;
		this.points = points;
		this.firstWin = firstWin;
		this.lastWin = lastWin;
		this.championships = championships;
	}

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
		result = prime * result + ((championships == null) ? 0 : championships.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((fastestLaps == null) ? 0 : fastestLaps.hashCode());
		result = prime * result + ((firstWin == null) ? 0 : firstWin.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastWin == null) ? 0 : lastWin.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((podiums == null) ? 0 : podiums.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((poles == null) ? 0 : poles.hashCode());
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
		DriverDTO other = (DriverDTO) obj;
		if (championships == null) {
			if (other.championships != null)
				return false;
		} else if (!championships.equals(other.championships))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (fastestLaps == null) {
			if (other.fastestLaps != null)
				return false;
		} else if (!fastestLaps.equals(other.fastestLaps))
			return false;
		if (firstWin == null) {
			if (other.firstWin != null)
				return false;
		} else if (!firstWin.equals(other.firstWin))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastWin == null) {
			if (other.lastWin != null)
				return false;
		} else if (!lastWin.equals(other.lastWin))
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
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (podiums == null) {
			if (other.podiums != null)
				return false;
		} else if (!podiums.equals(other.podiums))
			return false;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		if (poles == null) {
			if (other.poles != null)
				return false;
		} else if (!poles.equals(other.poles))
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
		return "DriverDTO [id=" + id + ", name=" + name + ", nationality=" + nationality + ", code=" + code
				+ ", number=" + number + ", dob=" + dob + ", raceCount=" + raceCount + ", wins=" + wins + ", podiums="
				+ podiums + ", poles=" + poles + ", fastestLaps=" + fastestLaps + ", points=" + points + ", firstWin="
				+ firstWin + ", lastWin=" + lastWin + ", championships=" + championships + "]";
	}
	
	public static DriverDTO convertToDTO(Driver doc) {
		return new DriverDTO(doc.getId(), doc.getName(), doc.getNationality(), doc.getCode(), doc.getNumber(), doc.getDob(),
						doc.getRaceCount(), doc.getWins(), doc.getPodiums(), doc.getPoles(), doc.getFastestLaps(), 
						doc.getPoints(), doc.getFirstWin(), doc.getLastWin(), doc.getChampionships());
	}
	
	public static Driver convertToDoc(DriverDTO dto) {
		return new Driver(dto.getId(), dto.getName(), dto.getNationality(), dto.getCode(), dto.getNumber(), dto.getDob(),
						dto.getRaceCount(), dto.getWins(), dto.getPodiums(), dto.getPoles(), dto.getFastestLaps(),
						dto.getPoints(), dto.getFirstWin(), dto.getLastWin(), dto.getChampionships());
	}

}
