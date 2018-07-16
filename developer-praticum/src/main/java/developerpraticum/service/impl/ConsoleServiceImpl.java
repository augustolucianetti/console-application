package developerpraticum.service.impl;

import java.util.Arrays;
import java.util.List;

import org.beryx.textio.TextIO;

import developerpraticum.service.ConsoleService;

public class ConsoleServiceImpl implements ConsoleService {

	@Override
	public String processParams(String param) {

		if (param.contains(",")) {

			if (param.startsWith("night") || param.startsWith("morning")) {
				String[] params = param.split(",");
				List<String> listParams = Arrays.asList(params);

				String output = "";
				int countEntree = 0;
				int countSide = 0;
				int countDrink = 0;
				int countDesert = 0;
				for (String parameter : listParams) {
					
					switch (parameter.trim()) {
					case "1":
						countEntree++;
						break;
					case "2":
						countSide++;
						break;
					case "3":
						countDrink++;
						break;
					case "4":
						countDesert++;

					default:
						break;
					}
				}
				
				if (param.startsWith("morning")) {

					if (countEntree > 1) {
						return "Invalid Selection! At morning can not be more than one entrée.";
					} else if (countEntree == 1){
						output = output.concat("eggs");
					}

					if (countSide > 1) {
						return "Invalid Selection! At morning can not be more than one side.";
					} else if (countSide == 1){
						output = output.concat(", toast");
					}

					if (countDrink > 1) {
						output = output.concat(", coffee(x"+ countDrink +")");
					} else if (countDrink == 1){
						output = output.concat(", coffee");
					}

					if (countDesert != 0) {
						output = output.concat(", error");
					}
				} else {

					if (countEntree > 1) {
						return "Invalid Selection! At night can not be more than one entrée.";
					} else if (countEntree == 1){
						output = output.concat("steak");
					}

					if (countSide > 1) {
						output = output.concat(", potato(x"+ countSide +")");
					} else if (countSide == 1){
						output = output.concat(", potato");
					}

					if (countDrink > 1) {
						
						return "Invalid Selection! At night can not be more than one drink.";
					} else if (countDrink == 1){
						output = output.concat(", wine");
					}

					if (countDesert > 1) {
						return "Invalid Selection! At night can not be more than one dessert.";
					} else if (countDesert == 1){
						output = output.concat(", cake");
					}
				}
				return output;
			} else {
				return "Invalid selection! Must initialize with \"morning\" or \"night\" all with lowerCase.";
			}

		} else {
			return "Invalid selection! Must be a list of parms separated with comma";
		}
	}

}
