package co.com.core.dto;


public class UserDTO implements IBaseDTO {

	private Integer userId;
    private String firstName;
    private String lastName;
    private String completeName;
    private String email;
    private String password;
    private String idNumber;
    private Boolean active;
    private String creationDate;
    private Short accountLocked;
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public Short getAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(Short accountLocked) {
		this.accountLocked = accountLocked;
	}
	
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", idNumber=" + idNumber + ", active=" + active
				+ ", creationDate=" + creationDate + ", accountLocked="
				+ accountLocked + "]";
	}
}
