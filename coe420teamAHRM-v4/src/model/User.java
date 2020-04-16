package model;

public abstract class User {
	private int ID;
	private String password;
	private String firstName;
	private String lastName;
	private static int user_count = 0; //data member to be used for ID's
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int ID, String password, String firstName, String lastName) {
		super();
		// this.ID = ++(User.user_count);//ID's start at 1 
		// User.user_count++;//'Next ID' is incremented for every user created
		this.ID = ID;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String password, String firstName, String lastName) {
		super();
		// this.ID = ++(User.user_count);//ID's start at 1 
		// User.user_count++;//'Next ID' is incremented for every user created
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//Getters and setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
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
	
	//Other methods
	public boolean changePassword(String new_pass){
		if(new_pass!=this.password) {
			this.password = new_pass;
			return true;}
		else
			return false;
	}	
}
