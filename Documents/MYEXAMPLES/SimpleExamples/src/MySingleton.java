

public class MySingleton {
	private static final MySingleton INSTANCE = new MySingleton();
	private int x = 0;

	private MySingleton() {
	}

	public static MySingleton getInstance() {
		return INSTANCE;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}
}
