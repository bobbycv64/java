
class Except2 {
    public int min = 0;
    public int max = 9;
    /**
     * Checks range between min-max
     *
     * @param value the value to check 
     * @exception Exception  if value out of range, min-max
     */
    public void rangeCheck(int value) throws RangeException {
	System.out.println("In rangeCheck, value: " + value);
	if (value < min || value > max) {
	    throw new RangeException(min, max, value);
	}
    }

    public static void main(String[] args) {
	Except2 obj = new Except2();
	try {
	    obj.rangeCheck(3);
	    obj.rangeCheck(10); // exception thrown
	    obj.rangeCheck(5); // not reached
	}
	catch(RangeException e) {
	    System.out.println("In catch: " + e.getMessage());
	    System.out.println(e);
	    System.out.println("Min: " + e.min);
	}
	finally {
	    System.out.println("In finally: Optional");
	}
    }
}
