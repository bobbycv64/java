
public class PersonName extends Person {

	public PersonName(String first, String last) {
		super(first, last);
	}

	@Override
	public String fullName() {
		// TODO Auto-generated method stub
		return getFirstName();
	}
}
