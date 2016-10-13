package br.com.fiap.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TBL_OG_OCCURRENCE")
@SequenceGenerator(name="seqOccurr", sequenceName="SEQ_OG_OCCURRENCE", allocationSize=1)
public class Occurence {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqOccurr")
	private int id;
	
	private float latitude;
	
	private float longitude;
	
	@Column(nullable=true)
	@Temporal(value=TemporalType.DATE)
	private Date dateStartRecord;

	@Column(nullable=true)
	@Temporal(value=TemporalType.DATE)
	private Date dateCloseRecord;
	
	private int level;
	
	/*@OneToOne
	@JoinColumn(name="occurence", nullable=true)
	private OccurenceRecord occurence;
	*/
	/*
	@ManyToOne(cascade=CascadeType.MERGE)
	private User user;
	*/
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public Occurence(int id, float latitude, float longitude, Date dateStartRecord, Date dateCloseRecord,
			int level) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dateStartRecord = dateStartRecord;
		this.dateCloseRecord = dateCloseRecord;
		this.level = level;
		
	}

	public Date getDateStartRecord() {
		return dateStartRecord;
	}

	public void setDateStartRecord(Date dateStartRecord) {
		this.dateStartRecord = dateStartRecord;
	}

	public Date getDateCloseRecord() {
		return dateCloseRecord;
	}

	public void setDateCloseRecord(Date dateCloseRecord) {
		this.dateCloseRecord = dateCloseRecord;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Occurence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
