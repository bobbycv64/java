public class Chapter4 {
  
  public static void main(String[] args) {

    Library library = new Library();

    Book teddy = new Book();
    Book java = new Book("Robert Estey", "Java Programming");

    teddy.setName("The Rise of Theodore Roosevelt");
    teddy.setAuthor("Edmund Morris");
    teddy.setPrice(0);
    teddy.setISBN("0-698-10783-7");

    Chapter chapter = new Chapter();
    chapter.setNumber(4);
    chapter.setTitle("Class and Object Implementation");
    java.addChapter(chapter);

    library.addBook("Software");
    library.addBook("Bibliography");

    System.out.println("Total Number of Books in Library: " +
      library.getNumberOfBooks() + "\n");

    System.out.println("Book 1 Information: " + teddy.toString());
    System.out.println();
    System.out.println("Book 2 Information: " + java.toString() + "\n");

    System.out.println("Book 2 - Chapter 4 Title: " +
      java.getChapter(1).getTitle());
  }
}