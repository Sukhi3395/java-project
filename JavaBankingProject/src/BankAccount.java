
public class BankAccount {
	
	protected int id;
	protected String name;
	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", accountType=" + accountType + ", deposit=" + deposit + ", age=" + age + "]";
	}

	protected String accountType;
	protected double deposit;
	protected int age;
	
public BankAccount(int id,String first,String last,String accountType,double deposit,int age) {
	this.id=id;
	this.name=first+" "+last;
	this.accountType=accountType;
	this.deposit=deposit;
	this.age=age;
	
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

public void setName(String first, String last) {
	this.name = first+" "+last;
}

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
}

public double getDeposit() {
	return deposit;
}

public void setDeposit(double deposit) {
	this.deposit = deposit;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	
	   this.age = age;
}

//a method to return a full string of the customer data to be written in the file
public String writeToFile() {
	return id+","+name+","+accountType+","+deposit+","+age;
}


}
