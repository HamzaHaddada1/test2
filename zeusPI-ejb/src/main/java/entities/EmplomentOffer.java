package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmplomentOffer
 *
 */
@Entity

public class EmplomentOffer implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String JobTitle;
	private String JobDescr;
	private Date PubDate;
	private String Joboffre;
	//private EntrepriseTeam PostedBy;
	//private boolean Confirmed;
	
	//private List<Application> listApplication; // 

	//private Quiz quiz;
	
	
	//private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "joboff",orphanRemoval=true,cascade=CascadeType.ALL)
	private List<StatUser> professionalexps;
	public String getJoboffre() {
		return Joboffre;
	}
	public void setJoboffre(String joboffre) {
		Joboffre = joboffre;
	}
	public EmplomentOffer() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getJobTitle() {
		return this.JobTitle;
	}

	public void setJobTitle(String JobTitle) {
		this.JobTitle = JobTitle;
	}   
	public String getJobDescr() {
		return this.JobDescr;
	}

	public void setJobDescr(String JobDescr) {
		this.JobDescr = JobDescr;
	}   
	public Date getPubDate() {
		return this.PubDate;
	}

	public void setPubDate(Date PubDate) {
		this.PubDate = PubDate;
	}   
	
   
}
