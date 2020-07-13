package Auxiliry;

public class Customer {
	private Integer cId;
	private String customerName;
	
	public Customer(Integer cCId, String cCustomerNameString)
	{
		setcId(cCId);
		setCustomerName(cCustomerNameString);
		
	}
	
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerNameString) {
		this.customerName = customerNameString;
	}
	
}
