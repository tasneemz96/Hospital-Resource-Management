package model;

public class Bed {
    private int bedNumber;
    private int status;
    private String patientID;

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Bed(int bedNumber, int status, String patientID) {
        this.bedNumber = bedNumber;
        this.status = status;
        this.patientID = patientID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
    	// statuses can be one of 1, 2, 3, 4
    	// 1 = ready
    	// 2 = occupied
    	// 3 = dirty
    	// 4 = cleaning
        this.status = status;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    
}
