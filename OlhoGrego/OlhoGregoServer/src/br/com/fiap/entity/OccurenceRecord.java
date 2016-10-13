package br.com.fiap.entity;

import javax.persistence.OneToOne;

import oracle.sql.BLOB;

public class OccurenceRecord {

	private int id;
	
	private BLOB streamming;
	
	/*
	@OneToOne(mappedBy="occurence")
	private Occurence occurenceId;
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BLOB getStreamming() {
		return streamming;
	}

	public void setStreamming(BLOB streamming) {
		this.streamming = streamming;
	}


	public OccurenceRecord(int id, BLOB streamming) {
		super();
		this.id = id;
		this.streamming = streamming;
	}

	public OccurenceRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
