package cv64.applets.eightBall;

import java.util.Random;

public class Response {

  public Response() {}

  private String[] response = {
    "As I See It Yes",
    "It Is Certain",
    "It Is Decidedly So",
    "Most Likely",
    "Outlook Good",
    "Signs Point To Yes",
    "Without A Doubt",
    "Yes",
    "Yes Definitely",
    "You May Rely On It",

    "Ask Again Later",
    "Better Not Tell You Now",
    "Cannot Predict Now",
    "Concentrate and Ask Again",
    "Reply Hazy Try Again",

    "Don't Count On It",
    "My Reply Is No",
    "My Sources Say No",
    "Outlook Not So Good",
    "Very Doubtful"
  };

  public ResponseMessage getResponseMessage() {
    Random random = new Random();
    int i = 0;
    int numberResponses = 19;
    String responseType = "";

    i = random.nextInt(numberResponses + 1);
    if      (i < 10) responseType = "Positive";
    else if (i > 14) responseType = "Negative";
    else             responseType = "Neutral ";

    ResponseMessage responseMessage =
      new ResponseMessage(responseType, response[i]);
    return(responseMessage);
  }
}
