package hellofood.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.boudaa.dao.exceptions.EntityNotFoundException;
import com.web.BaseAction;

import hellofood.bo.Reservation;
import hellofood.bo.Restaurant;
import hellofood.bo.Table;
import hellofood.bo.security.Utilisateur;
import hellofood.services.ReservationService;
import hellofood.services.RestaurantService;
import hellofood.services.TableService;
import hellofood.services.UtilisateurService;
import hellofood.tools.DateTools;
import hellofood.tools.LoggerTools;

@SuppressWarnings("serial")
public class ReservationAction extends BaseAction {


	//  Dependency injection

	private UtilisateurService utilisateurService;

	private RestaurantService restaurantService;
	
	private TableService tableService;

	private DateTools dateTools;
	
	private ReservationService reservationService;
	
	private LoggerTools loggerTools;

	
	// ----------------------------
	
	protected final Log log = LogFactory.getLog(getClass());

	//  struts's  properties  to get from form

	private Long selectedRestaurant;

	private String beginDate;

	private String beginTime;

	private String endTime;

	//  struts's  properties to send to jsp
	
	private List<Restaurant> restos;
	
	private List<Reservation> userReservations;
	
	private List<Reservation> futureReservations;

	private Utilisateur user;

	private List<String> erreurs;
	
	private Reservation reservation;



	
	

	public LoggerTools getLoggerTools() {
		return loggerTools;
	}

	public void setLoggerTools(LoggerTools loggerTools) {
		this.loggerTools = loggerTools;
	}

	public List<Reservation> getFutureReservations() {
		return futureReservations;
	}

	public void setFutureReservations(List<Reservation> futureReservations) {
		this.futureReservations = futureReservations;
	}

	public List<Reservation> getUserReservations() {
		return userReservations;
	}

	public void setUserReservations(List<Reservation> userReservation) {
		this.userReservations = userReservation;
	}

	public TableService getTableService() {
		return tableService;
	}

	public void setTableService(TableService tableService) {
		this.tableService = tableService;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

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

	public String home(){
		
		user=utilisateurService.getPrincipal();
		
		userReservations=reservationService.getReservationsByUser(user.getIdUtilisateur());
		
		restos=restaurantService.getAllRestaurants();
		
		futureReservations=new ArrayList<Reservation>();
		
		for(Reservation r : userReservations){
			if(r.isNotExpired()){
				
				futureReservations.add(r);
				
			}
		}
		
		
		return SUCCESS;
	}


	public String validateReservation(){
		
		
		// service validation form
		
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
			
			loggerTools.addBox(log, "Valide");
			HttpSession h=getSession();
			h.removeAttribute("erreur");
			
			// TO DO
			reservation=new Reservation();
			reservation.setEndReservation(end);
			reservation.setStartReservation(from);
			reservation.setUser(utilisateurService.getPrincipal());
			reservation.setNotExpired(true);
			try {
				reservation.setRestaurant(restaurantService.findRestaurantByID(selectedRestaurant));
			} catch (EntityNotFoundException e) {
				e.printStackTrace();
			}
			
			
			
			
			List<Table> blocked = new ArrayList<Table>();
			List<Reservation> l =reservationService.getReservationsByRestaurant(selectedRestaurant);
			
			
			DateFormat targetFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
			

			
			if(l!=null && l.size()>0){
				
				for(Reservation x :l){
					
					if(x.isNotExpired() &&( x.getStartReservation().getTime()==from.getTime()
							|| dateTools.isBetween(from, x.getStartReservation(), x.getEndReservation())
							|| dateTools.isBetween(end, x.getStartReservation(), x.getEndReservation())
							)){
						
						
						blocked.add(x.getTable());
						loggerTools.addBox(log, "YES");
						
					}
				}
				
				
				/////
				loggerTools.addBox(log, blocked.size()+" ");
			
			List<Table> all = tableService.getAllTablesByRestaurant(selectedRestaurant);
			
		
			
				for(Table x : blocked){
					
					if(all.contains(x))
						all.remove(x);
					}
					
				if(all.size()==0){
					return "tableInvalid";
				}
				
				else{
					
					
						
						reservation.setTable(all.get(0));

						// update reservations tables with real time
						
						reservationService.updateReservationDate();
						
						//--------------------------------------
						reservationService.addNewReservation(reservation);
						loggerTools.addBox(log, "RESERVATION ADDED");
					
						
					
				}

				
				}
				

			return SUCCESS;
			
	
	
			}else{
		
			
			HttpSession h=getSession();
			h.setAttribute("erreur", "the begin date should be before the end date ");
			return "input";
		}
	}





}
