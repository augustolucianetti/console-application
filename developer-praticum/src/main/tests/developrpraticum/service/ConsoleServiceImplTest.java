package developrpraticum.service;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.junit.Assert;
import org.junit.Test;

import developerpraticum.service.ConsoleService;
import developerpraticum.service.impl.ConsoleServiceImpl;


public class ConsoleServiceImplTest {

	@Test
	public void processParamsTest() {


		String inputData = "morning, 1, 2, 3";
		ConsoleService service = new ConsoleServiceImpl();
		String output = service.processParams(inputData);

		Assert.assertTrue(output.equals("eggs, toast, coffee"));

		inputData = "morning, 2, 1, 3";
		output = service.processParams(inputData);
		Assert.assertTrue(output.equals("eggs, toast, coffee"));

		inputData = "morning, 1, 2, 3, 4";
		output = service.processParams(inputData);
		Assert.assertTrue(output.equals("eggs, toast, coffee, error"));

		inputData = "morning, 1, 2, 3, 3, 3";
		output = service.processParams(inputData);
		Assert.assertTrue(output.equals("eggs, toast, coffee(x3)"));

		inputData = "night, 1, 2, 3, 4";
		output = service.processParams(inputData);
		Assert.assertTrue(output.equals("steak, potato, wine, cake"));

		inputData = "night, 1, 2, 2, 4";
		output = service.processParams(inputData);
		Assert.assertTrue(output.equals("steak, potato(x2), cake"));

	}
}
