package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Entreprise
 *
 */
@Entity

public class Entreprise implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String email;
	private String name;
	private String Speciality;
	private int nb_employe;
	private String bio;
	private int allowed_job_offers;
	private boolean account_confirmed;
	private String adress;
	/////////////////////skander//////////////////////
	@OneToMany(mappedBy = "entreprise",orphanRemoval=true,cascade={CascadeType.PERSIST,CascadeType.ALL},fetch=FetchType.EAGER)
	private List<Follow> listEntreprise;
	/////////////////////FIN skander//////////////////////
	public Entreprise(int id,String email, String name, String speciality, int nb_employe, String bio, int allowed_job_offers,
			boolean account_confirmed,String add) {
		super();
		this.Id=id;
		this.email = email;
		this.name = name;
		Speciality = speciality;
		this.nb_employe = nb_employe;
		this.bio = bio;
		this.allowed_job_offers = allowed_job_offers;
		this.account_confirmed = account_confirmed;
		this.adress=add;
	}
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getAllowed_job_offers() {
		return allowed_job_offers;
	}

	public void setAllowed_job_offers(int allowed_job_offers) {
		this.allowed_job_offers = allowed_job_offers;
	}

	//*****************************************************************************************
	private static final long serialVersionUID = 1L;

	public Entreprise() {
		super();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return Speciality;
	}

	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}

	public int getNb_employe() {
		return nb_employe;
	}

	public void setNb_employe(int nb_employe) {
		this.nb_employe = nb_employe;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public boolean isAccount_confirmed() {
		return account_confirmed;
	}

	public void setAccount_confirmed(boolean account_confirmed) {
		this.account_confirmed = account_confirmed;
	}
   
}
