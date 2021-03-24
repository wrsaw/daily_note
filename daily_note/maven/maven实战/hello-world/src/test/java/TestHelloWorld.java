import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHelloWorld {
	@Test
	public void testSayHello() {
		HelloWorld helloworld = new HelloWorld();
		String result = helloworld.sayHello();
		assertEquals("Hello", result);
	}
}