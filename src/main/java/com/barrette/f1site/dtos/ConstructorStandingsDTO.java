package com.barrette.f1site.dtos;

import java.util.List;

import com.barrette.f1site.documents.ConstructorStandings;
import com.barrette.f1site.pojos.Standing;

public class ConstructorStandingsDTO {

	private String id;
	private Integer year;
	private List<Standing> standings;
	
	public ConstructorStandingsDTO() {}

	public ConstructorStandingsDTO(String id, Integer year, List<Standing> standings) {
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
		result = prime * result + ((standings == null) ? 0 : standings.hashCode());
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
		ConstructorStandingsDTO other = (ConstructorStandingsDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (standings == null) {
			if (other.standings != null)
				return false;
		} else if (!standings.equals(other.standings))
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
		return "ConstructorStandingsDTO [id=" + id + ", year=" + year + ", standings=" + standings + "]";
	}
	
	public static ConstructorStandings convertToDoc(ConstructorStandingsDTO dto) {
		return new ConstructorStandings(dto.getId(), dto.getYear(), dto.getStandings());
	}
	
	public static ConstructorStandingsDTO convertToDTO(ConstructorStandings doc) {
		return new ConstructorStandingsDTO(doc.getId(), doc.getYear(), doc.getStandings());
	}

}
