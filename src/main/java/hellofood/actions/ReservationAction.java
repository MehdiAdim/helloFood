package hellofood.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

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

@SuppressWarnings("serial")
public class ReservationAction extends BaseAction {


	//  Dependency injection

	private UtilisateurService utilisateurService;

	private RestaurantService restaurantService;
	
	private TableService tableService;

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
	
	private Reservation reservation;



	
	

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
			if(l!=null && l.size()>0){
				
				for(Reservation x :l){
					if((dateTools.isBetween(reservation.getStartReservation(),
							x.getStartReservation(), x.getEndReservation())
							|| dateTools.isBetween(reservation.getEndReservation(),
									x.getStartReservation(), x.getEndReservation())
							) && x.isNotExpired()){
						
						blocked.add(x.getTable());
						
					}
				}
			
			List<Table> all = tableService.getAllTables();
			
			for(Table y : all){
				int i=0;
				for(Table x : blocked){
					
					if(x.getIdTable()==y.getIdTable()){
						i++;
					}
					
				}
				if(i==0){
					try {
						Table maTable = tableService.findTableById(y.getIdTable());
						reservation.setTable(maTable);
						
						
						reservationService.addNewReservation(reservation);
						
					} catch (EntityNotFoundException e) {
						e.printStackTrace();
					}
				}
				
			}
				
				
				
				
				
				
			}

			return SUCCESS;
		}else{
			erreurs = new ArrayList<String>();
			erreurs.add("erreur");
			HttpSession h=getSession();
			h.setAttribute("erreur", "the begin date should be before the end date ");
			return "input";
		}
	}





}
