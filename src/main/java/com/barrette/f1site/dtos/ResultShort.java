package com.barrette.f1site.dtos;

public class ResultShort {

	private String driverName;
	private Integer position;
	private Integer startPos;
	private Integer pitstops;
	
	public ResultShort() {}

	public ResultShort(String driverName, Integer position, Integer startPos, Integer pitstops) {
		super();
		this.driverName = driverName;
		this.position = position;
		this.startPos = startPos;
		this.pitstops = pitstops;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getStartPos() {
		return startPos;
	}

	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}

	public Integer getPitstops() {
		return pitstops;
	}

	public void setPitstops(Integer pitstops) {
		this.pitstops = pitstops;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
		result = prime * result + ((pitstops == null) ? 0 : pitstops.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((startPos == null) ? 0 : startPos.hashCode());
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
		ResultShort other = (ResultShort) obj;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		if (pitstops == null) {
			if (other.pitstops != null)
				return false;
		} else if (!pitstops.equals(other.pitstops))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (startPos == null) {
			if (other.startPos != null)
				return false;
		} else if (!startPos.equals(other.startPos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultShort [driverName=" + driverName + ", position=" + position + ", startPos=" + startPos
				+ ", pitstops=" + pitstops + "]";
	}

	
	
}
