public class Chapter {
  
  // Constructor
  public Chapter() {}

  // Accessor Methods
  public int getNumber()  { return number_; }
  public String getTitle() { return title_; }

  // Mutator Methods
  public void setNumber(int number)   { number_ = number; }
  public void setTitle(String title) { title_ = title; }

  // Attributes
  private int number_ = 0;
  private String title_ = "";
}