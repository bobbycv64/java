package swing;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class WebAd {

	private DecimalFormat decimalFormat = new DecimalFormat("$#.##");
	private DecimalFormat percentFormat = new DecimalFormat("#.##%");
	private String[] row = new String[4];
	private double unitPrice = 0;
	private double discountRate = 0;
	private double taxRate = 0;
	private double adjustedPrice = 0;

	public WebAd() {

		this.unitPrice = unitPrice().doubleValue() * 100;
		this.discountRate = discountRate().doubleValue();
		this.taxRate = taxRate().doubleValue();
		this.adjustedPrice = adjustedPrice();
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	public BigDecimal unitPrice() {

		BigDecimal randFromDouble = new BigDecimal(Math.random());
		return randFromDouble;
	}

	public BigDecimal discountRate() {

		BigDecimal randFromDouble = new BigDecimal(Math.random());
		return randFromDouble;
	}

	public BigDecimal taxRate() {
		BigDecimal randFromDouble = new BigDecimal(Math.random());
		return randFromDouble;
	}

	public double adjustedPrice() {
		adjustedPrice = unitPrice * (1 - discountRate) * (1 + taxRate);
		return adjustedPrice;
	}

	public String[] getTableRow() {

		row[0] = decimalFormat.format(unitPrice);
		row[1] = percentFormat.format(discountRate);
		row[2] = percentFormat.format(taxRate);
		row[3] = decimalFormat.format(adjustedPrice);

		return row;
	}

	public String toString() {

		return "Unit Price: " + row[0] + " Discount Rate: " + row[1] + " Tax Rate: " + row[2] + " Adjusted Price"
				+ row[3];
	}
}
