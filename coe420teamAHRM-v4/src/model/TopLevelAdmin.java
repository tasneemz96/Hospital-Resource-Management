package model;

public class TopLevelAdmin extends Admin {

	private String TAdminID; 

	public TopLevelAdmin() {
		// TODO Auto-generated constructor stub
	}
	
	public TopLevelAdmin(int ID, String firstName, String lastName, String password) {
		super(ID, password, firstName, lastName);
		// TODO Auto-generated constructor stub
		this.setRank(1); //rank of 1 zero means top-level Admin
		this.TAdminID = "T"+ super.getID();
	}
	
	public TopLevelAdmin(String firstName, String lastName, String password) {
		super(password, firstName, lastName);
		// TODO Auto-generated constructor stub
		this.setRank(1); //rank of 1 zero means top-level Admin
		this.TAdminID = "T"+ super.getID();
	}

	public String getTAdminID(){
		return TAdminID;
	}

	public void setTAdminID(String TAdminID){
		this.TAdminID = TAdminID;
	}
}
