package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Auxiliry.Movie;


public class OperationsDbApi extends IDbConnecteble {

	public void addMovie(Integer Mid, String Mname, Integer Year, String Director, Double Duration, String Description) {
		String sql = "INSERT INTO Movie (Mid, Mname, Year, Director, Duration, Description, Active)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, True)";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, Mid);
			pstmt.setString(2, Mname);
			pstmt.setInt(3, Year);
			pstmt.setString(4, Director);
			pstmt.setDouble(5, Duration);
			pstmt.setString(6, Description);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void addProjection(Integer Pid, String Date, String Time, Double TicketPrice, Integer Mid, String Tname) {
		String sql = "INSERT INTO Projection (Pid, Date, Time, TicketsSold, TicketPrice, Mid, Tname, Active)\r\n"
				+ "VALUES (?, ?, ?, 0, ?, ?, ?, True)";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, Pid);
			pstmt.setString(2, Date);
			pstmt.setString(3, Time);
			pstmt.setDouble(4, TicketPrice);
			pstmt.setInt(5, Mid);
			pstmt.setString(6, Tname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<String> getProjectionsIdsAfterDate(String Date) {
		ArrayList<String> pidsList = new ArrayList<String>();
		String sql = "SELECT Projection.Pid\r\n"
				+ "FROM Projection,Movie\r\n" + "WHERE Projection.Date >= ? AND Projection.Active=True\r\n"+"GROUP BY Projection.Pid";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Date);

			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			
			while (rs.next()) {
				pidsList.add(rs.getString("Pid"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return pidsList;
	}

	public void deativateMovie(Integer mid) {
		String sql = "UPDATE Movie\r\n" + "SET Active=False\r\n" + "WHERE Mid=?";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setString(1, mid.toString());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<String> importTheatreList() {
		
		ArrayList<String> theatreList = new ArrayList<String>();
		String sql = "Select Theater.Tname as TheaterName\r\n" + 
				"From Theater";
        
        try (Connection conn = Connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
        	
            while (rs.next()) {
                theatreList.add(rs.getString("TheaterName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return theatreList;
	}

	public void deactivateProjection(Integer projectionID) {
		String sql = "UPDATE Projection\r\n" + "SET Active=False\r\n" + "WHERE Pid=?";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setString(1, projectionID.toString());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Integer returnMaxMidBeingUsed()
	{
		Integer maxMidInteger = 0;
		String sql = "SELECT max(Mid) as max\r\n" + "FROM Movie\r\n";

		try (Connection conn = Connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			maxMidInteger = rs.getInt("max");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return maxMidInteger;
	}
	
	public Integer returnMaxPidBeingUsed()
	{
		Integer maxMidInteger = 0;
		String sql = "SELECT max(Pid) as max\r\n" + "FROM Projection\r\n";

		try (Connection conn = Connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			maxMidInteger = rs.getInt("max");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return maxMidInteger;
	}

	public ArrayList<Movie> getMovies() {
		ArrayList<Movie> returnMovies = new ArrayList<Movie>();
		
		String sql = "SELECT Mid,Mname as MovieName\r\n" + "FROM Movie\r\n" + "WHERE Active=True";

		try (Connection conn = Connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
		
			// loop through the result set

			while (rs.next()) {
				returnMovies.add(new Movie(rs.getString("MovieName"), rs.getInt("Mid")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return returnMovies;
	}
	
	public Integer getMovieIdFromName(String moviename) {
		Integer mID = 0;
		String sql = "SELECT Mid\r\n" + "FROM Movie\r\n" +"WHERE Movie.Mname=?";

		try (Connection connection = Connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, moviename);

			ResultSet rs = pstmt.executeQuery();

			// loop through the result set

			
				mID = rs.getInt("Mid");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return mID;
	}
}
