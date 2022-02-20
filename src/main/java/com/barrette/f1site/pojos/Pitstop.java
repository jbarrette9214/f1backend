package com.barrette.f1site.pojos;


public class Pitstop {
	
	private Integer lap;
	private String time;
	private long milliseconds;
	
	public Pitstop() {}

	public Pitstop(Integer lap, String time, long milliseconds) {
		super();
		this.lap = lap;
		this.time = time;
		this.milliseconds = milliseconds;
	}

	public Integer getLap() {
		return lap;
	}

	public void setLap(Integer lap) {
		this.lap = lap;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(long milliseconds) {
		this.milliseconds = milliseconds;
	}

	@Override
	public String toString() {
		return "Pitstop [lap=" + lap + ", time=" + time + ", milliseconds=" + milliseconds + "]";
	}
	

}
