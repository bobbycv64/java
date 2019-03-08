package cv64.jsp.beans;

import cv64.jsp.database.DBResults;

public class Database {

	public Database() {}

	public void display() {
		System.out.println("Database.toString()");

		System.out.println(results.toString() +
		    databaseName + databaseTableName + databaseVendor +
		    description + partNumber + queryList + urlCart +
		    urlDescription + urlImages + urlResponse +
		    Double.toString(price));
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getDatabaseTableName() {
		return databaseTableName;
	}

	public String getDatabaseVendor() {
		return databaseVendor;
	}

	public String getDescription() {
		return description;
	}

	public String getDomainName() {
		return domainName;
	}

	public String getHTMLTable() {

		return results.toHTMLTable();
	}

	public String getPartNumber() {
		return partNumber;
	}

	public DBResults getResults() {
		return results;
	}

	public String getQueryList() {
		return queryList;
	}

	public String getURLCart() {
		return urlCart;
	}

	public String getURLDescription() {
		return urlDescription;
	}

	public String getURLImages() {
		return urlImages;
	}

	public String getURLResponse() {
		return urlResponse;
	}

	public String getURLs() {

		return(urlCart + "\n" + urlDescription + "\n" +
		    urlImages + "\n" + urlResponse);
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public void setDatabaseTableName(String databaseTableName) {
		this.databaseTableName = databaseTableName;
	}

	public void setDatabaseVendor(String databaseVendor) {
		this.databaseVendor = databaseVendor;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public void setResults(DBResults results) {
		this.results = results;
		results.setDatabaseBean(this);
	}

	public void setQueryList(String queryList) {
		this.queryList = queryList;
	}

	public void setURLs(String urlCart, String urlDescription,
	    String urlImages, String urlResponse) {

		this.urlCart = urlCart;
		this.urlDescription = urlDescription;
		this.urlImages = urlImages;
		this.urlResponse = urlResponse;
	}

	private DBResults results;

	private String databaseName;
	private String databaseTableName;
	private String databaseVendor;
	private String description;
	private String domainName;
	private String partNumber;
	private String queryList;
	private String urlCart;
	private String urlDescription;
	private String urlImages;
	private String urlResponse;
	private double price;
}
