package model;

public class BranchAdmin extends Admin {
	
	private int branchID; //ID of branch to which Admin is assigned
	private String BRAdminID; 

	public BranchAdmin() {
		// TODO Auto-generated constructor stub
	}
	public BranchAdmin(String firstName, String lastName, String password) {
		super(password, firstName, lastName);
		// TODO Auto-generated constructor stub
		this.setRank(0); //rank of 0 zero means branch Admin
		this.BRAdminID = "BR" + super.getID();
	}
	
	public BranchAdmin(int ID, String firstName, String lastName, String password, int branchID) {
		super(ID, password, firstName, lastName);
		// TODO Auto-generated constructor stub
		this.setRank(0); //rank of 0 zero means branch Admin
		this.branchID = branchID;
		this.BRAdminID = "BR" + super.getID();
	}

	public BranchAdmin(String firstName, String lastName, String password, int branchID) {
		super(password, firstName, lastName);
		// TODO Auto-generated constructor stub
		this.setRank(0); //rank of 0 zero means branch Admin
		this.branchID = branchID;
		this.BRAdminID = "BR" + super.getID();
	}

	//Getters and setters
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public String getBRAdminID(){
		return BRAdminID;
	}	

	public void setBRAdminID(String BRAdminID){
		this.BRAdminID = BRAdminID;
	}
	
}
