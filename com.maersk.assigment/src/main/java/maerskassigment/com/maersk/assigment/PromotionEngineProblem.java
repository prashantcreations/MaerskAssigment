package maerskassigment.com.maersk.assigment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PromotionEngineProblem {

	public static void main(String arg[]) {
		
		Map<String,Integer> ActivePromotionMap = addAtivePromotion();

		System.out.println("Please Enter Unit Price for SKU \n");
		Scanner scanner = new Scanner(System.in);
		// user will enter SKU enter
		Map<String, Integer> SKUMap = createMapOfSKU(scanner);
		System.out.println("Your Final List of SKU" + SKUMap);
		// Active promotion Map
		calculateActivePromotion(ActivePromotionMap, SKUMap);
		System.out.println("Final Active Promotion Map  " + ActivePromotionMap);

		// User will enter the demand
		System.out.println("Please enter Demand \n");
		Map<String, Integer> demandMap = demand(scanner);
		System.out.println("Demand Map:  " + demandMap);

		int finalValue = calculateTheDemand(ActivePromotionMap, SKUMap, demandMap);
		System.out.println("finalValue "+finalValue);

	}
	

	public static Map<String, Integer> addAtivePromotion() {
		Map<String,Integer> ActivePromotionMap = new LinkedHashMap<String, Integer>();
		ActivePromotionMap.put("3A", 130);
		ActivePromotionMap.put("C+D", 30);
		return ActivePromotionMap;
	}


	public static int calculateTheDemand(Map activePromotionMap, Map<String, Integer> sKUMap,
			Map<String, Integer> demandMap) 
	{
		Map<String,Integer> finalMap = new LinkedHashMap<String,Integer>();
		int A=0; 
		int B=0; 
		int C=0; 
		int D=0; 
		int demandvalue=0;
		int div=0;
		int reminder=0;
		for(int i=0 ; i < demandMap.size() ; i++) {
			
			if(i==0) {
				div = demandMap.get("A")/3;
				reminder = demandMap.get("A")%3;
				A = 130*div + reminder*sKUMap.get("A");
			}
			if(i==1) {
				int valueOfB = (int) activePromotionMap.get("2B");
				div = demandMap.get("B")/2;
				reminder = demandMap.get("B")%2;
				B = valueOfB*div + reminder*sKUMap.get("B");
			}
			if(i==2 || i==3) {
				
				int valueOfD = demandMap.get("D");
				if(valueOfD==0) {
					// here calculate only C
					C = demandMap.get("C")*sKUMap.get("C");
				}
				else {
					// here calculate C + D;
					C =0 ;
					int valueOfCAndD  = (int) activePromotionMap.get("C+D");
					int CAndDCombineValue = demandMap.get("C") + demandMap.get("D") ;
					div = CAndDCombineValue/2;
					reminder = CAndDCombineValue%2;
					D = valueOfCAndD*div ;
				}
			}
		}
		System.out.println("A= "+A);
		System.out.println("B= "+B);
		System.out.println("C= "+C);
		System.out.println("D= "+D);
		finalMap.put("A", A);
		finalMap.put("B", B);
		finalMap.put("C", C);
		finalMap.put("D", D);
		
		int finalValue = finalMap.values().stream().reduce(0,Integer::sum);
		
		return finalValue;
		
	}

	public static Map<String, Integer> demand(Scanner scanner) {

		Map<String, Integer> demandMap = new LinkedHashMap<String, Integer>();
		demandMap.put("A", 0);
		demandMap.put("B", 0);
		demandMap.put("C", 0);
		demandMap.put("D", 0);
		int value = 0;
		int count = 0;
		Scanner demandValue = new Scanner(System.in);

		while (true) {

			System.out.println("You can enter 4 values \n");
			System.out.println(" For Enter Value Press 1  \n");
			System.out.println(" For Close Demand Press 2  \n");

			int option = scanner.nextInt();
			if (count > 3) {
				demandValue.close();
				break;
			}
			count++;
			switch (option) {
			case 1:
				System.out.println("Enter The Value \n");
				value = demandValue.nextInt();
				if (count == 1) {
					demandMap.replace("A", value);
				}
				if (count == 2) {
					demandMap.replace("B", value);
				}
				if (count == 3) {
					demandMap.replace("C", value);
				}
				if (count == 4) {
					demandMap.replace("D", value);
				}
				break;

			case 2:
				System.out.println("in case 2 \n");
				demandValue.close();
				return demandMap;
			default:
				// demandValue.close();
				// scanner.close();
				break;
			}
		}
		System.out.println("Final Demand : " + demandMap);
		return demandMap;
	}

	public static void calculateActivePromotion(Map<String, Integer> ActivePromotionMap, Map<String, Integer> SKUMap) {
		int sumofAllSKUValues = SKUMap.values().stream().reduce(0, Integer::sum);
		System.out.println("sumofAllSKUValues = " + sumofAllSKUValues);
		// int activePromotionValuesSum =
		// ActivePromotionMap.values().stream().reduce(0,Integer::sum);
		// System.out.println("activePromotionValuesSum ="+activePromotionValuesSum);
		int BValue = 160 - sumofAllSKUValues;
		ActivePromotionMap.put("2B", BValue);
	}

	public static Map<String, Integer> createMapOfSKU(Scanner scanner) {
		System.out.println("Please Enter Unit Price for A \n");
		int A = scanner.nextInt();
		System.out.println("Please Enter Unit Price for B \n");
		int B = scanner.nextInt();
		System.out.println("Please Enter Unit Price for C \n");
		int C = scanner.nextInt();
		System.out.println("Please Enter Unit Price for D \n");
		int D = scanner.nextInt();
		Map unitPriceSKUMap = new LinkedHashMap<String, Integer>();
		unitPriceSKUMap.put("A", A);
		unitPriceSKUMap.put("B", B);
		unitPriceSKUMap.put("C", C);
		unitPriceSKUMap.put("D", D);
		// scanner.close();

		return unitPriceSKUMap;
	}
}
