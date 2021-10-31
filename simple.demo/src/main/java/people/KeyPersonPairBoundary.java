package people;

public class KeyPersonPairBoundary {
	private String key;
	private Person value;

	public KeyPersonPairBoundary() {
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Person getValue() {
		return value;
	}

	public void setValue(Person value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "KeyPersonPairBoundary [key=" + key + ", value=" + value + "]";
	}

}
