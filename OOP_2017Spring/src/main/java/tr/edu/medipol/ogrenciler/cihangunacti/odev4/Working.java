package tr.edu.medipol.ogrenciler.cihangunacti.odev4;




public abstract class Working {
	protected String EmployeeName;
	protected String WorkingYear;
	protected String WorkingType;
	protected String WorkingSalary;
	
	public Working (String EmployeeName,String WorkingYear,String WorkingType,String WorkingSalary){
		this.EmployeeName=EmployeeName;
		this.WorkingYear=WorkingYear;
		this.WorkingType=WorkingType;
		this.WorkingSalary=WorkingSalary;

		
	}

}
