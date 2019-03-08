package cv64.jsp.common;

import java.util.Hashtable;

/**
 * <code>SystemProperties</code> class
 *
 * <p>This class gets the system properties from a main program and checks
 * if all the required properties exist
 */

public class SystemProperties {

	/**
	 * Constructor that constructs a hashtable with a specific initial size
	 *
	 * @param numberOfProperties number of properties to construct in hashtable
	 *
	 */
	public SystemProperties(int numberOfProperties) {

		this.numberOfProperties_ = numberOfProperties;
		hashtable_ = new Hashtable(numberOfProperties_);
	}

	/**
	 * No Arg constructor that builds a hashtable with an initial size of 0
	 */
	public SystemProperties() {
		this(0);
	}

	/**
	* Method builds the properties hashtable.
	*
	*/
	public void buildPropertiesHashtable(String[] propertyNames,
	    String[] propertyValues) throws Exception {

		if (debug_)
			System.err.println(
			    "SystemProperties.buildPropertiesHashtable()");

		try {
			for(int i=0; i < numberOfProperties_; i++) {
				hashtable_.put(propertyNames[i], propertyValues[i]);
			}
		} catch (Exception ex) {
			System.err.println("SystemProperties.buildHashtable Exception");
			throw ex;
		}
	}

	/**
	 * Method returns a property from a hashtable
	 *
	 * @param propertyName the property name in the hashtable
	 *
	 * @return property value
	 */
	public String getProperty(String propertyName) {

		if (debug_)
			System.err.println(
			    "SystemProperties.getProperty()");

		return hashtable_.get(propertyName).toString();
	}

	/** Sets the debug flag */
	private static final boolean debug_ = false;
	/** The properties hashtable */
	private Hashtable hashtable_ = null;
	/** The total number properties to build the hashtable. */
	private int numberOfProperties_ = 0;
}
