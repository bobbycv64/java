package cv64.jsp.beans;

import java.util.StringTokenizer;

public class QueryBean {

	public QueryBean() {}

	public String getPartNumber() { return partNumber_; }
	public String getDescription() { return description_; }
	public String getSellingPrice() { return sellingPrice_; }
	public String getResults() { return results_; }

	public void setPartNumber(String partNumber) { partNumber_ = partNumber; }
	public void setDescription(String description) { description_ = description; }
	public void setSellingPrice(String sellingPrice) { sellingPrice_ = sellingPrice; }
	public void setResults(String results) { results_ = results; }

	private String partNumber_;
	private String description_;
	private String sellingPrice_;
	private String results_;
}
