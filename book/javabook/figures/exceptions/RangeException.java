
class RangeException extends Exception {

    public int min;
    public int max;
    public int value;

    public RangeException(int min, int max, int value) {
	// message to superclass ctor
	super(value + " out of range: " + min + "-" + max);
	this.min = min;
	this.max = max;
	this.value = value;
    }
}
