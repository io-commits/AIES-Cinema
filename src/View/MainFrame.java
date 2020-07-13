package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Auxiliry.Customer;
import Auxiliry.InputVerifacator;
import Auxiliry.Movie;
import Auxiliry.Projection;
import QControllers.FinanceQController;
import QControllers.OperationsQController;
import QControllers.OrdersQController;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	final int THEATRE_ROW = 10;
	final int THEATRE_COL = 10;

	// Main View

	private JLayeredPane layeredPane;
	private JPanel topPane;
	private JLabel topPaneLogo;
	private JPanel contentPane;

	// End Main View

	// Finance Components
	private JButton btnFinance;
	private JButton btnFinanceShowData;
	private JButton btnFinanceShowCandleData;
	private JPanel panelFinance;
	private JPanel panelFinancePieChart;
	private JPanel panelFinanceMovie;
	private JPanel panelFinanceEarnByTime;
	private JPanel panelFinanceCandleChart;
	private JTextField textFieldFinanceFromDate;
	private JTextField textFieldFinanceToDate;
	private JTable tableFinanceByMovie;
	private JTable tableFinanceByDate;
	private JScrollPane financeByMovieScrollPane;
	private JScrollPane financeByTimeScrollPane;
	private JLabel lblFinanceMovie;
	private JLabel lblFinanceFromDate;
	private JLabel lblFinanceToDate;
	// End Finance

	// Operations Components
	private JButton btnOperations;
	private JButton btnOperationsConfirmMovie;
	private JButton btnOperationsClearMovie;
	private JButton btnOperationsProjectionConfirm;
	private JButton btnOperationsProjectionClear;
	private JButton btnOperationManageMoviesDelete;
	private JButton btnOperationsManageProjectionsDelete;
	private JTextField textFieldOperationsMovieName;
	private JTextField textFieldOperationsMovieDuration;
	private JTextField textFieldOperationsMovieDirector;
	private JTextField textFieldOperationsYearPublished;
	private JTextField textFieldOperationsMovieDescription;
	private JTextField textFieldOperationsProjectionTicketPrice;
	private JTextField textFieldOperationsProjectionDate;
	private JTextField textFieldOperationsProjectionTime;
	private JComboBox<String> comboBoxOperationsManageMoviesSelectMovie;
	private JComboBox<String> comboBoxOperationsProjectionMovie;
	private JComboBox<String> comboBoxOperationsManageProjection;
	private JComboBox<String> comboBoxOperationsProjectionTheater;
	private JPanel panelOperations;
	private JPanel panelOperationsAddMovie;
	private JPanel panelOperationsAddProjection;
	private JPanel panelOperationsManageMovies;
	private JPanel panelOperationsManageProjections;
	private JLabel lblOperationsMovieName;
	private JLabel lblOperationsMovieDuration;
	private JLabel lblOperationsMovieDirector;
	private JLabel lblOperationsDescription;
	private JLabel lblOperationsAddMovie;
	private JLabel lblOperationsYearPublished;
	private JLabel lblOperationsAddProjection;
	private JLabel lblOperationsProjectionMovie;
	private JLabel lblOperationsProjectionMovieFilter;
	private JLabel lblOperationsProjectionTheater;
	private JLabel lblOperationsProjectionDate;
	private JLabel lblOperationsProjectionTime;
	private JLabel lblOperationsManageMovie;
	private JLabel lblOperationsManageMoviesSelectMovie;
	private JLabel lblOperationsManageProjections;
	private JLabel lblOperationsManagePRojectionSelctProjection;

	// End Operations

	// Orders Components and variables
	private Integer pidInteger;
	private seatCustomBtn[][] seatsBtnArr;

	private JButton btnOrders;
	private JButton btnOrdersBuyTicket;
	private JTextField textFieldOrdersCustomerName;
	private JTextField textFieldOrdersCustomerID;
	private JTextField textFieldOrdersSeatRow;
	private JTextField textFieldOrdersSeatColumn;
	private JTextField textFieldOrdersPrice;
	private JTextField textFieldOrdersTheatre;
	private JComboBox<String> comboBoxOrdersMovie;
	private JComboBox<String> comboBoxOrdersDate;
	private JComboBox<String> comboBoxOrdersTime;
	private JPanel panelOrdersSelectMovieAndProjection;
	private JPanel panelOrdersselectTickets;
	private JPanel panelOrders;
	private JPanel panelOrdersSeat;
	private JLabel lblOrdersMovie;
	private JLabel lblOrdersDate;
	private JLabel lblOrdersTime;
	private JLabel lblOrdersSelectMovieTitle;
	private JLabel lblOrdersPrice;
	private JLabel lblOrdersSeatRow;
	private JLabel lblOrdersCustomerName;
	private JLabel lblOrdersCustomerID;
	private JLabel lblOrdersSeatColumn;
	private JLabel lblOrdersSelctTicketsTitle;
	private JLabel lblOrdersTheatre;
	// End Orders

	public MainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1549, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 159, 1531, 794);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		panelFinance = new JPanel();
		panelFinance.setBackground(SystemColor.activeCaption);
		layeredPane.add(panelFinance);
		panelFinance.setLayout(null);

		panelFinanceMovie = new JPanel();
		panelFinanceMovie.setBackground(SystemColor.info);
		panelFinanceMovie.setBounds(25, 25, 740, 750);
		panelFinance.add(panelFinanceMovie);
		panelFinanceMovie.setLayout(null);

		lblFinanceMovie = new JLabel("Select Movie:");
		lblFinanceMovie.setBounds(20, 20, 170, 50);
		panelFinanceMovie.add(lblFinanceMovie);
		lblFinanceMovie.setForeground(Color.DARK_GRAY);
		lblFinanceMovie.setFont(new Font("Narkisim", Font.BOLD, 26));

		btnFinanceShowData = new JButton("Show Data");
		btnFinanceShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableFinanceByMovie.setModel(FinanceQController.getMoviesEarnings());
				DefaultPieDataset pieDataset = FinanceQController.getMovieEarningsForPie();
				JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart", pieDataset, true, true, true);
				ChartPanel chartPanel = new ChartPanel(chart);
				panelFinancePieChart.removeAll();
				panelFinancePieChart.add(chartPanel);
				panelFinancePieChart.updateUI();
			}
		});
		btnFinanceShowData.setBounds(200, 20, 150, 50);
		panelFinanceMovie.add(btnFinanceShowData);
		btnFinanceShowData.setForeground(Color.DARK_GRAY);
		btnFinanceShowData.setFont(new Font("Narkisim", Font.BOLD, 26));

		financeByMovieScrollPane = new JScrollPane();
		financeByMovieScrollPane.setBounds(20, 80, 700, 180);
		panelFinanceMovie.add(financeByMovieScrollPane);

		tableFinanceByMovie = new JTable();
		financeByMovieScrollPane.setViewportView(tableFinanceByMovie);

		panelFinancePieChart = new JPanel();
		panelFinancePieChart.setBounds(20, 280, 700, 450);
		panelFinanceMovie.add(panelFinancePieChart);

		panelFinanceEarnByTime = new JPanel();
		panelFinanceEarnByTime.setBackground(SystemColor.info);
		panelFinanceEarnByTime.setBounds(780, 25, 740, 750);
		panelFinance.add(panelFinanceEarnByTime);
		panelFinanceEarnByTime.setLayout(null);

		financeByTimeScrollPane = new JScrollPane();
		financeByTimeScrollPane.setBounds(20, 80, 700, 180);
		panelFinanceEarnByTime.add(financeByTimeScrollPane);

		tableFinanceByDate = new JTable();
		financeByTimeScrollPane.setViewportView(tableFinanceByDate);

		lblFinanceFromDate = new JLabel("From Date:");
		lblFinanceFromDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinanceFromDate.setForeground(Color.DARK_GRAY);
		lblFinanceFromDate.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblFinanceFromDate.setBounds(15, 16, 140, 55);
		panelFinanceEarnByTime.add(lblFinanceFromDate);

		lblFinanceToDate = new JLabel("To Date:");
		lblFinanceToDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinanceToDate.setForeground(Color.DARK_GRAY);
		lblFinanceToDate.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblFinanceToDate.setBounds(285, 16, 120, 55);
		panelFinanceEarnByTime.add(lblFinanceToDate);

		textFieldFinanceFromDate = new JTextField();
		textFieldFinanceFromDate.setForeground(new Color(147, 112, 219));
		textFieldFinanceFromDate.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldFinanceFromDate.setColumns(10);
		textFieldFinanceFromDate.setBounds(160, 16, 120, 55);
		panelFinanceEarnByTime.add(textFieldFinanceFromDate);

		textFieldFinanceToDate = new JTextField();
		textFieldFinanceToDate.setForeground(new Color(147, 112, 219));
		textFieldFinanceToDate.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldFinanceToDate.setColumns(10);
		textFieldFinanceToDate.setBounds(400, 16, 120, 55);
		panelFinanceEarnByTime.add(textFieldFinanceToDate);

		panelFinanceCandleChart = new JPanel();
		panelFinanceCandleChart.setBounds(20, 280, 700, 450);
		panelFinanceEarnByTime.add(panelFinanceCandleChart);

		btnFinanceShowCandleData = new JButton("Show Data");
		btnFinanceShowCandleData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldFinanceFromDate.getText().equals("") == false && textFieldFinanceToDate.getText().equals("") == false) {
					try {
						
					String fromDate = InputVerifacator.verifyDate(textFieldFinanceFromDate.getText());
					String toDate = InputVerifacator.verifyDate(textFieldFinanceToDate.getText());
					tableFinanceByDate.setModel(FinanceQController.earnedByTime(fromDate, toDate));
					DefaultCategoryDataset barChartDataset = FinanceQController.earnedByMovieForBarChart(
							textFieldFinanceFromDate.getText(), textFieldFinanceToDate.getText());
					JFreeChart chart = ChartFactory.createBarChart("Report", "Dates color index", "Income",
							barChartDataset);
					CategoryPlot plot = chart.getCategoryPlot();
					plot.setRangeGridlinePaint(Color.black);
					ChartPanel chartPanel = new ChartPanel(chart);
					panelFinanceCandleChart.removeAll();
					panelFinanceCandleChart.add(chartPanel);
					panelFinanceCandleChart.updateUI();
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(panelFinanceEarnByTime, e.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(panelFinanceEarnByTime, "From date and To date fields must not be empty", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnFinanceShowCandleData.setForeground(Color.DARK_GRAY);
		btnFinanceShowCandleData.setFont(new Font("Narkisim", Font.BOLD, 26));
		btnFinanceShowCandleData.setBounds(565, 16, 150, 50);
		panelFinanceEarnByTime.add(btnFinanceShowCandleData);

		panelOperations = new JPanel();
		panelOperations.setBackground(SystemColor.activeCaption);
		layeredPane.add(panelOperations);
		panelOperations.setLayout(null);

		panelOperationsAddMovie = new JPanel();
		panelOperationsAddMovie.setBackground(new Color(255, 255, 224));
		panelOperationsAddMovie.setBounds(25, 25, 450, 750);
		panelOperations.add(panelOperationsAddMovie);
		panelOperationsAddMovie.setLayout(null);

		lblOperationsMovieName = new JLabel("Movie Name:");
		lblOperationsMovieName.setForeground(Color.DARK_GRAY);
		lblOperationsMovieName.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsMovieName.setBounds(20, 150, 160, 43);
		panelOperationsAddMovie.add(lblOperationsMovieName);

		lblOperationsMovieDuration = new JLabel("Duration:");
		lblOperationsMovieDuration.setForeground(Color.DARK_GRAY);
		lblOperationsMovieDuration.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsMovieDuration.setBounds(20, 200, 174, 55);
		panelOperationsAddMovie.add(lblOperationsMovieDuration);

		lblOperationsMovieDirector = new JLabel("Director:");
		lblOperationsMovieDirector.setForeground(Color.DARK_GRAY);
		lblOperationsMovieDirector.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsMovieDirector.setBounds(20, 250, 120, 63);
		panelOperationsAddMovie.add(lblOperationsMovieDirector);

		lblOperationsDescription = new JLabel("Description:");
		lblOperationsDescription.setForeground(Color.DARK_GRAY);
		lblOperationsDescription.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsDescription.setBounds(20, 350, 150, 43);
		panelOperationsAddMovie.add(lblOperationsDescription);

		textFieldOperationsMovieName = new JTextField();
		textFieldOperationsMovieName.setForeground(new Color(147, 112, 219));
		textFieldOperationsMovieName.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOperationsMovieName.setBounds(250, 150, 150, 40);
		panelOperationsAddMovie.add(textFieldOperationsMovieName);
		textFieldOperationsMovieName.setColumns(10);

		textFieldOperationsMovieDuration = new JTextField();
		textFieldOperationsMovieDuration.setForeground(new Color(147, 112, 219));
		textFieldOperationsMovieDuration.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOperationsMovieDuration.setColumns(10);
		textFieldOperationsMovieDuration.setBounds(250, 200, 150, 40);
		panelOperationsAddMovie.add(textFieldOperationsMovieDuration);

		textFieldOperationsMovieDirector = new JTextField();
		textFieldOperationsMovieDirector.setForeground(new Color(147, 112, 219));
		textFieldOperationsMovieDirector.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOperationsMovieDirector.setColumns(10);
		textFieldOperationsMovieDirector.setBounds(250, 250, 150, 40);
		panelOperationsAddMovie.add(textFieldOperationsMovieDirector);

		textFieldOperationsMovieDescription = new JTextField();
		textFieldOperationsMovieDescription.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldOperationsMovieDescription.setForeground(new Color(147, 112, 219));
		textFieldOperationsMovieDescription.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOperationsMovieDescription.setColumns(10);
		textFieldOperationsMovieDescription.setBounds(250, 350, 150, 270);
		panelOperationsAddMovie.add(textFieldOperationsMovieDescription);

		btnOperationsConfirmMovie = new JButton("Confirm");
		btnOperationsConfirmMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldOperationsYearPublished.getText().equals("") == false && textFieldOperationsMovieName.getText().equals("") == false
						&& textFieldOperationsMovieDirector.getText().equals("") == false
						&& textFieldOperationsMovieDuration.getText().equals("") == false
						&& textFieldOperationsMovieDescription.getText().equals("") == false) {

					Integer yearPublishedInteger = 0;
					Double movieDurationDouble = 0.0;
					String directorString;
					try {

						yearPublishedInteger = InputVerifacator.verifyYear(textFieldOperationsYearPublished.getText());
						movieDurationDouble = InputVerifacator.verifyDouble("Movie Duration",
								textFieldOperationsMovieDuration.getText());
						directorString = InputVerifacator.verifyName("Director Name",
								textFieldOperationsMovieDirector.getText());

						Movie movie = new Movie(OperationsQController.returnMaxMidBeingUsed() + 1, yearPublishedInteger,
								movieDurationDouble, textFieldOperationsMovieName.getText(), directorString,
								textFieldOperationsMovieDescription.getText());
						OperationsQController.addMovie(movie);

						comboBoxOperationsProjectionMovie.removeAllItems();
						comboBoxOperationsManageMoviesSelectMovie.removeAllItems();

						for (Movie refreshedMovie : OperationsQController.getMovies()) {
							comboBoxOperationsProjectionMovie.addItem(refreshedMovie.getMovieName());
							comboBoxOperationsManageMoviesSelectMovie.addItem(refreshedMovie.getMovieName());
						}

						JOptionPane.showMessageDialog(panelOperationsAddMovie,
								"Movie has been added to db successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception e) {
						JOptionPane.showMessageDialog(panelOperationsAddMovie, e.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else {
					JOptionPane.showMessageDialog(panelOperationsAddMovie,"All fields must be filled to execute that operation", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnOperationsConfirmMovie.setForeground(Color.DARK_GRAY);
		btnOperationsConfirmMovie.setFont(new Font("Narkisim", Font.BOLD, 26));
		btnOperationsConfirmMovie.setBounds(50, 650, 150, 50);
		panelOperationsAddMovie.add(btnOperationsConfirmMovie);

		btnOperationsClearMovie = new JButton("Clear");
		btnOperationsClearMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldOperationsMovieDescription.setText("");
				textFieldOperationsMovieDirector.setText("");
				textFieldOperationsMovieDuration.setText("");
				textFieldOperationsMovieName.setText("");
			}
		});
		btnOperationsClearMovie.setForeground(Color.DARK_GRAY);
		btnOperationsClearMovie.setFont(new Font("Narkisim", Font.BOLD, 26));
		btnOperationsClearMovie.setBounds(250, 650, 150, 50);
		panelOperationsAddMovie.add(btnOperationsClearMovie);

		lblOperationsAddMovie = new JLabel("Add Movie");
		lblOperationsAddMovie.setBackground(Color.WHITE);
		lblOperationsAddMovie.setBounds(0, 0, 450, 108);
		panelOperationsAddMovie.add(lblOperationsAddMovie);
		lblOperationsAddMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperationsAddMovie.setFont(new Font("Narkisim", Font.BOLD, 40));

		lblOperationsYearPublished = new JLabel("Year Published:");
		lblOperationsYearPublished.setForeground(Color.DARK_GRAY);
		lblOperationsYearPublished.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsYearPublished.setBounds(20, 300, 174, 55);
		panelOperationsAddMovie.add(lblOperationsYearPublished);

		textFieldOperationsYearPublished = new JTextField();
		textFieldOperationsYearPublished.setForeground(new Color(147, 112, 219));
		textFieldOperationsYearPublished.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOperationsYearPublished.setColumns(10);
		textFieldOperationsYearPublished.setBounds(250, 300, 150, 40);
		panelOperationsAddMovie.add(textFieldOperationsYearPublished);

		panelOperationsAddProjection = new JPanel();
		panelOperationsAddProjection.setBackground(new Color(255, 255, 224));
		panelOperationsAddProjection.setBounds(535, 25, 450, 750);
		panelOperations.add(panelOperationsAddProjection);
		panelOperationsAddProjection.setLayout(null);

		lblOperationsAddProjection = new JLabel("Add Projection");
		lblOperationsAddProjection.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperationsAddProjection.setFont(new Font("Narkisim", Font.BOLD, 40));
		lblOperationsAddProjection.setBounds(0, 0, 450, 108);
		panelOperationsAddProjection.add(lblOperationsAddProjection);

		lblOperationsProjectionMovie = new JLabel("Movie Name:");
		lblOperationsProjectionMovie.setForeground(Color.DARK_GRAY);
		lblOperationsProjectionMovie.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsProjectionMovie.setBounds(50, 150, 160, 43);
		panelOperationsAddProjection.add(lblOperationsProjectionMovie);

		comboBoxOperationsProjectionMovie = new JComboBox<String>();
		for (Movie movie : OperationsQController.getMovies()) {
			comboBoxOperationsProjectionMovie.addItem(movie.getMovieName());
		}

		comboBoxOperationsProjectionMovie.setFont(new Font("Narkisim", Font.BOLD, 26));
		comboBoxOperationsProjectionMovie.setBounds(250, 150, 150, 40);
		panelOperationsAddProjection.add(comboBoxOperationsProjectionMovie);

		lblOperationsProjectionMovieFilter = new JLabel("Ticket Price:");
		lblOperationsProjectionMovieFilter.setForeground(Color.DARK_GRAY);
		lblOperationsProjectionMovieFilter.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsProjectionMovieFilter.setBounds(50, 250, 160, 43);
		panelOperationsAddProjection.add(lblOperationsProjectionMovieFilter);

		textFieldOperationsProjectionTicketPrice = new JTextField();
		textFieldOperationsProjectionTicketPrice.setForeground(new Color(147, 112, 219));
		textFieldOperationsProjectionTicketPrice.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOperationsProjectionTicketPrice.setColumns(10);
		textFieldOperationsProjectionTicketPrice.setBounds(250, 250, 150, 40);
		panelOperationsAddProjection.add(textFieldOperationsProjectionTicketPrice);

		lblOperationsProjectionTheater = new JLabel("Select Theatre:");
		lblOperationsProjectionTheater.setForeground(Color.DARK_GRAY);
		lblOperationsProjectionTheater.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsProjectionTheater.setBounds(50, 350, 173, 43);
		panelOperationsAddProjection.add(lblOperationsProjectionTheater);

		comboBoxOperationsProjectionTheater = new JComboBox<String>();
		for (String theatreString : OperationsQController.importTheatreList()) {
			comboBoxOperationsProjectionTheater.addItem(theatreString);
		}
		comboBoxOperationsProjectionTheater.setFont(new Font("Narkisim", Font.BOLD, 26));
		comboBoxOperationsProjectionTheater.setBounds(250, 350, 150, 40);
		panelOperationsAddProjection.add(comboBoxOperationsProjectionTheater);

		lblOperationsProjectionDate = new JLabel("Date:");
		lblOperationsProjectionDate.setForeground(Color.DARK_GRAY);
		lblOperationsProjectionDate.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsProjectionDate.setBounds(50, 450, 76, 43);
		panelOperationsAddProjection.add(lblOperationsProjectionDate);

		textFieldOperationsProjectionDate = new JTextField();
		textFieldOperationsProjectionDate.setForeground(new Color(147, 112, 219));
		textFieldOperationsProjectionDate.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOperationsProjectionDate.setColumns(10);
		textFieldOperationsProjectionDate.setBounds(250, 450, 150, 40);
		panelOperationsAddProjection.add(textFieldOperationsProjectionDate);

		lblOperationsProjectionTime = new JLabel("Time:");
		lblOperationsProjectionTime.setForeground(Color.DARK_GRAY);
		lblOperationsProjectionTime.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsProjectionTime.setBounds(50, 550, 76, 43);
		panelOperationsAddProjection.add(lblOperationsProjectionTime);

		textFieldOperationsProjectionTime = new JTextField();
		textFieldOperationsProjectionTime.setForeground(new Color(147, 112, 219));
		textFieldOperationsProjectionTime.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOperationsProjectionTime.setColumns(10);
		textFieldOperationsProjectionTime.setBounds(250, 550, 150, 40);
		panelOperationsAddProjection.add(textFieldOperationsProjectionTime);

		btnOperationsProjectionConfirm = new JButton("Confirm");
		btnOperationsProjectionConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxOperationsProjectionMovie.getSelectedItem().equals("") == false
						&& textFieldOperationsProjectionTicketPrice.getText().equals("") == false
						&& comboBoxOperationsProjectionTheater.getSelectedItem().toString().equals("") == false
						&& textFieldOperationsProjectionDate.getText().equals("") == false
						&& textFieldOperationsProjectionTime.getText().equals("") == false) {
					try {

						Double ticketPriceDouble = InputVerifacator.verifyDouble("Ticket Price",
								textFieldOperationsProjectionTicketPrice.getText());
						String dateString = InputVerifacator.verifyDate(textFieldOperationsProjectionDate.getText());
						String timeString = InputVerifacator.verifyTime(textFieldOperationsProjectionTime.getText());

						OperationsQController.addProjection(
								new Projection(OperationsQController.returnMaxPidBeingUsed() + 1, ticketPriceDouble, 0,
										OperationsQController.getMovieIdFromName(
												comboBoxOperationsProjectionMovie.getSelectedItem().toString()),
										comboBoxOperationsProjectionTheater.getSelectedItem().toString(), dateString,
										timeString));

						comboBoxOperationsManageProjection.removeAllItems();
						for (String pid : OperationsQController.getProjectionsIdsAfterDate("0001-01-01")) {
							comboBoxOperationsManageProjection.addItem(pid);
						}

						JOptionPane.showMessageDialog(panelOperationsAddProjection,
								"Projection has been added to db successfully", "Success!",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(panelOperationsAddProjection, e.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(panelOperationsAddProjection, "All fields must be filled to execute that operation", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnOperationsProjectionConfirm.setForeground(Color.DARK_GRAY);
		btnOperationsProjectionConfirm.setFont(new Font("Narkisim", Font.BOLD, 26));
		btnOperationsProjectionConfirm.setBounds(50, 650, 150, 50);
		panelOperationsAddProjection.add(btnOperationsProjectionConfirm);

		btnOperationsProjectionClear = new JButton("Clear");
		btnOperationsProjectionClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldOperationsProjectionDate.setText("");
				textFieldOperationsProjectionTicketPrice.setText("");
				textFieldOperationsProjectionTime.setText("");
			}
		});
		btnOperationsProjectionClear.setForeground(Color.DARK_GRAY);
		btnOperationsProjectionClear.setFont(new Font("Narkisim", Font.BOLD, 26));
		btnOperationsProjectionClear.setBounds(250, 650, 150, 50);
		panelOperationsAddProjection.add(btnOperationsProjectionClear);

		panelOperationsManageMovies = new JPanel();
		panelOperationsManageMovies.setBackground(new Color(255, 255, 224));
		panelOperationsManageMovies.setBounds(1050, 25, 450, 350);
		panelOperations.add(panelOperationsManageMovies);
		panelOperationsManageMovies.setLayout(null);

		lblOperationsManageMovie = new JLabel("Manage Movies");
		lblOperationsManageMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperationsManageMovie.setFont(new Font("Narkisim", Font.BOLD, 40));
		lblOperationsManageMovie.setBounds(0, 0, 450, 108);
		panelOperationsManageMovies.add(lblOperationsManageMovie);

		lblOperationsManageMoviesSelectMovie = new JLabel("Select Movie:");
		lblOperationsManageMoviesSelectMovie.setForeground(Color.DARK_GRAY);
		lblOperationsManageMoviesSelectMovie.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsManageMoviesSelectMovie.setBounds(50, 150, 160, 43);
		panelOperationsManageMovies.add(lblOperationsManageMoviesSelectMovie);

		comboBoxOperationsManageMoviesSelectMovie = new JComboBox<String>();
		comboBoxOperationsManageMoviesSelectMovie.setFont(new Font("Narkisim", Font.BOLD, 26));
		comboBoxOperationsManageMoviesSelectMovie.setBounds(250, 150, 150, 40);
		panelOperationsManageMovies.add(comboBoxOperationsManageMoviesSelectMovie);
		for (Movie movie : OperationsQController.getMovies()) {
			comboBoxOperationsManageMoviesSelectMovie.addItem(movie.getMovieName());
		}

		btnOperationManageMoviesDelete = new JButton("Delete");
		btnOperationManageMoviesDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OperationsQController.deleteMovie(OperationsQController
						.getMovieIdFromName(comboBoxOperationsManageMoviesSelectMovie.getSelectedItem().toString()));
				comboBoxOperationsManageMoviesSelectMovie.removeAllItems();
				comboBoxOperationsProjectionMovie.removeAllItems();
				for (Movie movie : OperationsQController.getMovies()) {
					comboBoxOperationsManageMoviesSelectMovie.addItem(movie.getMovieName());
					comboBoxOperationsProjectionMovie.addItem(movie.getMovieName());

				}

			}
		});
		btnOperationManageMoviesDelete.setForeground(Color.DARK_GRAY);
		btnOperationManageMoviesDelete.setFont(new Font("Narkisim", Font.BOLD, 26));
		btnOperationManageMoviesDelete.setBounds(150, 250, 150, 50);
		panelOperationsManageMovies.add(btnOperationManageMoviesDelete);

		panelOperationsManageProjections = new JPanel();
		panelOperationsManageProjections.setLayout(null);
		panelOperationsManageProjections.setBackground(new Color(255, 255, 224));
		panelOperationsManageProjections.setBounds(1050, 425, 450, 350);
		panelOperations.add(panelOperationsManageProjections);

		lblOperationsManageProjections = new JLabel("Manage Projections");
		lblOperationsManageProjections.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperationsManageProjections.setFont(new Font("Narkisim", Font.BOLD, 40));
		lblOperationsManageProjections.setBounds(0, 0, 450, 108);
		panelOperationsManageProjections.add(lblOperationsManageProjections);

		lblOperationsManagePRojectionSelctProjection = new JLabel("Select Projection:");
		lblOperationsManagePRojectionSelctProjection.setForeground(Color.DARK_GRAY);
		lblOperationsManagePRojectionSelctProjection.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOperationsManagePRojectionSelctProjection.setBounds(50, 150, 194, 43);
		panelOperationsManageProjections.add(lblOperationsManagePRojectionSelctProjection);

		comboBoxOperationsManageProjection = new JComboBox<String>();
		comboBoxOperationsManageProjection.removeAllItems();
		for (String pid : OperationsQController.getProjectionsIdsAfterDate("01/01/0001")) {
			comboBoxOperationsManageProjection.addItem(pid);
		}

		comboBoxOperationsManageProjection.setFont(new Font("Narkisim", Font.BOLD, 26));
		comboBoxOperationsManageProjection.setBounds(250, 150, 150, 40);
		panelOperationsManageProjections.add(comboBoxOperationsManageProjection);

		btnOperationsManageProjectionsDelete = new JButton("Delete");
		btnOperationsManageProjectionsDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OperationsQController.deleteProjection(
						Integer.parseInt(comboBoxOperationsManageProjection.getSelectedItem().toString()));
				comboBoxOperationsManageProjection.removeAllItems();
				for (String pid : OperationsQController.getProjectionsIdsAfterDate("01/01/0001")) {
					comboBoxOperationsManageProjection.addItem(pid);
				}

			}
		});
		btnOperationsManageProjectionsDelete.setForeground(Color.DARK_GRAY);
		btnOperationsManageProjectionsDelete.setFont(new Font("Narkisim", Font.BOLD, 26));
		btnOperationsManageProjectionsDelete.setBounds(150, 250, 150, 50);
		panelOperationsManageProjections.add(btnOperationsManageProjectionsDelete);

		panelOrders = new JPanel();
		panelOrders.setBackground(SystemColor.activeCaption);
		layeredPane.add(panelOrders);
		panelOrders.setLayout(null);

		panelOrdersSeat = new JPanel();
		panelOrdersSeat.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seats",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOrdersSeat.setBounds(1000, 25, 500, 500);
		panelOrdersSeat.setLayout(new GridLayout(10, 10));
		panelOrders.add(panelOrdersSeat);

		panelOrdersSelectMovieAndProjection = new JPanel();
		panelOrdersSelectMovieAndProjection.setBackground(SystemColor.info);
		panelOrdersSelectMovieAndProjection.setBounds(25, 25, 450, 750);
		panelOrders.add(panelOrdersSelectMovieAndProjection);
		panelOrdersSelectMovieAndProjection.setLayout(null);

		lblOrdersMovie = new JLabel("Movie:");
		lblOrdersMovie.setForeground(Color.DARK_GRAY);
		lblOrdersMovie.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOrdersMovie.setBounds(50, 160, 174, 55);
		panelOrdersSelectMovieAndProjection.add(lblOrdersMovie);

		lblOrdersDate = new JLabel("Date:");
		lblOrdersDate.setForeground(Color.DARK_GRAY);
		lblOrdersDate.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOrdersDate.setBounds(50, 240, 174, 55);
		panelOrdersSelectMovieAndProjection.add(lblOrdersDate);

		lblOrdersTime = new JLabel("Time:");
		lblOrdersTime.setForeground(Color.DARK_GRAY);
		lblOrdersTime.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOrdersTime.setBounds(50, 320, 174, 55);
		panelOrdersSelectMovieAndProjection.add(lblOrdersTime);

		comboBoxOrdersMovie = new JComboBox<String>();
		comboBoxOrdersMovie.setFont(new Font("Narkisim", Font.BOLD, 26));
		comboBoxOrdersMovie.setBounds(180, 160, 200, 50);
		panelOrdersSelectMovieAndProjection.add(comboBoxOrdersMovie);
		comboBoxOrdersMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxOrdersMovie.getItemCount() != 0)
				{
					ArrayList<String> availableDateList = OrdersQController
							.showMovieAvailableProjectionDates(comboBoxOrdersMovie.getSelectedItem().toString());
					comboBoxOrdersDate.removeAllItems();

					for (String string : availableDateList) {
						comboBoxOrdersDate.addItem(string);
					}
				}
			}
		});

		comboBoxOrdersDate = new JComboBox<String>();
		comboBoxOrdersDate.setFont(new Font("Narkisim", Font.BOLD, 26));
		comboBoxOrdersDate.setBounds(180, 240, 200, 50);
		panelOrdersSelectMovieAndProjection.add(comboBoxOrdersDate);

		comboBoxOrdersDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxOrdersTime.removeAllItems();
				if (comboBoxOrdersDate.getSelectedItem() != null) {
					ArrayList<String> availableTime = OrdersQController.getAllProjectionAvailableTime(
							comboBoxOrdersMovie.getSelectedItem().toString(),
							comboBoxOrdersDate.getSelectedItem().toString());
					for (String string : availableTime) {
						comboBoxOrdersTime.addItem(string);
					}
				}
			}
		});

		comboBoxOrdersTime = new JComboBox<String>();
		comboBoxOrdersTime.setFont(new Font("Narkisim", Font.BOLD, 26));
		comboBoxOrdersTime.setBounds(180, 320, 200, 50);
		panelOrdersSelectMovieAndProjection.add(comboBoxOrdersTime);

		comboBoxOrdersTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOrdersSeat.removeAll();
				Integer mInteger = 0;
				for (Movie movie : OrdersQController.getAllMovies()) {
					if (movie.getMovieName().equals(comboBoxOrdersMovie.getSelectedItem().toString())) {
						mInteger = movie.getmId();
						break;
					}
				}
				if (comboBoxOrdersDate.getSelectedItem() != null && comboBoxOrdersTime.getSelectedItem() != null) {
					pidInteger = OrdersQController.getProjectionId(mInteger.toString(),
							comboBoxOrdersDate.getSelectedItem().toString(),
							comboBoxOrdersTime.getSelectedItem().toString());
					textFieldOrdersPrice.setText(OrdersQController.getProjectionPrice(pidInteger).toString());
					textFieldOrdersTheatre.setText(OrdersQController.getTheatreNameFromPid(pidInteger));

					seatsBtnArr = new seatCustomBtn[THEATRE_ROW][THEATRE_COL];
					for (int i = 0; i < THEATRE_ROW; i++) {
						for (int j = 0; j < THEATRE_COL; j++) {
							seatsBtnArr[i][j] = new seatCustomBtn(i, j);
							seatsBtnArr[i][j]
									.setSeatStatus(OrdersQController.determineIfSeatIsTaken(pidInteger, i + 1, j + 1));
							panelOrdersSeat.add(seatsBtnArr[i][j]);
						}
					}				
				}
				panelOrdersSeat.repaint();
				panelOrdersSeat.revalidate();
			}
		});

		lblOrdersSelectMovieTitle = new JLabel("Select Movie and Projection");
		lblOrdersSelectMovieTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdersSelectMovieTitle.setFont(new Font("Narkisim", Font.BOLD, 30));
		lblOrdersSelectMovieTitle.setBounds(0, 0, 450, 150);
		panelOrdersSelectMovieAndProjection.add(lblOrdersSelectMovieTitle);

		panelOrdersselectTickets = new JPanel();
		panelOrdersselectTickets.setBackground(SystemColor.info);
		panelOrdersselectTickets.setBounds(510, 25, 450, 750);
		panelOrders.add(panelOrdersselectTickets);
		panelOrdersselectTickets.setLayout(null);

		lblOrdersPrice = new JLabel("Price:");
		lblOrdersPrice.setForeground(Color.DARK_GRAY);
		lblOrdersPrice.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOrdersPrice.setBounds(20, 490, 174, 55);
		panelOrdersselectTickets.add(lblOrdersPrice);

		lblOrdersSeatRow = new JLabel("Seat Row:");
		lblOrdersSeatRow.setForeground(Color.DARK_GRAY);
		lblOrdersSeatRow.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOrdersSeatRow.setBounds(20, 320, 174, 55);
		panelOrdersselectTickets.add(lblOrdersSeatRow);

		lblOrdersCustomerName = new JLabel("Customer Name:");
		lblOrdersCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdersCustomerName.setForeground(Color.DARK_GRAY);
		lblOrdersCustomerName.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOrdersCustomerName.setBounds(20, 160, 187, 55);
		panelOrdersselectTickets.add(lblOrdersCustomerName);

		lblOrdersCustomerID = new JLabel("Customer ID:");
		lblOrdersCustomerID.setForeground(Color.DARK_GRAY);
		lblOrdersCustomerID.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOrdersCustomerID.setBounds(20, 240, 174, 55);
		panelOrdersselectTickets.add(lblOrdersCustomerID);

		lblOrdersSeatColumn = new JLabel("Seat Column:");
		lblOrdersSeatColumn.setForeground(Color.DARK_GRAY);
		lblOrdersSeatColumn.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOrdersSeatColumn.setBounds(20, 410, 174, 55);
		panelOrdersselectTickets.add(lblOrdersSeatColumn);

		lblOrdersSelctTicketsTitle = new JLabel("Select Tickets");
		lblOrdersSelctTicketsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdersSelctTicketsTitle.setFont(new Font("Narkisim", Font.BOLD, 30));
		lblOrdersSelctTicketsTitle.setBounds(0, 0, 450, 150);
		panelOrdersselectTickets.add(lblOrdersSelctTicketsTitle);

		textFieldOrdersCustomerName = new JTextField();
		textFieldOrdersCustomerName.setForeground(new Color(147, 112, 219));
		textFieldOrdersCustomerName.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOrdersCustomerName.setColumns(10);
		textFieldOrdersCustomerName.setBounds(218, 160, 200, 55);
		panelOrdersselectTickets.add(textFieldOrdersCustomerName);

		textFieldOrdersCustomerID = new JTextField();
		textFieldOrdersCustomerID.setForeground(new Color(147, 112, 219));
		textFieldOrdersCustomerID.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOrdersCustomerID.setColumns(10);
		textFieldOrdersCustomerID.setBounds(218, 240, 200, 55);
		panelOrdersselectTickets.add(textFieldOrdersCustomerID);

		textFieldOrdersSeatRow = new JTextField();
		textFieldOrdersSeatRow.setForeground(new Color(147, 112, 219));
		textFieldOrdersSeatRow.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOrdersSeatRow.setColumns(10);
		textFieldOrdersSeatRow.setBounds(218, 320, 200, 55);
		panelOrdersselectTickets.add(textFieldOrdersSeatRow);

		textFieldOrdersSeatColumn = new JTextField();
		textFieldOrdersSeatColumn.setForeground(new Color(147, 112, 219));
		textFieldOrdersSeatColumn.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOrdersSeatColumn.setColumns(10);
		textFieldOrdersSeatColumn.setBounds(218, 410, 200, 55);
		panelOrdersselectTickets.add(textFieldOrdersSeatColumn);

		textFieldOrdersPrice = new JTextField();
		textFieldOrdersPrice.setEditable(false);
		textFieldOrdersPrice.setForeground(new Color(147, 112, 219));
		textFieldOrdersPrice.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOrdersPrice.setColumns(10);
		textFieldOrdersPrice.setBounds(218, 490, 200, 55);
		panelOrdersselectTickets.add(textFieldOrdersPrice);

		btnOrdersBuyTicket = new JButton("Buy Ticket");
		btnOrdersBuyTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pidInteger = OrdersQController.getProjectionId(
						OrdersQController.getMovieIdFromName(comboBoxOrdersMovie.getSelectedItem().toString())
								.toString(),
						comboBoxOrdersDate.getSelectedItem().toString(),
						comboBoxOrdersTime.getSelectedItem().toString());
				try {

					Integer rowInteger = InputVerifacator.verifyTheatreRangeItem("Theatre Row",
							textFieldOrdersSeatRow.getText(), THEATRE_ROW);
					Integer colInteger = InputVerifacator.verifyTheatreRangeItem("Theatre Column",
							textFieldOrdersSeatColumn.getText(), THEATRE_COL);

					if (OrdersQController.determineIfSeatIsTaken(pidInteger, rowInteger, colInteger)) {
						JOptionPane.showMessageDialog(null, "Pay attention! You have just selected already taken seat",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {

						String customerNameString = InputVerifacator.verifyName("Customer Name",
								textFieldOrdersCustomerName.getText());
						Integer customerID = InputVerifacator.verifyId(textFieldOrdersCustomerID.getText());

						Customer customer = new Customer(customerID, customerNameString);
						OrdersQController.createOrUpdateCustomer(customer);
						OrdersQController.buyTicket(pidInteger, customer,
								seatsBtnArr[rowInteger - 1][colInteger - 1].getSeat());
						seatsBtnArr[rowInteger - 1][colInteger - 1].setSeatStatus(true);

						panelOrdersSeat.repaint();
						panelOrdersSeat.revalidate();

						JOptionPane.showMessageDialog(panelOrdersselectTickets, "Ticket has been bought successfully",
								"Success!", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(panelOrdersselectTickets, e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnOrdersBuyTicket.setForeground(Color.DARK_GRAY);
		btnOrdersBuyTicket.setFont(new Font("Narkisim", Font.BOLD, 26));
		btnOrdersBuyTicket.setBounds(120, 650, 200, 50);
		panelOrdersselectTickets.add(btnOrdersBuyTicket);

		lblOrdersTheatre = new JLabel("Theatre:");
		lblOrdersTheatre.setForeground(Color.DARK_GRAY);
		lblOrdersTheatre.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblOrdersTheatre.setBounds(20, 570, 174, 55);
		panelOrdersselectTickets.add(lblOrdersTheatre);

		textFieldOrdersTheatre = new JTextField();
		textFieldOrdersTheatre.setForeground(new Color(147, 112, 219));
		textFieldOrdersTheatre.setFont(new Font("Narkisim", Font.BOLD, 26));
		textFieldOrdersTheatre.setEditable(false);
		textFieldOrdersTheatre.setColumns(10);
		textFieldOrdersTheatre.setBounds(218, 570, 200, 55);
		panelOrdersselectTickets.add(textFieldOrdersTheatre);
		topPane = new JPanel();
		topPane.setBackground(SystemColor.inactiveCaption);
		topPane.setBounds(0, 0, 1531, 159);
		contentPane.add(topPane);

		btnFinance = new JButton("Finance");
		btnFinance.setBounds(10, 10, 250, 140);
		btnFinance.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(panelFinance);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		topPane.setLayout(null);
		btnFinance.setBackground(UIManager.getColor("Button.background"));
		btnFinance.setForeground(new Color(153, 0, 0));
		btnFinance.setFont(new Font("Narkisim", Font.BOLD, 40));
		topPane.add(btnFinance);

		btnOperations = new JButton("Operations");
		btnOperations.setBounds(270, 10, 250, 140);
		btnOperations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelOperations);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnOperations.setBackground(UIManager.getColor("Button.background"));
		btnOperations.setForeground(new Color(153, 0, 0));
		btnOperations.setFont(new Font("Narkisim", Font.BOLD, 40));
		topPane.add(btnOperations);

		btnOrders = new JButton("Orders");
		btnOrders.setBounds(530, 10, 250, 140);
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comboBoxOrdersMovie.removeAllItems();
				ArrayList<Movie> movies = OrdersQController.getAllMovies();
				for (Movie movie : movies) {
					comboBoxOrdersMovie.addItem(movie.getMovieName());
				}
				if(movies.size() == 0)
				{
					comboBoxOrdersMovie.removeAllItems();
					comboBoxOrdersDate.removeAllItems();
				}
				
				layeredPane.removeAll();
				layeredPane.add(panelOrders);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnOrders.setBackground(UIManager.getColor("Button.background"));
		btnOrders.setForeground(new Color(153, 0, 0));
		btnOrders.setFont(new Font("Narkisim", Font.BOLD, 40));
		topPane.add(btnOrders);

		topPaneLogo = new JLabel("");
		topPaneLogo.setHorizontalAlignment(SwingConstants.CENTER);
		topPaneLogo.setIcon(new ImageIcon(MainFrame.class.getResource("/Logo.png")));
		topPaneLogo.setBounds(800, 10, 710, 140);
		topPane.add(topPaneLogo);

	}
}
