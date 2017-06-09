package exercise2;

public class Test implements Testable {

	private String privateString = "privateString";

	public String publicString = "publicString";

	@Override
	public void test(boolean priv) {
		if (priv) {
			System.out.println("Private String: " + privateString);
		} else {
			System.out.println("Public String: " + publicString);
		}
	}

}
