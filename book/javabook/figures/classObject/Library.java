public class Library {

  // Constructor
  public Library() {}

  // Accessor Methods
  public int getNumberOfBooks() { return numberOfBooks_; }
  public String getCategory()      { return category_; }
  public boolean checkedOut()      { return checkedOut_; }

  // Mutator Methods
  public void addBook(String category) { 
    numberOfBooks_++;
    category_ = category;
  }
  
  public void setCategory(String category)    { category_ = category; }
  public void setCheckOut(boolean checkedOut) { checkedOut_ = checkedOut; }

  // Attributes
  private static int numberOfBooks_ = 0;
  private String category_ = "";
  private boolean checkedOut_ = false;
}