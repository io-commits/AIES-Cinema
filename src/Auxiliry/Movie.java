package Auxiliry;

public class Movie {
	private Integer mId;
	private Integer yearPublished;
	private Double duration;
	private Integer ticketsSold;
	private Double moneyEarned;
	private String movieName;
	private String director;
	private String description;

	public Movie(String cmovieName, Integer cmID) {
		setmId(cmID);
		setMovieName(cmovieName);
	}

	public Movie(Integer cMid, Integer cYearPublished, Double cDuration, String cMovieName, String cDirector,
			String cDescription) {
		setmId(cMid);
		setYearPublished(cYearPublished);
		setDuration(cDuration);
		setMovieName(cMovieName);
		setDirector(cDirector);
		setDescription(cDescription);
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer inputmIdmId) {
		this.mId = inputmIdmId;
	}

	public Integer getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(Integer inputyearPublished) {
		this.yearPublished = inputyearPublished;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double inputduration) {
		this.duration = inputduration;
	}

	public Integer getTicketsSold() {
		return ticketsSold;
	}

	public void setTicketsSold(Integer inputticketsSold) {
		this.ticketsSold = inputticketsSold;
	}

	public Double getMoneyEarned() {
		return moneyEarned;
	}

	public void setMoneyEarned(Double inputmoneyEarned) {
		this.moneyEarned = inputmoneyEarned;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String inputmovieName) {
		this.movieName = inputmovieName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String inputdirector) {
		this.director = inputdirector;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String inputdescription) {
		description = inputdescription;
	}

}
