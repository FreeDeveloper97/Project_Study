package Week9;

class Entry<K, V> {
	private K key;
	private V value;
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
public class EX9_EntryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Entry<String, Integer> e1 = new Entry<>("김선달", 20);
		Entry<String, String> e2 = new Entry<>("기타", "등등");
		
		System.out.println(e1.getKey() + " " + e1.getValue());
		System.out.println(e2.getKey() + " " + e2.getValue());
	}

}
