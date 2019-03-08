
class Procedural {
    /**
     * Checks range between 0-9
     *
     * @return 0 if okay, non-zero if out of range
     */
    public static int checkRange(int value) {
	if (value < 0 || value > 9) {
	    return 1;
	}
	else {
	    return 0;
	}
    }

    public static void main(String[] args) {
	int value = 4;
	int error = checkRange(value);
	if (error != 0) {
	    /* handle problem */
	    System.out.print("Out of range: " + value + "\n");
	}
	value = 10;
	error = checkRange(value);
	if (error != 0) {
	    System.out.print("Out of range: " + value + "\n");
	}
	System.exit(0);
    }
}
