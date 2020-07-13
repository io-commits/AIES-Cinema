package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Auxiliry.Customer;
import Auxiliry.Movie;
import Auxiliry.Seat;

public class OrdersDbApi extends IDbConnecteble {

	public ArrayList<Movie> getMovies() {
		ArrayList<Movie> returnMovies = new ArrayList<Movie>();

		String sql = "SELECT Movie.Mname, Movie.Mid\r\n" + "FROM Movie,Projection\r\n"
				+ "WHERE Movie.Mid = Projection.Mid AND Projection.Date >= date('now') AND Movie.Active=True AND Projection.Active=True\r\n"
				+ "GROUP BY Movie.Mname";
//been changed
		try (Connection conn = Connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				returnMovies.add(new Movie(rs.getString("Mname"), rs.getInt("Mid")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return returnMovies;
	}

	public ArrayList<String> getAllProjectionAvilableTime(String Mname, String date) {
		ArrayList<String> returnProjectionTime = new ArrayList<String>();
		String sql = "SELECT Projection.Pid, Projection.Time\r\n" + "FROM Projection,Movie\r\n"
				+ "WHERE Projection.Mid=Movie.Mid AND Projection.Date = ? AND Movie.Mname=? AND Projection.Active=True";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, date);
			pstmt.setString(2, Mname);

			ResultSet rs = pstmt.executeQuery();

			// loop through the result set

			while (rs.next()) {
				returnProjectionTime.add(rs.getString("Time"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return returnProjectionTime;
	}

	public Boolean determineIfSeatIsTaken(Integer Pid, Integer row, Integer col) {
		boolean returnedVal = false;

		String sql = "SELECT Pid\r\n" + "FROM TakenSeats\r\n" + "WHERE Pid=? and Row=? and Col=?";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Pid.toString());
			pstmt.setString(2, row.toString());
			pstmt.setString(3, col.toString());

			ResultSet rs = pstmt.executeQuery();

			// loop through the result set

			if (rs.next()) {
				returnedVal = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return returnedVal;
	}

	public ArrayList<String> showMovieAvailableProjectionDates(String Mname) {
		ArrayList<String> returnMovies = new ArrayList<String>();

		String sql = "SELECT Projection.Date\r\n" + "FROM Projection,Movie\r\n"
				+ "WHERE Projection.Mid=Movie.Mid AND Projection.Date >= date('now') AND Movie.Mname=? AND Projection.Active=True \r\n"
				+ "GROUP BY Projection.Date";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Mname);

			ResultSet rs = pstmt.executeQuery();

			// loop through the result set

			while (rs.next()) {
				returnMovies.add(rs.getString("Date"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return returnMovies;
	}

	public Integer getProjectionId(String mid, String date, String time) {
		Integer returnedId = 0;
		
		String sql = "SELECT Projection.Pid\r\n" + "FROM Projection\r\n"
				+ "WHERE Projection.Mid = ? AND Projection.Date = ? AND Projection.Time = ? AND Projection.Active=True";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, mid);
			pstmt.setString(2, date);
			pstmt.setString(3, time);

			ResultSet rs = pstmt.executeQuery();

			// loop through the result set

			
			returnedId = rs.getInt("Pid");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return returnedId;
	}
	
	public Integer getProjectionPrice(Integer pid) {
		Integer price = 0;
		
		String sql = "SELECT Projection.TicketPrice as price\r\n" + "FROM Projection\r\n"
				+ "WHERE Projection.Pid = ? AND Projection.Active=True";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, pid.toString());
			

			ResultSet rs = pstmt.executeQuery();

			// loop through the result set

			
			price = rs.getInt("price");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return price;
	}

	public void createOrUpdateCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(Cid, Name)\r\n" + 
				"VALUES (?, ?)\r\n" + 
				"ON CONFLICT(Cid) DO UPDATE SET Name=?";
		 
        try (Connection conn = Connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customer.getcId());
            pstmt.setString(2, customer.getCustomerName());
            pstmt.setString(3, customer.getCustomerName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	public void buyTicket (Integer Tid, Integer projID, Seat seat, Customer cust) {
		
		String sql1 = "INSERT INTO Ticket (Tid, Row, Column, Pid, Cid)\r\n" + 
				"VALUES (?, ?, ?, ?, ?)";
		
		String sql2 = "INSERT INTO TakenSeats(Row,Col,Pid)\r\n" + 
				"VALUES (?, ?, ?)";
		
		String sql3 = "UPDATE Projection\r\n" + 
				"SET TicketsSold = TicketsSold + 1\r\n" + 
				"WHERE Pid = ?";
		
        try (Connection conn = Connect();
                PreparedStatement pstmt = conn.prepareStatement(sql1)) {
            pstmt.setInt(1, Tid);
            pstmt.setInt(2, seat.getRow());
            pstmt.setInt(3, seat.getCol());
            pstmt.setInt(4, projID);
            pstmt.setInt(5, cust.getcId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        try (Connection conn = Connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {
            pstmt.setInt(1, seat.getRow());
            pstmt.setInt(2, seat.getCol());
            pstmt.setInt(3, projID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        try (Connection conn = Connect();
                PreparedStatement pstmt = conn.prepareStatement(sql3)) {
            pstmt.setInt(1, projID);           
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	public Integer getMaxTidBeingUsed()
	{
		Integer maxMidInteger = 0;
		String sql = "SELECT max(Tid) as max\r\n" + "FROM Ticket";

		try (Connection conn = Connect();
				Statement stmt = conn.createStatement()){
				
				ResultSet rs = stmt.executeQuery(sql);
			// loop through the result set
			maxMidInteger = rs.getInt("max");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return maxMidInteger;
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

	public String getTheatreNameFromPid(Integer projID) {
		String theatreName = null;
		String sql = "SELECT Tname\r\n" + "FROM Projection\r\n" +"WHERE Pid = ?";

		try (Connection connection = Connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, projID);

			ResultSet rs = pstmt.executeQuery();

			// loop through the result set

			
			theatreName = rs.getString("Tname");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return theatreName;
	}

}
