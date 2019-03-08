package cv64.jsp.beans;

import java.util.StringTokenizer;

public class OrderBean {

	public OrderBean() {}

	public String getAddress1() { return address1; }
	public String getAddress2() { return address2; }
	public String getBusinessPhone() { return businessPhone; }
	public String getCity() { return city; }
	public String getComments() { return comments; }
	public String getCompanyName() { return companyName; }
	public String getDomainName() { return domainName; }
	public String getDomainStatus() { return domainStatus; }
	public String getEmailAddress() { return emailAddress; }
	public String getFirstName() { return firstName; }
	public String getHomePhone() { return homePhone; }
	public String getLastName() { return lastName; }
	public String getOrder() {

		StringBuffer buffer = new StringBuffer();
		buffer.append("Address1: " + address1 + "\n");
		buffer.append("Address2: " + address2 + "\n");
		buffer.append("Business Phone: " + businessPhone + "\n");
		buffer.append("City: " + city + "\n");
		buffer.append("Comments: " + comments + "\n");
		buffer.append("Company Name: " + companyName + "\n");
		buffer.append("Domain Name: " + domainName + "\n");
		buffer.append("Domain Status: " + domainStatus + "\n");
		buffer.append("Email Address: " + emailAddress + "\n");
		buffer.append("First Name: " + firstName + "\n");
		buffer.append("Home Phone: " + homePhone + "\n");
		buffer.append("Last Name: " + lastName + "\n");
		buffer.append("Plan " + plan + "\n");
		buffer.append("Plan Name: " + planName + "\n");
		buffer.append("Plan Number: " + planNumber + "\n");
		buffer.append("State: " + state + "\n");
		buffer.append("Subject: " + subject + "\n");
		buffer.append("Zip Code: " + zipCode + "\n");

		return buffer.toString();
	}

	public String getPlan() { return plan; }
	public String getPlanName() { return planName; }
	public String getPlanNumber() { return planNumber; }
	public String getRequiredFields() { return buffer; }
	public String getState() { return state; }
	public String getSubject() { return subject; }
	public String getZipCode() { return zipCode; }

	public void setAddress1(String address1) { this.address1 = address1; }
	public void setAddress2(String address2) { this.address2 = address2; }
	public boolean setBusinessPhone(String businessPhone) {

		if (businessPhone.equals("")) {
			return true;
		}

		this.businessPhone = businessPhone;
		return false;
	}

	public void setCity(String city) { this.city = city; }
	public void setComments(String comments) { this.comments = comments; }
	public void setCompanyName(String companyName) { this.companyName = companyName; }
	public void setDomainName(String domainName) { this.domainName = domainName; }
	public void setDomainStatus(String domainStatus) { this.domainStatus = domainStatus; }
	public boolean setEmailAddress(String emailAddress) {

		if (emailAddress.equals("")) {
			return true;
		}

		this.emailAddress = emailAddress;
		return false;
	}

	public void setFirstName(String firstName) { this.firstName = firstName; }
	public boolean setHomePhone(String homePhone) {

		if (homePhone.equals("")) {
			return true;
		}

		this.homePhone = homePhone;
		return false;
	}

	public void setLastName(String lastName) { this.lastName = lastName; }

	public void setPlan(String plan) {

		this.plan = plan;

		StringTokenizer token = new StringTokenizer(plan);

		while (token.hasMoreTokens()) {
			this.planName = token.nextToken();
			this.planNumber = token.nextToken();
		}
	}

	public void setRequiredFields(StringBuffer buffer) { this.buffer = buffer.toString(); }
	public void setState(String state) { this.state = state; }
	public void setSubject(String subject) { this.subject = subject; }
	public void setZipCode(String zipCode) { this.zipCode = zipCode; }

	private String address1;
	private String address2;
	private String buffer;
	private String businessPhone;
	private String city;
	private String comments;
	private String companyName;
	private String domainName;
	private String domainStatus;
	private String emailAddress;
	private String firstName;
	private String homePhone;
	private String lastName;
	private String plan;
	private String planName;
	private String planNumber;
	private String state;
	private String subject;
	private String zipCode;
}
