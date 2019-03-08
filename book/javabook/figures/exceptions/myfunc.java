
class myfunc {

    public static int myfunc(int value) {
	if (value == 4) {
	    return 0;
	}
	return 1;
    }

    public static void main(String[] args) {
	int error = myfunc(4);
	if (error != 0) {
	    /* handle problem */
	    System.out.print("myfunc problem\n");
	}
	/* continue */
	System.out.print("myfunc okay\n");
	error = myfunc(3);
	if (error != 0) {
	    System.out.print("myfunc problem\n");
	}
	System.exit(0);
    }
}
