package cv64.applets.eightBall;

public class ResponseMessage {

  public ResponseMessage(String responseType, String response) {
    responseType_ = responseType;
    response_ = response;
  }

  private String responseType_ = "";
  private String response_ = "";

  public String getResponseType() { return responseType_; }
  public String getResponse() { return response_; }
}
