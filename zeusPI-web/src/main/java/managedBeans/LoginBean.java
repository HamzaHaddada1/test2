package managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ejbService.UserServiceEjb;
import entities.Entreprise;
import entities.User;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String login; 
	private String password; 
	private User employe;
	private Entreprise entreprise;
	private Boolean loggedIn;

	@EJB
	UserServiceEjb employeService; 
/*
	@EJB
    EntrepriseServiceEjb entrepriseService; 
    
    public String doLoginEntreprise()
	{
		String navigateTo = "null"; 
		entreprise = EntrepriseService.Loginbymailpwd(login, password); 

		if (entrperise != null ) {
			
			//navigateTo = "/pages/admin/welcome?faces-redirect=true"; /////// A changer 
			System.out.println("hellmoooooeoeoeeo");
			loggedIn = true; 
		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo; 
	}


*/
	public String doLoginUser()
	{
		String navigateTo = "null"; 
		employe = employeService.Loginbymailpwd(login, password); 

		if (employe != null ) {
			
			//navigateTo = "/pages/admin/welcome?faces-redirect=true"; /////// A changer 
			System.out.println("hellmoooooeoeoeeo");
			loggedIn = true; 
		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo; 
	}

	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
 
	public LoginBean() {} 
	
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public User getUser() {return employe;}
	public void setUser(User employe) {this.employe = employe;}
	public Boolean getLoggedIn() {return loggedIn;}
	public void setLoggedIn(Boolean loggedIn) {this.loggedIn = loggedIn;}
}
