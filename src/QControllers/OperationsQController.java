package QControllers;

import java.util.ArrayList;

import Auxiliry.Movie;
import Auxiliry.Projection;
import Model.OperationsDbApi;

public class OperationsQController {
	
	private static OperationsDbApi dpApiRef = new OperationsDbApi();
	
	public static void deleteMovie(Integer movieID)
	{
		dpApiRef.deativateMovie(movieID);
	}
	
	public static void deleteProjection(Integer Pid)
	{
		dpApiRef.deactivateProjection(Pid);
	}
	
	public static void addMovie(Movie movieToAdd)
	{
		dpApiRef.addMovie(movieToAdd.getmId(), movieToAdd.getMovieName(), movieToAdd.getYearPublished(), movieToAdd.getDirector(), movieToAdd.getDuration(), movieToAdd.getDescription());
	}
	
	public static void addProjection(Projection projectionToAdd)
	{
		dpApiRef.addProjection(projectionToAdd.getpId(), projectionToAdd.getpDateString(), projectionToAdd.getpTimeProjectedString(), projectionToAdd.getTicketPrice(), projectionToAdd.getpMovie(), projectionToAdd.getpTheaterString());
	}

	public static Integer returnMaxMidBeingUsed()
	{
		return dpApiRef.returnMaxMidBeingUsed();
	}
	
	public static ArrayList<Movie> getMovies() {
		return dpApiRef.getMovies();
	}

	public static ArrayList<String> importTheatreList()
	{
		return dpApiRef.importTheatreList();
	}

	public static Integer returnMaxPidBeingUsed()
	{
		return dpApiRef.returnMaxPidBeingUsed();
	}

	public static Integer getMovieIdFromName(String moviename) {
		Integer resultInteger = dpApiRef.getMovieIdFromName(moviename);
		
		return resultInteger;
	}
	
	public static ArrayList<String> getProjectionsIdsAfterDate(String Date) {
		ArrayList<String> pidsList = new ArrayList<String>();
		pidsList = dpApiRef.getProjectionsIdsAfterDate(Date);
		
		return pidsList;
	}
}
