package byorn.production.businesslogic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import byorn.product.entities.Product;
import byorn.production.dao.ProductDAO;


/**
 * This Service is Session Scoped.
 * @author byorn
 *
 */
public class ShoppingCartService {
	
	private Map<Integer,Product> myCart = new HashMap<Integer, Product>();
	
	
	public void addToCart(Integer productId){
		
		ProductDAO productDAO = new ProductDAO();
		
		Product product = productDAO.getProductFromDataBase(productId);
		
		myCart.put(product.getId(), product);
	}
	
	public BigDecimal getCartTotal(){
		
		BigDecimal total = new BigDecimal(0.00);
		
		for(Integer cartItemId:myCart.keySet()){
			Product product = myCart.get(cartItemId);
			total.add(product.getProductPrice());
		}
		
		return total;
	}

}
