package byorn.production.dao;

import byorn.product.entities.Product;

public class ProductDAO {

	private static boolean isInitialized;
	
	
		
	public Product getProductFromDataBase(Integer productId){
		
		//this bit of code will actually be from the persistence framework like hibernate
		Product product = new Product();
			
		
		return product;
	}
}

