package maerskassigment.com.maersk.assigment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class MaerskTest {

	Map<String,Integer> activePromotion = new LinkedHashMap<String, Integer>();
	Map<String,Integer> SKUList = new LinkedHashMap<String, Integer>();
	Map<String, Integer> demandMap = new LinkedHashMap<String, Integer>();
	@Mock
	PromotionEngineProblem testObj;
	
	
	@BeforeEach
	public void initSetup() {
		Scanner sc = new Scanner(System.in);
		
//		 activePromotion = PromotionEngineProblem.addAtivePromotion();
		 activePromotion.put("3A", 130);
		 activePromotion.put("C+D", 30);
		 System.out.println("Active Promotion Init List :- "+activePromotion);
		 
		 SKUList.put("A",50);
		 SKUList.put("B",30);
		 SKUList.put("C",20);
		 SKUList.put("D",15);
//		 System.out.println("Please SKU List ");
//		 SKUList = PromotionEngineProblem.createMapOfSKU(sc);
		 System.out.println("SKUList :- "+activePromotion);
		 
//		 System.out.println("Enter Demand ");
		 demandMap.put("A",3);
		 demandMap.put("B",5);
		 demandMap.put("C",1);
		 demandMap.put("D",1);
//		 demandMap = PromotionEngineProblem.demand(sc);
		 System.out.println("Demad List ");
		 
		 PromotionEngineProblem.calculateActivePromotion(activePromotion,SKUList);
		 System.out.println("Final Active Promotion List :- "+activePromotion);
		 
	}
	
	@Test
	public void testcalculateTheDemand(){
		int expected = 280;
		//when(PromotionEngineProblem.calculateTheDemand(activePromotion, SKUList, demandMap)).thenReturn(expected);
		int actual = PromotionEngineProblem.calculateTheDemand(activePromotion, SKUList, demandMap);
		assertEquals(expected,actual);
	}
	

}
