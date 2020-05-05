package model;

public abstract class User {
	private String ID;
	private String password;
	private String firstName;
	private String lastName;
	private String branchID;
	 // private static int user_count = 0; //data member to be used for ID's
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String ID, String password, String firstName, String lastName, String branchID) {
		super();
		// this.ID = ++(User.user_count);//ID's start at 1 
		// User.user_count++;//'Next ID' is incremented for every user created
		this.ID = ID;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branchID = branchID;
	}

	//Getters and setters
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	//Other methods
	public boolean changePassword(String new_pass){
		if(new_pass!=this.password) {
			this.password = new_pass;
			return true;}
		else
			return false;
	}	
}
