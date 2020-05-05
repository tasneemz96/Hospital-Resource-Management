package model;

public class Admin extends User{
	private String rank;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String ID, String password, String firstName, String lastName, String branchID, String type) {
		super(ID, password, firstName, lastName, branchID);
		this.rank = type;
		// TODO Auto-generated constructor stub
	}
	
	//Getters and setters
	public String getRank() {
		return rank;
	}
	public boolean setRank(int new_rank) { //new_rank: 0 means branch admin, 1 means top-level admin
		if(new_rank==0) {
			this.rank = "branch";
			return true;}
		else if (new_rank==1) {
			this.rank = "top-level";
			return true;}
		else
			return false;
	}
	
	
}
