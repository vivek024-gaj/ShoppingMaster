/**
 * 
 */
package net.click2cloud.shopping.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.click2cloud.shopping.master.dto.CartViewDTO;
import net.click2cloud.shopping.master.model.CartView;
import net.click2cloud.shopping.master.repository.CartViewRepository;
import net.click2cloud.shopping.master.response.ResponseMessage;
import net.click2cloud.shopping.master.utils.ResponseMessageUtil;

/**
 * @author Admin
 *
 */
@Service
public class CartViewService {

	@Autowired
	CartViewRepository cartViewRepository;

	@Autowired
	ResponseMessageUtil responseMessageUtil;

	public ResponseMessage addCart(CartView cartView) {
//		CartView cartView = new CartView();
//		cartView.setUserId(userId);
//		cartView.setProductId(productId);
		CartView saveCartView = this.cartViewRepository.save(cartView);
		if (saveCartView != null) {
			return responseMessageUtil.sendResponse(true, "Added To Cart", "");
		} else {
			return responseMessageUtil.sendResponse(false, "", "Something wrong");
		}

	}

	public List<CartViewDTO> getCartByUserId(Integer userId) {
		return this.cartViewRepository.getCartListByUserId(userId);
	}

	public Integer getCartCount(Integer userId) {
		return this.cartViewRepository.getCartCountByUser(userId);

	}

}
