public class Eproduct {
	int pid;
	String name;
	float price;
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Eproduct(int pid, String name, float price) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "eproduct [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}
}
