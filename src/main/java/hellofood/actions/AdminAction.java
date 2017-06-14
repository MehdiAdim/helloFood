package hellofood.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.boudaa.dao.exceptions.EntityNotFoundException;
import com.web.BaseAction;

import hellofood.bo.security.Utilisateur;
import hellofood.services.UtilisateurService;

public class AdminAction extends BaseAction {
	
	private UtilisateurService utilisateurService;

	private List<Utilisateur> users;
	 
	private Utilisateur user;

	public String listPersonnel(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println("User ************* has authorities: " + userDetails.getUsername());
		
		users= utilisateurService.getAllUsers();
		user = utilisateurService.getPrincipal();
		
		return SUCCESS;

	}


	public List<Utilisateur> getUsers() {
		return users;
	}






	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}






	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}



	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}


	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}



	
}
