package taxproblem;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import taxproblem.Goods;
import taxproblem.Item;
import taxproblem.Taxes;

public class TaxesTest {

	@Test
	public void testRoundup() {
		
		Item item1 = new Item(BigDecimal.ONE, 1, Goods.CD);
		assertEquals(new BigDecimal("0.10"), Taxes.basicSalesTax().apply(item1));
		
		Item item01 = new Item(new BigDecimal("0.10"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.05"), Taxes.basicSalesTax().apply(item01));
		Item item02 = new Item(new BigDecimal("0.20"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.05"), Taxes.basicSalesTax().apply(item02));
		Item item03 = new Item(new BigDecimal("0.30"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.05"), Taxes.basicSalesTax().apply(item03));
		Item item04 = new Item(new BigDecimal("0.40"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.05"), Taxes.basicSalesTax().apply(item04));
		Item item05 = new Item(new BigDecimal("0.50"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.05"), Taxes.basicSalesTax().apply(item05));
		Item item06 = new Item(new BigDecimal("0.60"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.10"), Taxes.basicSalesTax().apply(item06));
		Item item07 = new Item(new BigDecimal("0.70"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.10"), Taxes.basicSalesTax().apply(item07));
		Item item08 = new Item(new BigDecimal("0.80"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.10"), Taxes.basicSalesTax().apply(item08));
		Item item09 = new Item(new BigDecimal("0.90"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.10"), Taxes.basicSalesTax().apply(item09));
		
		Item item10 = new Item(new BigDecimal("1.41"), 1, Goods.CD);
		assertEquals(new BigDecimal("0.15"), Taxes.basicSalesTax().apply(item10));
		
		Item item23 = new Item(new BigDecimal("231.56"), 1, Goods.CD);
		assertEquals(new BigDecimal("23.20"), Taxes.basicSalesTax().apply(item23));
	}

	@Test
	public  void testBasicSalesTax(){
		Item item1 = new Item(BigDecimal.ONE, 1, Goods.CD);
		assertEquals(new BigDecimal("0.10"), Taxes.basicSalesTax().apply(item1));
		
		Item itemfood = new Item(BigDecimal.ONE, 1, Goods.CHOCOLATE);
		assertEquals(new BigDecimal("0.00"), Taxes.basicSalesTax().apply(itemfood));
		
		Item itembook = new Item(BigDecimal.ONE, 1, Goods.BOOK);
		assertEquals(new BigDecimal("0.00"), Taxes.basicSalesTax().apply(itembook));
		
		Item itempill = new Item(BigDecimal.ONE, 1, Goods.PILL);
		assertEquals(new BigDecimal("0.00"), Taxes.basicSalesTax().apply(itempill));
		
		Item itemimportedfood = new Item(BigDecimal.ONE, 1, Goods.IMPORTED_CHOCOLATE);
		assertEquals(new BigDecimal("0.00"), Taxes.basicSalesTax().apply(itemimportedfood));
		
		Item itemimportedperfume = new Item(BigDecimal.ONE, 1, Goods.IMPORTED_PERFUME);
		assertEquals(new BigDecimal("0.10"), Taxes.basicSalesTax().apply(itemimportedperfume));
		
		Item itemperfume = new Item(BigDecimal.ONE, 1, Goods.PERFUME);
		assertEquals(new BigDecimal("0.10"), Taxes.basicSalesTax().apply(itemperfume));
	}
	
	@Test
	public void testImportTax() {
		
		Item item1 = new Item(BigDecimal.ONE, 1, Goods.CD);
		assertEquals(new BigDecimal("0.00"), Taxes.importTax().apply(item1));
		
		Item itemfood = new Item(BigDecimal.ONE, 1, Goods.CHOCOLATE);
		assertEquals(new BigDecimal("0.00"), Taxes.importTax().apply(itemfood));
		
		Item itembook = new Item(BigDecimal.ONE, 1, Goods.BOOK);
		assertEquals(new BigDecimal("0.00"), Taxes.importTax().apply(itembook));
		
		Item itempill = new Item(BigDecimal.ONE, 1, Goods.PILL);
		assertEquals(new BigDecimal("0.00"), Taxes.importTax().apply(itempill));
		
		Item itemimportedfood = new Item(BigDecimal.ONE, 1, Goods.IMPORTED_CHOCOLATE);
		assertEquals(new BigDecimal("0.05"), Taxes.importTax().apply(itemimportedfood));
		
		Item itemimportedperfume = new Item(BigDecimal.ONE, 1, Goods.IMPORTED_PERFUME);
		assertEquals(new BigDecimal("0.05"), Taxes.importTax().apply(itemimportedperfume));
		
		Item itemperfume = new Item(BigDecimal.ONE, 1, Goods.PERFUME);
		assertEquals(new BigDecimal("0.00"), Taxes.importTax().apply(itemperfume));
	}

}
