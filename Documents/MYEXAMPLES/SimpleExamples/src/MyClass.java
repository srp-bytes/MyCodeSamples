
public class MyClass {
	MySingleton singletonObj = MySingleton.getInstance();

	public void setX(int x) {
		singletonObj.setX(x);
	}

	public int getX() {

		return singletonObj.getX();
	}

	public static void main(String[] args) {
		MyClass frstObj = new MyClass();
		frstObj.setX(10);
		MyClass secondObj = new MyClass();
		secondObj.setX(20);
		System.out.println("first Object" + frstObj.getX());
		System.out.println("second Object" + secondObj.getX());
	}

}
