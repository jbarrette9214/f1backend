package com.barrette.f1site.dtos;

import java.util.List;

import com.barrette.f1site.documents.DriverStandings;
import com.barrette.f1site.pojos.Standing;

public class DriverStandingsDTO {
	
	private String id;
	private Integer year;
	private List<Standing> standings;
	
	public DriverStandingsDTO() {}

	public DriverStandingsDTO(String id, Integer year, List<Standing> standings) {
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
		DriverStandingsDTO other = (DriverStandingsDTO) obj;
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
		return "DriverStandingsDTO [id=" + id + ", year=" + year + ", standings=" + standings + "]";
	}
	
	public static DriverStandingsDTO convertToDTO(DriverStandings doc) {
		return new DriverStandingsDTO(doc.getId(), doc.getYear(), doc.getStandings());
	}
	
	public static DriverStandings convertToDoc(DriverStandingsDTO dto) {
		return new DriverStandings(dto.getId(), dto.getYear(), dto.getStandings());
	}

}
