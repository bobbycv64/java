package general;

public class Args {

	public static void main(String[] args) {
		int numArgs = args.length;
		for (int i = 0; i < numArgs; i++) {
			System.out.println(args[i]);
		}
	}
}