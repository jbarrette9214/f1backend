package com.barrette.f1site.dtos;

public class RaceNameDateFinishPosDTO {
	
	public String raceName;
	public String date;
	public Integer finishPos;
	
	public RaceNameDateFinishPosDTO() {}

	public RaceNameDateFinishPosDTO(String raceName, String date, Integer finishPos) {
		super();
		this.raceName = raceName;
		this.date = date;
		this.finishPos = finishPos;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getFinishPos() {
		return finishPos;
	}

	public void setFinishPos(Integer finishPos) {
		this.finishPos = finishPos;
	}

	@Override
	public String toString() {
		return "RaceNameDateFinishPosDTO [raceName=" + raceName + ", date=" + date + ", finishPos=" + finishPos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((finishPos == null) ? 0 : finishPos.hashCode());
		result = prime * result + ((raceName == null) ? 0 : raceName.hashCode());
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
		RaceNameDateFinishPosDTO other = (RaceNameDateFinishPosDTO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (finishPos == null) {
			if (other.finishPos != null)
				return false;
		} else if (!finishPos.equals(other.finishPos))
			return false;
		if (raceName == null) {
			if (other.raceName != null)
				return false;
		} else if (!raceName.equals(other.raceName))
			return false;
		return true;
	}
	
	

}
