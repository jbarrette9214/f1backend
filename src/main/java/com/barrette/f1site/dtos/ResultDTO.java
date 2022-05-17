package com.barrette.f1site.dtos;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import com.barrette.f1site.documents.Result;
import com.barrette.f1site.pojos.LapTime;
import com.barrette.f1site.pojos.Pitstop;

@Validated
public class ResultDTO {

	private String id;
	@NotEmpty(message="{result.driverId.notEmpty}")
	private String driverId;
	@NotEmpty(message="{result.constructorId.notEmpty}")
	private String constructorId;
	@NotEmpty(message="{result.raceId.notEmpty}")
	private String raceId;
	@Min(value=1,message="{result.startPos.value}")
	@Max(value=30, message="{result.startPos.value}")
	private Integer startPos;
	@Min(value=1, message="{result.finishPos.value}")
	@Max(value=30, message="{result.finishPos.value}")
	private Integer finishPos;
	private Integer laps;
	@NotEmpty(message="{result.status.notEmpty}")
	private String status;
	private String fastLapTime;
	private Integer fastLapRank;
	private List<LapTime> lapTimes;
	private List<Pitstop> pitstops;

	
	public ResultDTO() {}
	
	public ResultDTO(String id, String driverId, String constructorId, String raceId, Integer startPos,
			Integer finishPos, Integer laps,  String status, String fastLapTime, Integer fastLapRank,
			List<LapTime> lapTimes, List<Pitstop> pitstops) {
		super();
		this.id = id;
		this.driverId = driverId;
		this.constructorId = constructorId;
		this.raceId = raceId;
		this.startPos = startPos;
		this.finishPos = finishPos;
		this.laps = lapTimes.size();
		this.status = status;
		//this.fastLapTime = fastLapTime;
		this.fastLapRank = fastLapRank;
		this.lapTimes = lapTimes;
		this.pitstops = pitstops;
		
		if(lapTimes.size()==0) {
			this.fastLapTime = "NA";
			this.fastLapTime = "NA";
		} else {
			lapTimes.sort((a,b)->a.toString().compareTo(b.toString()));
			this.fastLapTime = lapTimes.get(0).getTime();
		}
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

	public String getRaceId() {
		return raceId;
	}

	public void setRaceId(String raceId) {
		this.raceId = raceId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((constructorId == null) ? 0 : constructorId.hashCode());
		result = prime * result + ((driverId == null) ? 0 : driverId.hashCode());
		result = prime * result + ((fastLapRank == null) ? 0 : fastLapRank.hashCode());
		result = prime * result + ((fastLapTime == null) ? 0 : fastLapTime.hashCode());
		result = prime * result + ((finishPos == null) ? 0 : finishPos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lapTimes == null) ? 0 : lapTimes.hashCode());
		result = prime * result + ((laps == null) ? 0 : laps.hashCode());
		result = prime * result + ((pitstops == null) ? 0 : pitstops.hashCode());
		result = prime * result + ((raceId == null) ? 0 : raceId.hashCode());
		result = prime * result + ((startPos == null) ? 0 : startPos.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ResultDTO other = (ResultDTO) obj;
		if (constructorId == null) {
			if (other.constructorId != null)
				return false;
		} else if (!constructorId.equals(other.constructorId))
			return false;
		if (driverId == null) {
			if (other.driverId != null)
				return false;
		} else if (!driverId.equals(other.driverId))
			return false;
		if (fastLapRank == null) {
			if (other.fastLapRank != null)
				return false;
		} else if (!fastLapRank.equals(other.fastLapRank))
			return false;
		if (fastLapTime == null) {
			if (other.fastLapTime != null)
				return false;
		} else if (!fastLapTime.equals(other.fastLapTime))
			return false;
		if (finishPos == null) {
			if (other.finishPos != null)
				return false;
		} else if (!finishPos.equals(other.finishPos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lapTimes == null) {
			if (other.lapTimes != null)
				return false;
		} else if (!lapTimes.equals(other.lapTimes))
			return false;
		if (laps == null) {
			if (other.laps != null)
				return false;
		} else if (!laps.equals(other.laps))
			return false;
		if (pitstops == null) {
			if (other.pitstops != null)
				return false;
		} else if (!pitstops.equals(other.pitstops))
			return false;
		if (raceId == null) {
			if (other.raceId != null)
				return false;
		} else if (!raceId.equals(other.raceId))
			return false;
		if (startPos == null) {
			if (other.startPos != null)
				return false;
		} else if (!startPos.equals(other.startPos))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultDTO [id=" + id + ", driverId=" + driverId + ", constructorId=" + constructorId + ", raceId="
				+ raceId + ", startPos=" + startPos + ", finishPos=" + finishPos + ", laps=" + laps + ", status="
				+ status + ", fastLapTime=" + fastLapTime + ", fastLapRank=" + fastLapRank + ", lapTimes=" + lapTimes
				+ ", pitstops=" + pitstops + "]";
	}
	
	public static ResultDTO convertToDTO(Result doc) {
		return new ResultDTO(doc.getId(), doc.getDriverId(), doc.getConstructorId(), doc.getRaceId(), doc.getStartPos(),
				doc.getFinishPos(),  doc.getLaps(), doc.getStatus(), doc.getFastLapTime(), doc.getFastLapRank(), 
				doc.getLapTimes(), doc.getPitstops());
	}
	
	public static Result convertToDoc(ResultDTO dto) {
		return new Result(dto.getId(), dto.getDriverId(), dto.getConstructorId(), dto.getRaceId(), dto.getStartPos(),
				dto.getFinishPos(), dto.getLaps(), dto.getStatus(), dto.getFastLapTime(), dto.getFastLapRank(),
				dto.getLapTimes(), dto.getPitstops());
	}
	
	
}
