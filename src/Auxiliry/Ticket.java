package Auxiliry;

public class Ticket {

	private Integer ticketId;
	private Seat tSeat;
	private Projection tProjection;
	private Customer tCustomer;

	public Ticket(Integer cTicketId, Seat CTSeat, Projection CTProjection, Customer CTCustomer) {
		setTicketId(cTicketId);
		settSeat(CTSeat);
		settProjection(CTProjection);
		setCustomer(CTCustomer);

	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Seat gettSeat() {
		return tSeat;
	}

	public void settSeat(Seat tSeat) {
		this.tSeat = tSeat;
	}

	public Projection gettProjection() {
		return tProjection;
	}

	public void settProjection(Projection tProjection) {
		this.tProjection = tProjection;
	}

	public Customer getCustomer() {
		return tCustomer;
	}

	public void setCustomer(Customer inputCustomer) {
		this.tCustomer = inputCustomer;
	}

}
