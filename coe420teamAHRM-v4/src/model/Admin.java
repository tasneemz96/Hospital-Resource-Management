package model;

public class Admin extends User{
	private String rank;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int ID, String password, String firstName, String lastName) {
		super(ID, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String password, String firstName, String lastName) {
		super(password, firstName, lastName);
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
