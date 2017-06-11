package hellofood.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import com.web.BaseAction;

import hellofood.bo.Reservation;
import hellofood.services.ReservationService;
import hellofood.services.UtilisateurService;

public class SecurityAction extends BaseAction {
	

	
	private UtilisateurService utilisateurService;
	private ReservationService reservationService;
	
	

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public String login() {
		
		
		
		
		System.out.println("form");
		return SUCCESS;

	}
	

	public String userProfile() {

		Collection<? extends GrantedAuthority> ath = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		if (ath.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			
			System.out.println("Admiiiin");
			return "successAdmin";

		}

		else if (ath.contains(new SimpleGrantedAuthority("ROLE_USER"))) {

			return "successUser";

		}

		return SUCCESS;

	}

	public String denied() {
		return SUCCESS;

	}

	
	

}
