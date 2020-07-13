package Auxiliry;

public class Seat {
	
	private Integer row;
	private Integer col;
	public Boolean isTaken;
	
	public Seat(Integer cRow, Integer cCol)
	{
		setRow(cRow);
		setCol(cCol);
		isTaken=false;		
	}

	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}
	
}
