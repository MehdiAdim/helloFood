package hellofood.actions;

import java.util.Collection;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import com.web.BaseAction;
import hellofood.services.ReservationService;
import hellofood.services.UtilisateurService;
import hellofood.tools.LoggerTools;


@SuppressWarnings("serial")
public class SecurityAction extends BaseAction {
	

	// Spring DI
	
	private UtilisateurService utilisateurService;
	private ReservationService reservationService;
	private LoggerTools loggerTools;
	
	protected final Log log = LogFactory.getLog(getClass());
	

	public LoggerTools getLoggerTools() {
		return loggerTools;
	}

	public void setLoggerTools(LoggerTools loggerTools) {
		this.loggerTools = loggerTools;
	}

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

	// struts2 methods
	
	public String login() {
		
		loggerTools.addBox(log, "AUTHENTIFICATION PAGE");
		return SUCCESS;

	}
	

	public String userProfile() {

		Collection<? extends GrantedAuthority> ath = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		if (ath.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			
			loggerTools.addBox(log, "ACCESS ADMIN ");
			return "successAdmin";

		}

		else if (ath.contains(new SimpleGrantedAuthority("ROLE_USER"))) {

			loggerTools.addBox(log, "ACCESS USER ");
			return "successUser";

		}

		return SUCCESS;

	}

	public String denied() {
		return SUCCESS;

	}

	
	

}
