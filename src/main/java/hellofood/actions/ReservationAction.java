package hellofood.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.web.BaseAction;

import hellofood.bo.Reservation;
import hellofood.bo.Restaurant;
import hellofood.bo.security.Utilisateur;
import hellofood.services.ReservationService;
import hellofood.services.RestaurantService;
import hellofood.services.UtilisateurService;
import hellofood.tools.DateTools;

@SuppressWarnings("serial")
public class ReservationAction extends BaseAction {


	//  Dependency injection

	private UtilisateurService utilisateurService;

	private RestaurantService restaurantService;

	private DateTools dateTools;
	
	private ReservationService reservationService;

	
	// ----------------------------

	//  struts's action properties

	private Long selectedRestaurant;

	private String beginDate;

	private String beginTime;

	private String endTime;

	private List<Restaurant> restos;

	private Utilisateur user;

	private List<String> erreurs;



	
	

	public DateTools getDateTools() {
		return dateTools;
	}

	public void setDateTools(DateTools dateTools) {
		this.dateTools = dateTools;
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	public List<String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(List<String> erreurs) {
		this.erreurs = erreurs;
	}

	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public RestaurantService getRestaurantService() {
		return restaurantService;
	}

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	public List<Restaurant> getRestos() {
		return restos;
	}

	public void setRestos(List<Restaurant> restos) {
		this.restos = restos;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Long getSelectedRestaurant() {
		return selectedRestaurant;
	}

	public void setSelectedRestaurant(Long selectedRestaurant) {
		this.selectedRestaurant = selectedRestaurant;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	

	public DateTools getdateTools() {
		return dateTools;
	}

	public void setdateTools(DateTools dateTools) {
		this.dateTools = dateTools;
	}

	

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String init(){

		restos=restaurantService.getAllRestaurants();
		
		
		return SUCCESS;
	}


	public String validateReservation(){
		
		if(selectedRestaurant==-1 || beginTime==null || endTime==null || beginDate==null){
			
			HttpSession h=getSession();
			h.setAttribute("erreur", " Empty field(s)");
			
			return "input";
		}
		
		
		
		
		Date from =dateTools.toDate(beginDate+"-"+beginTime);
		Date end =dateTools.toDate(beginDate+"-"+endTime);
		
		
		
		if(!dateTools.isFutureDate(from)){
			
			HttpSession h=getSession();
			h.setAttribute("erreur", " put future date please.");
			
			return "input";
		}
		if(dateTools.isValideDateBeginEnd(from, end)){
			HttpSession h=getSession();
			h.removeAttribute("erreur");
			
			// TO DO
			
			List l =reservationService.getReservationsByRestaurant(selectedRestaurant);
			if(l!=null && l.size()>0){
				
				Reservation r=(Reservation) l.get(0);
				
				System.out.println(r.getEndReservation());
			}

			return SUCCESS;
		}else{
			erreurs = new ArrayList<String>();
			erreurs.add("erreur");
			HttpSession h=getSession();
			h.setAttribute("erreur", "the begin date should be before end date ");
			return "input";
		}
	}





}
