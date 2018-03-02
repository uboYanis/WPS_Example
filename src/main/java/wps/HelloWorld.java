package wps;

import org.geoserver.wps.gs.GeoServerProcess;
import org.geotools.process.factory.DescribeParameter;
import org.geotools.process.factory.DescribeProcess;
import org.geotools.process.factory.DescribeResult;
import org.geotools.process.factory.StaticMethodsProcessFactory;
import org.geotools.text.Text;

public class HelloWorld extends StaticMethodsProcessFactory<HelloWorld> implements GeoServerProcess {

	public HelloWorld() {
		super(Text.text("WPS hello world "), "testWPS", HelloWorld.class);
	}

	@DescribeProcess(title = "WPS HelloWorld", description = "WPS Hello World")
	@DescribeResult(name = "helloMessage", description = "the resulting hello message")
	public static String sayHello(
			@DescribeParameter(name = "name", description = "The name to use in the result") final String name) {

		return ("Hello " + name);

	}

	@DescribeProcess(title = "WPS multiplication", description = "WPS Multiplication")
	@DescribeResult(name = "helloMessage", description = "the resulting hello message")
	public static int mulitplication(
			@DescribeParameter(name = "number 1", description = "The first number") final int number1,
			@DescribeParameter(name = "number 2", description = "The second number") final int number2) {

		return number1 * number2;
	}
}