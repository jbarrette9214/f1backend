package com.barrette.f1site.documents;

import java.util.List;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.barrette.f1site.pojos.LapTime;
import com.barrette.f1site.pojos.Pitstop;

@Document(collection="results")
public class Result {
	
	@Id
	private String id;
	private String driverId;
	private String constructorId;
	private String raceId;
	private Integer startPos;
	private Integer finishPos;
	private Integer laps;
	private String status;
	private String fastLapTime;
	private Integer fastLapRank;
	private List<LapTime> lapTimes;
	private List<Pitstop> pitstops;
	
	public Result() {}



	public Result(String id, String driverId, String constructorId, String raceId, Integer startPos, Integer finishPos,
			Integer laps, String status, String fastLapTime, Integer fastLapRank, List<LapTime> lapTimes,
			List<Pitstop> pitstops) {
		super();
		this.id = id;
		this.driverId = driverId;
		this.constructorId = constructorId;
		this.raceId = raceId;
		this.startPos = startPos;
		this.finishPos = finishPos;
		this.laps = laps;
		this.status = status;
		this.fastLapTime = fastLapTime;
		this.fastLapRank = fastLapRank;
		this.lapTimes = lapTimes;
		this.pitstops = pitstops;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getConstructorId() {
		return constructorId;
	}

	public void setConstructorId(String constructorId) {
		this.constructorId = constructorId;
	}

	public Integer getStartPos() {
		return startPos;
	}

	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}

	public Integer getFinishPos() {
		return finishPos;
	}

	public void setFinishPos(Integer finishPos) {
		this.finishPos = finishPos;
	}

	public Integer getLaps() {
		return laps;
	}

	public void setLaps(Integer laps) {
		this.laps = laps;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFastLapTime() {
		return fastLapTime;
	}

	public void setFastLapTime(String fastLapTime) {
		this.fastLapTime = fastLapTime;
	}

	public Integer getFastLapRank() {
		return fastLapRank;
	}

	public void setFastLapRank(Integer fastLapRank) {
		this.fastLapRank = fastLapRank;
	}

	public List<LapTime> getLapTimes() {
		return lapTimes;
	}

	public void setLapTimes(List<LapTime> lapTimes) {
		this.lapTimes = lapTimes;
	}

	public List<Pitstop> getPitstops() {
		return pitstops;
	}

	public void setPitstops(List<Pitstop> pitstops) {
		this.pitstops = pitstops;
	}

	public String getRaceId() {
		return raceId;
	}

	public void setRaceId(String raceId) {
		this.raceId = raceId;
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
		Result other = (Result) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", driverId=" + driverId + ", constructorId=" + constructorId + ", raceId=" + raceId
				+ ", startPos=" + startPos + ", finishPos=" + finishPos + ", laps=" + laps + ", status=" + status
				+ ", fastLapTime=" + fastLapTime + ", fastLapRank=" + fastLapRank + ", lapTimes="
				+ lapTimes + ", pitstops=" + pitstops + "]";
	}

	
	

}
