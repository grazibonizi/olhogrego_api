package br.com.fiap.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TBL_OG_USER")
@SequenceGenerator(name="seqUser", sequenceName="SEQ_OG_USER", allocationSize=1)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqUser")
	private int id;
	
	private String name;
	
	@Column(nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dt_nasc;
	
	@Column(nullable=true)
	@OneToMany(cascade=CascadeType.MERGE)
    @JoinColumn(name="OCCURR_ID")
	private List<Occurence> occcurrences;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public User(int id, String name, Date dt_nasc) {
		super();
		this.id = id;
		this.name = name;
		this.dt_nasc = dt_nasc;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
