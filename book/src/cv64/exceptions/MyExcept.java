package cv64.exceptions;

class MyExcept {

    public void myMethod(boolean condition) throws Exception {
	System.out.println("In myMethod, condition: " + condition);
	if (condition) {
	    throw new Exception("The condition is " + condition);
	}
    }

    public static void main(String[] args) {
	MyExcept obj = new MyExcept();
	try {
	    obj.myMethod(false);
	    obj.myMethod(true); // exception thrown
	    obj.myMethod(false); // not reached
	}
	catch(Exception exception) {
	    System.out.println(exception.getMessage());
	}
	finally {
	    System.out.println("Optional finally block");
	}
    }
}
