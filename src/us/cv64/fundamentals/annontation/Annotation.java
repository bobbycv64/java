package us.cv64.fundamentals.annontation;

class A {
    public void show() {
        
        System.out.println("showA");
    }
}

class B extends A {
    public void show() {
        
        System.out.println("showB");
    }
}

public class Annotation {

    public static void main(String[] args ) {
        //B object = new B();
        //object.show();
    }
}
