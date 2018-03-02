package wps;

import java.util.HashMap;
import java.util.Map;

import org.geotools.process.factory.DescribeParameter;
import org.geotools.process.factory.DescribeProcess;
import org.geotools.process.factory.DescribeResult;
import org.geotools.process.factory.DescribeResults;
import org.geotools.process.factory.StaticMethodsProcessFactory;
import org.geotools.text.Text;

@DescribeProcess(title = "Complex WPS", description = "Complex WPS")
public class ComplexWPS extends StaticMethodsProcessFactory<ComplexWPS> {
	public ComplexWPS() {
		super(Text.text("Complex WPS"), "ComplexWPS", ComplexWPS.class);
	}

	@DescribeProcess(title = "multipleOutput", description = "WPS with multiple output")
	@DescribeResults({
			@DescribeResult(name = "multiply", description = "return the result of the multiplication between x and y", type = Double.class),
			@DescribeResult(name = "addition", description = "returns the result of adding between x and y", type = Double.class),
			@DescribeResult(name = "substraction", description = "returns the result of the subtraction between x and y", type = Double.class),
			@DescribeResult(name = "division", description = "returns the result of the division between x and y", type = Double.class) })
	public static Map<String, Object> multipleOutput(@DescribeParameter(name = "X") double x,
			@DescribeParameter(name = "Y") double y) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("substraction", new Double(x - y));
		result.put("multiply", new Double(x * y));
		result.put("addition", new Double(x + y));
		result.put("division", new Double(x / y));
		return result;
	}
}