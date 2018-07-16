package developerpraticum.main;


import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

import developerpraticum.service.ConsoleService;
import developerpraticum.service.impl.ConsoleServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		TextIO textIO = TextIoFactory.getTextIO();
		
		String inputData = textIO.newStringInputReader().read("Input: ");
		ConsoleService service = new ConsoleServiceImpl();
		String output = service.processParams(inputData);
		textIO.getTextTerminal().println("Output: ".concat(output));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textIO.dispose();
		
	}
}
