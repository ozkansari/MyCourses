package spark.template.freemarker.cihangunacti;

public class Order {
     private int id;
     private String name;
     private String lastName;
    

	private String country;
     private String address;
	 private String addressName;
	 private String telephone;
	 private String type;
	 
	

	public static int ID=1;
	 
	 public Order(int id, String name,String lastName,String country,String address,String addressName,String telephone,String type) {
	        this.id = id;
	        this.name = name;
	        this.lastName=lastName;
	        this.country = country;
	        this.address=address;
	        this.addressName=addressName;
	        this.telephone=telephone;
	        this.type=type;
	    }
	 
	 public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAddressName() {
			return addressName;
		}

		public void setAddressName(String addressName) {
			this.addressName = addressName;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		public String getLastName() {
				return lastName;
		}

		public void setLastName(String lastName) {
				this.lastName = lastName;
		}
}
