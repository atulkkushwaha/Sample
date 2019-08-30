package com.Ticket.FileFormat;

public class ITIL {
		 
	    /**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return Date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		Date = date;
	}

	/**
	 * @return the sR_ID
	 */
	public String getSR_ID() {
		return SR_ID;
	}

	/**
	 * @param sR_ID the sR_ID to set
	 */
	public void setSR_ID(String sR_ID) {
		SR_ID = sR_ID;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return Subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		Subject = subject;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @return the engineer
	 */
	public String getEngineer() {
		return Engineer;
	}

	/**
	 * @param engineer the engineer to set
	 */
	public void setEngineer(String engineer) {
		Engineer = engineer;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

		private String Id;
	    private String Date;
	    private String SR_ID;
	    private String Subject;
	    private String Status;
	    private String Engineer;
	    private String Description;
	    
	    public ITIL(){}
	 
	    public ITIL(String Id, String date, String sr_id, String subject, String status, String engineer, String description) {
	        this.Id = Id;
	        this.Date = date;
	        this.SR_ID = sr_id;
	        this.Subject = subject;
	        this.Status= status;
	        this.Engineer=engineer;
	        this.Description=description;
	    }
	 
	   //getters and setter..
	 
	    @Override
	    public String toString() {
	        return Id+Date+SR_ID+Subject;
	    }
	}