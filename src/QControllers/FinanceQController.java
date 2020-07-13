package QControllers;

import javax.swing.table.TableModel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import Model.FinanceDbApi;


public class FinanceQController {

	private static FinanceDbApi dpApiRef = new FinanceDbApi();
	
	public static TableModel getMoviesEarnings() {
		TableModel defaultTableModel = dpApiRef.earnedByMovie();

		return defaultTableModel;
	}

	public static TableModel earnedByTime(String fromDate, String toDate) {
		TableModel defaultTableModel = dpApiRef.earnedByTime(fromDate, toDate);

		return defaultTableModel;

	}

	public static DefaultPieDataset getMovieEarningsForPie() {
		DefaultPieDataset dfDataset = dpApiRef.earnedByMovieForPie();
		return dfDataset;
	}

	public static DefaultCategoryDataset earnedByMovieForBarChart(String fromDate, String toDate) {
		DefaultCategoryDataset earnedByMovieForBarChart = new DefaultCategoryDataset();
		earnedByMovieForBarChart = dpApiRef.earnedByMovieForBarChart(fromDate, toDate);
		return earnedByMovieForBarChart;
	}
}
