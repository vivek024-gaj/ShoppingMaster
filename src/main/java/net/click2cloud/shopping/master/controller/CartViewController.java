/**
 * 
 */
package net.click2cloud.shopping.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.click2cloud.shopping.master.dto.CartViewDTO;
import net.click2cloud.shopping.master.model.CartView;
import net.click2cloud.shopping.master.response.ResponseMessage;
import net.click2cloud.shopping.master.service.impl.CartViewService;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartViewController {

	@Autowired
	CartViewService cartViewService;

	@GetMapping("/view/{userId}")
	public List<CartViewDTO> getCartByUserId(@PathVariable Integer userId) {
		return this.cartViewService.getCartByUserId(userId);
	}
	
	@GetMapping("/count/{userId}")
	public Integer getCartCountUserId(@PathVariable Integer userId) {
		return this.cartViewService.getCartCount(userId);
	}
	
	@PostMapping("/add")
	public ResponseMessage addToCart(@RequestBody CartView cartView) {
		return this.cartViewService.addCart(cartView);
	}

}
