public class Book {
  
  // 4 argument Constructor
  public Book(String author, String name, String isbn, float price) {
    author_ = author;
    name_ = name;
    isbn_ = isbn;
    price_ = price;
  }

  // 2 argument Constructor
  public Book(String author, String book) {
    this(author, book, "", 0.0f);
  }

  // no argument Constructor
  public Book() {
    this("", "");
  }

  // Accessor Methods
  public String getAuthor() { return author_; }
  public String getName()   { return name_; }
  public String getISBN()   { return isbn_; }
  public float  getPrice()  { return price_; }
  public Chapter getChapter(int chapter) {
    return chapter_[--chapter];
  }

  public String toString() {
    return(author_ + "\n" + name_ + "\n" + isbn_ + "\n" + price_);
  }

  // Mutator Methods
  public void setAuthor(String author) { author_ = author; }
  public void setName(String name)     { name_ = name; }
  public void setISBN(String isbn)     { isbn_ = isbn; }
  public void setPrice(int price)      { price_ = price; }

  public void addChapter(Chapter chapter) { chapter_[i_++] = chapter; }

  // Attributes
  private Chapter[] chapter_ = new Chapter[20]; // max chapters is 20
  private int i_ = 0;            // set ints to 0
  private String author_ = "";   // set strings to blank
  private String name_   = "";   // set strings to blank
  private String isbn_   = "";   // set strings to blank
  private float  price_  = 0.0f; // set floats to 0.0
}