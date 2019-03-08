public class BreakContinueLabelFlowControl {
  
  public static void main(String[] args) {

    int   year     = 1;
    int   goal     = 100000;
    float balance  = 0f;
    float interest = 0.0725f;
    float payment  = 2000f;

    while (year <= 30) {

      balance = (balance + payment) * (1 + interest);

      // if loan paid off then break out of loop
      if (balance > goal) break;

      // if 30 years of payments then continue out of loop
      if (year == 30) continue;

      System.out.println(
        "year: " + year + 
        "\tbalance: " + balance + 
        "\tpayment: " + payment);

      year++;
    }
  }
}