package cv64.exceptions;

class Procedural2 {
    /** holds return value */
    public static int error;

    /**
     * Checks range between 0-9
     *
     * Sets global error variable to 0 if okay, non-zero if out of range
     */
    public static void checkRange(int value) {
	if (value < 0 || value > 9) {
	    error = 1;
	}
	else {
	    error = 0;
	}
    }

    public static void main(String[] args) {
	int value = 4;
	checkRange(value);
	if (error != 0) {
	    /* handle problem */
	    System.out.print("Out of range: " + value + "\n");
	}
	value = 10;
	checkRange(value);
	if (error != 0) {
	    System.out.print("Out of range: " + value + "\n");
	}
	System.exit(0);
    }
}
