package byorn.test.businesslogic;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import byorn.product.entities.Product;
import byorn.production.businesslogic.ShoppingCartService;
import byorn.production.dao.ProductDAO;
import static org.mockito.Matchers.*;

@RunWith(PowerMockRunner.class)
public class ShoppingCartServiceTest {

	@PrepareForTest(ShoppingCartService.class)
	@Test
	public void test_addToCart() throws Exception {

		// This is the class under test;  The method under test is right below which I call in the end.
		ShoppingCartService testShoppingCartService = new ShoppingCartService();

		// The ProductDAO is tightly coupled with a Database and probably coupled with JEE6 Entity Manager or Spring Framework
		// There for I am going to Mock this dependency.
		ProductDAO productDAO = PowerMockito.mock(ProductDAO.class);

		//This is a Stub class that I am creating. 
		Product product = new Product();
		product.setId(1);
		product.setProductPrice(new BigDecimal(23));

		
		//Here am setting the behaviour and expectations of the mock classes.
		PowerMockito.whenNew(ProductDAO.class).withNoArguments()
				.thenReturn(productDAO);

		PowerMockito.when(productDAO.getProductFromDataBase(anyInt()))
				.thenReturn(product);

		testShoppingCartService.addToCart(1);


		Assert.assertTrue(23==testShoppingCartService.getCartTotal().intValue());

	}

}
