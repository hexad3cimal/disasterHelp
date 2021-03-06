package com.disasterhelp.webapp.beans;// default package
// Generated 15 Dec, 2015 8:45:27 PM by Hibernate Tools 4.0.0

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Helpline generated by hbm2java
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "helpline", catalog = "disasterHelp")
public class Helpline extends SuperEntity implements java.io.Serializable {

	private Area area;
	private String helplineno;
	private String type;
	private Integer isValid;
	private Integer isInvalid;
	private Disaster disaster;

	public Helpline() {
	}

	public Helpline(Disaster disaster,Area area, String helplineno, String type, Integer isValid, Integer isInvalid) {
		this.area = area;
		this.helplineno = helplineno;
		this.type = type;
		this.isValid = isValid;
		this.isInvalid = isInvalid;
		this.disaster = disaster;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "disaster_id")
	public Disaster getDisaster() {
		return this.disaster;
	}

	public void setDisaster(Disaster disaster) {
		this.disaster = disaster; }


	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "area")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	@Column(name = "helplineno", length = 45)
	public String getHelplineno() {
		return this.helplineno;
	}

	public void setHelplineno(String helplineno) {
		this.helplineno = helplineno;
	}

	@Column(name = "type", length = 100)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "isValid")
	public Integer getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	@Column(name = "isInvalid")
	public Integer getIsInvalid() {
		return this.isInvalid;
	}

	public void setIsInvalid(Integer isInvalid) {
		this.isInvalid = isInvalid;
	}

}
