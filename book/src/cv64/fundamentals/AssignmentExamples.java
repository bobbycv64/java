package cv64.fundamentals;

public class AssignmentExamples {
  public static void main(String[] args) {

    int i     = 64;       // integer declaration and assignment
    short s   = 64;       // short declaration and assignment
    long l    = 64L;      // long declaration and assignment

    float f   = 64.64f;   // float declaration and assignment
    double d  = 64.64d;   // double declaration and assignment

    boolean b = true;     // boolean declaration and assignment
    byte by   = 64;       // byte declaration and assignment
    char ch   = '\u0064'; // char declaration and assignment

    String string = new String();

    System.out.println("int's value is:     " + i);
    System.out.println("short's value is:   " + s);
    System.out.println("long's value is:    " + l);
    System.out.println("float's value is:   " + f);
    System.out.println("double's value is:  " + d);
    System.out.println("boolean's value is: " + b);
    System.out.println("byte's value is:    " + by);
    System.out.println("char's value is:    " + (string.valueOf(ch)));
  }
}
