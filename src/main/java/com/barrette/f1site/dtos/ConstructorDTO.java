package com.barrette.f1site.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

import org.springframework.validation.annotation.Validated;

import com.barrette.f1site.documents.ConstructorsDoc;

@Validated
public class ConstructorDTO {

	@Null(message="{constructor.id.null}")
	private String id;
	@NotEmpty(message="{constructor.name.notNull}")
	private String name;
	@NotEmpty(message="{constructor.nationality.notNull}")
	private String nationality;
	@Null(message="{constuctor.raceCount.null}")
	private Integer raceCount;
	@Null(message="{constructor.wins.null}")
	private Integer wins;
	@Null(message="{constructor.podiums.null}")
	private Integer podiums;
	
	public ConstructorDTO() {}

	public ConstructorDTO(String id, String name, String nationality, Integer raceCount, Integer wins,
			Integer podiums) {
		super();
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.raceCount = raceCount;
		this.wins = wins;
		this.podiums = podiums;
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
		ConstructorDTO other = (ConstructorDTO) obj;
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
		return "ConstructorDTO [id=" + id + ", name=" + name + ", nationality=" + nationality + ", raceCount="
				+ raceCount + ", wins=" + wins + ", podiums=" + podiums + "]";
	}
	
	public static ConstructorDTO convertToDTO(ConstructorsDoc doc) {
		return new ConstructorDTO(doc.getId(), doc.getName(), doc.getNationality(), doc.getRaceCount(), doc.getWins(), 
								doc.getPodiums());
	}
	
	public static ConstructorsDoc convertToDoc(ConstructorDTO dto) {
		return new ConstructorsDoc(dto.getId(), dto.getName(), dto.getNationality(), dto.getRaceCount(), dto.getWins(),
								dto.getPodiums());
	}
}
