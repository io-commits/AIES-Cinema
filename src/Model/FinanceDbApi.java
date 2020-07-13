package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.TableModel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import net.proteanit.sql.DbUtils;

public class FinanceDbApi extends IDbConnecteble {

	public TableModel earnedByTime(String fromDate, String toDate) {
		TableModel tableModel = null;
		String sql = "SELECT Projection.Pid as ProjectionID, Projection.Date as Date, Projection.Time as Time, Movie.Mname as Movie, Projection.Tname as TheaterName, Projection.TicketsSold as TicketsSold, (Projection.TicketsSold*Projection.TicketPrice)||'$' as TotalEarned\r\n"
				+ "FROM Projection, Movie\r\n" + "WHERE Projection.Mid = Movie.Mid AND Projection.Date BETWEEN ? AND ?";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, fromDate);
			pstmt.setString(2, toDate);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			tableModel = DbUtils.resultSetToTableModel(rs);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return tableModel;
	}

	public TableModel earnedByMovie() {
		TableModel tableModel = null;
		String sql = "SELECT Movie.Mid, Movie.Mname, sum(Projection.TicketsSold) as TicketsSold, sum(Projection.TicketsSold*Projection.TicketPrice) as MoneyEarned\r\n"
				+ "FROM Movie, Projection\r\n" + "WHERE Movie.Mid = Projection.Mid\r\n" + "GROUP BY Movie.Mname";

		try (Connection conn = Connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set

			tableModel = DbUtils.resultSetToTableModel(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return tableModel;
	}

	public DefaultPieDataset earnedByMovieForPie() {
		DefaultPieDataset pieData = new DefaultPieDataset();
		String curMovieNameString;
		Double curPriceDouble;
		String sql = "SELECT Movie.Mid, Movie.Mname, sum(Projection.TicketsSold) as TicketsSold, sum(Projection.TicketsSold*Projection.TicketPrice) as MoneyEarned\r\n"
				+ "FROM Movie, Projection\r\n" + "WHERE Movie.Mid = Projection.Mid\r\n" + "GROUP BY Movie.Mname";

		try (Connection conn = Connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set

			while (rs.next()) {
				curMovieNameString = rs.getString("MName");
				curPriceDouble = rs.getDouble("MoneyEarned");
				pieData.setValue(curMovieNameString, curPriceDouble);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return pieData;
	}
	
	public DefaultCategoryDataset earnedByMovieForBarChart(String fromDate, String toDate) {
		DefaultCategoryDataset barChartData = new DefaultCategoryDataset();

		String sql = "SELECT Projection.Date as Date, sum((Projection.TicketsSold*Projection.TicketPrice)) as TotalEarned\r\n" +
				"FROM Projection, Movie\r\n" +
				"WHERE Projection.Mid = Movie.Mid AND Projection.Date BETWEEN ? AND ?\r\n" +
				"GROUP BY Projection.Date";

		try (Connection conn = Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, fromDate);
			pstmt.setString(2, toDate);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while(rs.next())
			{
				barChartData.addValue(rs.getDouble("TotalEarned"), rs.getString("Date"), "");
				//barChartData.setValue(rs.getDouble("TotalEarned"), rs.getString("Date"), "");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}


		return barChartData;
	}
}
