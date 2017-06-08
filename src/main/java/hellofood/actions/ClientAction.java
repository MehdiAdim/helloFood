package hellofood.actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.boudaa.dao.exceptions.EntityNotFoundException;
import com.web.BaseAction;

import hellofood.bo.Restaurant;
import hellofood.bo.security.Utilisateur;
import hellofood.services.RestaurantService;
import hellofood.services.UtilisateurService;

public class ClientAction extends BaseAction {

	//  Dependency injection

	private UtilisateurService utilisateurService;

	private RestaurantService restaurantService;

	//  struts's action properties

	private Long selectedRestaurant;

	private String beginDate;

	private String beginTime;

	private List<Restaurant> restos;

	private Utilisateur user;

	public String execute(){
		System.out.println("Execuuuuute");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
		String dateInString = "14/06/2017-01:02";
		try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		
		return SUCCESS;
	}

	public String init(){

		restos=restaurantService.getAllRestaurants();

		return SUCCESS;
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




}
