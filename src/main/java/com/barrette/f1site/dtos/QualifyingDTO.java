package com.barrette.f1site.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

import org.springframework.validation.annotation.Validated;

import com.barrette.f1site.documents.Qualifying;

@Validated
public class QualifyingDTO {
	
	@Null(message="{qualifying.id.null}")
	private String id;
	@Min(value=1950, message="{qualifying.year.min}")
	@Max(value=2050, message="{qualifying.year.max}")
	private Integer year;
	@NotEmpty(message="{qualifying.raceName.required}")
	private String raceName;
	@NotEmpty(message="{qualifying.driverName.required}")
	private String driverName;
	@Min(value=1, message="{qualifying.position.min}")
	@Max(value=30, message="{qualifying.position.max}")
	private Integer position;
	private String q1;
	private String q2;
	private String q3;

	public QualifyingDTO() {}

	public QualifyingDTO(String id, Integer year, String raceName, String driverName, Integer position, String q1,
			String q2, String q3) {
		super();
		this.id = id;
		this.year = year;
		this.raceName = raceName;
		this.driverName = driverName;
		this.position = position;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
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

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	@Override
	public String toString() {
		return "QualifyingDTO [id=" + id + ", year=" + year + ", raceName=" + raceName + ", driverName=" + driverName
				+ ", position=" + position + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3 + "]";
	}
	
	public static QualifyingDTO convertToDTO(Qualifying doc) {
		return new QualifyingDTO(doc.getId(), doc.getYear(), doc.getRaceName(), doc.getDriverName(), doc.getPosition(),
				doc.getQ1(), doc.getQ2(), doc.getQ3());
	}
	
	public static Qualifying convertToDoc(QualifyingDTO dto) {
		return new Qualifying(dto.getId(), dto.getYear(), dto.getRaceName(), dto.getDriverName(), dto.getPosition(),
				dto.getQ1(), dto.getQ2(), dto.getQ3());
	}

}
