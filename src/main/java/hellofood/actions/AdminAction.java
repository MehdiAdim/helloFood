package hellofood.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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

@SuppressWarnings("serial")
public class AdminAction extends BaseAction {
	
    //DI
	
	private UtilisateurService utilisateurService;
	
	private ReservationService reservationService;
	
	private RestaurantService restaurantService;
	
	private TableService tableService;
	
	//////

	private List<Utilisateur> users;
	
	private List<Reservation> reservations;
	
	private List<Restaurant> restos;
	
	private List<Table> tables;
	 
	private Utilisateur user;

	private List<Table> occupiedTablesNow;
	
	private Long selectedUserToDelete;
	
	public String listPersonnel(){

		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		users= utilisateurService.getAllUsers();
		user = utilisateurService.getPrincipal();
		tables=tableService.getAllTables();
		restos=restaurantService.getAllRestaurants();
		reservations=reservationService.getAllReservations();
		occupiedTablesNow=new ArrayList<Table>();
		System.out.println(occupiedTablesNow.size());
		int i=0;
		for(Table x:tables){
			if(x.getIsOccupied()==true){
				occupiedTablesNow.add(x);
				
				
			}
			i++;
			
			System.out.println(occupiedTablesNow.size());
			
		}
		
		return SUCCESS;

	}


	
	
	public String deleteUser(){
		
		users=utilisateurService.getAllUsers();
			for(Utilisateur u : users){
					if(u.getRole().getRoleName().equals("ROLE_ADMIN")){
						System.out.println("YEEEEES");
					}
			}
		if(selectedUserToDelete!=-1){
			
			
			Utilisateur u = utilisateurService.getUserBy(selectedUserToDelete);
			List<Reservation> listreserv = reservationService.getReservationsByUser(selectedUserToDelete);
			
			try {
				
				for(Reservation r :listreserv){
					reservationService.deleteReservation(r.getIdReservation());
				}
				utilisateurService.deleteUser(u);
			} catch (EntityNotFoundException e) {
				System.out.println("Erreur");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
		return SUCCESS;
	}
	
	public List<Utilisateur> getUsers() {
		return users;
	}


	public Long getSelectedUserToDelete() {
		return selectedUserToDelete;
	}




	public void setSelectedUserToDelete(Long selectedUserToDelete) {
		this.selectedUserToDelete = selectedUserToDelete;
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


	public ReservationService getReservationService() {
		return reservationService;
	}


	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}


	public RestaurantService getRestaurantService() {
		return restaurantService;
	}


	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public List<Restaurant> getRestos() {
		return restos;
	}


	public void setRestos(List<Restaurant> restos) {
		this.restos = restos;
	}


	public TableService getTableService() {
		return tableService;
	}


	public void setTableService(TableService tableService) {
		this.tableService = tableService;
	}


	public List<Table> getTables() {
		return tables;
	}


	public void setTables(List<Table> tables) {
		this.tables = tables;
	}


	public List<Table> getOccupiedTablesNow() {
		return occupiedTablesNow;
	}


	public void setOccupiedTablesNow(List<Table> occupiedTablesNow) {
		this.occupiedTablesNow = occupiedTablesNow;
	}


	


	
	
}
