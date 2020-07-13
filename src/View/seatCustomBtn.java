package View;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Auxiliry.Seat;



@SuppressWarnings("serial")
public class seatCustomBtn extends JButton {
	private ImageIcon icon;
	private Image image;
	private Seat seat;

	public seatCustomBtn(int crow, int ccol) {
		super();
		icon=new ImageIcon("images/seatIconFree.png");
		image= icon.getImage().getScaledInstance(40, 40, 
				Image.SCALE_SMOOTH);
		icon=new ImageIcon(image);
		this.setIcon(icon);
		seat = new Seat(crow+1, ccol+1);
		this.setHorizontalAlignment(CENTER);
		Font btnFont=new Font("Arial", Font.BOLD,10);
		this.setFont(btnFont);		
		this.setOpaque(false);
		this.setContentAreaFilled(false);
	    this.setBorderPainted(false);
		this.setFocusPainted(false);
		}
	
	public void setSeatStatus(Boolean status) {
		seat.isTaken = status;
		if(seat.isTaken==true)
		{
			icon=new ImageIcon("images/seatIconTaken.png");
			image= icon.getImage().getScaledInstance(40, 40, 
					Image.SCALE_SMOOTH);
			icon=new ImageIcon(image);
			this.setIcon(icon);
		}
		else {
			icon=new ImageIcon("images/seatIconFree.png");
			image= icon.getImage().getScaledInstance(40, 40, 
					Image.SCALE_SMOOTH);
			icon=new ImageIcon(image);
			this.setIcon(icon);
			}
		
	}

	public Boolean getSeatStatus() {
		return seat.isTaken;
	}
	
	public String getSeatStatusString() {
	if(seat.isTaken==true)
		return "Seat taken";
	else {
		return "Seat is free";
	}
}

	public Seat getSeat()
	{
		return seat;
	}

}
