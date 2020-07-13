package QControllers;

import java.util.ArrayList;
import Auxiliry.Customer;
import Auxiliry.Movie;
import Auxiliry.Seat;
import Model.OrdersDbApi;

public class OrdersQController {		
	
	private static OrdersDbApi dpApiRef = new OrdersDbApi();

	public static void buyTicket(Integer pInteger, Customer customer, Seat seat) {
		dpApiRef.buyTicket(dpApiRef.getMaxTidBeingUsed() + 1, pInteger, seat, customer);
	}

	public static ArrayList<Movie> getAllMovies() {
		ArrayList<Movie> moviesList = new ArrayList<Movie>();
		moviesList = dpApiRef.getMovies();
		
		return moviesList;
	}
	
	public static ArrayList<String> getAllProjectionAvailableTime(String mname, String date)
	{
		ArrayList<String> returnedArrayList = new ArrayList<String>();
		returnedArrayList = dpApiRef.getAllProjectionAvilableTime(mname,date);
		
		return returnedArrayList;
	}
	
	public static ArrayList<String> showMovieAvailableProjectionDates(String Mname)
	{
		ArrayList<String> returnList = new ArrayList<String>();
	
		returnList = dpApiRef.showMovieAvailableProjectionDates(Mname);
		
		return returnList;
	}
	
    public static Integer getProjectionId(String mid, String date, String time)
	{
		Integer returnInteger = dpApiRef.getProjectionId(mid, date, time);
		
		return returnInteger;
	}

    public static Boolean determineIfSeatIsTaken(Integer Pid, Integer row, Integer col)
    {    	
    	return  dpApiRef.determineIfSeatIsTaken(Pid, row, col);
    }
    
    public static Integer getProjectionPrice(Integer pid)
    {
    	Integer priceInteger = 0;
    	
    	priceInteger = dpApiRef.getProjectionPrice(pid);
    	
    	return priceInteger;
    }

    public static void createOrUpdateCustomer(Customer cust)
    {
    	dpApiRef.createOrUpdateCustomer(cust);
    }

    public static Integer getMovieIdFromName(String moviename) {
    Integer resultInteger = dpApiRef.getMovieIdFromName(moviename);
    return resultInteger;
    }

    public static String getTheatreNameFromPid(Integer projID) {
    	
    	return dpApiRef.getTheatreNameFromPid(projID);
    }
}
