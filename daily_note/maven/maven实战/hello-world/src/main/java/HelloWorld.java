public class HelloWorld {
	public String sayHello() {
		return "Hello";
	}

	public static void main(String[] args) {
		System.out.print(new HelloWorld().sayHello());
	}
}