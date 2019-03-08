
class Except {
    /**
     * Checks range between 0-9
     *
     * @param value the value to check 
     * @exception Exception  if value out of range, 0-9
     */
    public void rangeCheck(int value) throws Exception {
	System.out.println("In rangeCheck, value: " + value);
	if (value < 0 || value > 9) {
	    throw new Exception("Out of range, 0-9. Value: " + value);
	}
    }

    public static void main(String[] args) {
	Except obj = new Except();
	try {
	    obj.rangeCheck(3);
	    obj.rangeCheck(10); // exception thrown
	    obj.rangeCheck(5); // not reached
	}
	catch(Exception e) {
	    System.out.println("In catch: " + e.getMessage());
	}
	finally {
	    System.out.println("In finally: Optional");
	}
    }
}
