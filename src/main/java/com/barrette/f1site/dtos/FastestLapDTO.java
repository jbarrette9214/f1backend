package com.barrette.f1site.dtos;

import com.barrette.f1site.documents.FastestLap;

public class FastestLapDTO {

	private String id;
	private Integer year;
	private String raceName;
	private Integer lap;
	private String lapTime;
	private Integer milliseconds;
	private String driverName;

	public FastestLapDTO() {}

	public FastestLapDTO(String id, Integer year, String raceName, Integer lap, String lapTime, Integer milliseconds,
			String driverName) {
		super();
		this.id = id;
		this.year = year;
		this.raceName = raceName;
		this.lap = lap;
		this.lapTime = lapTime;
		this.milliseconds = milliseconds;
		this.driverName = driverName;
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

	public Integer getLap() {
		return lap;
	}

	public void setLap(Integer lap) {
		this.lap = lap;
	}

	public String getLapTime() {
		return lapTime;
	}

	public void setLapTime(String lapTime) {
		this.lapTime = lapTime;
	}

	public Integer getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(Integer milliseconds) {
		this.milliseconds = milliseconds;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lap == null) ? 0 : lap.hashCode());
		result = prime * result + ((lapTime == null) ? 0 : lapTime.hashCode());
		result = prime * result + ((milliseconds == null) ? 0 : milliseconds.hashCode());
		result = prime * result + ((raceName == null) ? 0 : raceName.hashCode());
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
		FastestLapDTO other = (FastestLapDTO) obj;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lap == null) {
			if (other.lap != null)
				return false;
		} else if (!lap.equals(other.lap))
			return false;
		if (lapTime == null) {
			if (other.lapTime != null)
				return false;
		} else if (!lapTime.equals(other.lapTime))
			return false;
		if (milliseconds == null) {
			if (other.milliseconds != null)
				return false;
		} else if (!milliseconds.equals(other.milliseconds))
			return false;
		if (raceName == null) {
			if (other.raceName != null)
				return false;
		} else if (!raceName.equals(other.raceName))
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
		return "FastestLapDTO [id=" + id + ", year=" + year + ", raceName=" + raceName + ", lap=" + lap + ", lapTime="
				+ lapTime + ", milliseconds=" + milliseconds + ", driverName=" + driverName + "]";
	}
	
	public static FastestLapDTO convertToDTO(FastestLap doc) {
		return new FastestLapDTO(doc.getId(), doc.getYear(), doc.getRaceName(), doc.getLap(), doc.getLapTime(), 
				doc.getMilliseconds(), doc.getDriverName());
	}
	
	public static FastestLap convertToDoc(FastestLapDTO dto) {
		return new FastestLap(dto.getId(), dto.getYear(), dto.getRaceName(), dto.getLap(), dto.getLapTime(),
				dto.getMilliseconds(), dto.getDriverName());
	}
}
