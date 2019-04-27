package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Skill
 *
 */
@Entity

public class Skill implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String Specialite;
	private String Name;
	private Integer Rating;
    @ManyToOne
	private User user;
	private static final long serialVersionUID = 1L;

	public Skill() {
		super();
	}   
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getSpecialite() {
		return this.Specialite;
	}

	public void setSpecialite(String Specialite) {
		this.Specialite = Specialite;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	public Integer getRating() {
		return this.Rating;
	}

	public void setRating(Integer Rating) {
		this.Rating = Rating;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Skill [Id=" + Id + ", Specialite=" + Specialite + ", Name=" + Name + ", Rating=" + Rating + "]";
	}
   
}
