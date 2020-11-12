/**
 * 
 */
package net.click2cloud.shopping.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.click2cloud.shopping.master.model.ProductDetails;
import net.click2cloud.shopping.master.repository.ProductDetailsRepository;
import net.click2cloud.shopping.master.response.ResponseMessage;
import net.click2cloud.shopping.master.utils.ResponseMessageUtil;

/**
 * @author Admin
 *
 */
@Service
public class ProductDetailsService {
	
	@Autowired
	ProductDetailsRepository productDetailsRepository;
	
	
	@Autowired
	ResponseMessageUtil responseMessageUtil;
	
	public List<ProductDetails> getAllProductDetails(){
		return this.productDetailsRepository.findAll();
	}
	
	public ResponseMessage addProductDetails(ProductDetails productDetails) {
		ProductDetails saveProductdetails = this.productDetailsRepository.save(productDetails);
		if(saveProductdetails!=null) {
			return this.responseMessageUtil.sendResponse(true, "Product Added", "");
		}else {
			return this.responseMessageUtil.sendResponse(false, "", "Something went wrong");
		}
	}
	
	public ResponseMessage addNewProductDetails(ProductDetails productDetails){
		ProductDetails saveProductDetails = this.productDetailsRepository.save(productDetails);
		if(saveProductDetails!=null){
			return this.responseMessageUtil.sendResponse(true, "Product Added", "");
		}else{
			return this.responseMessageUtil.sendResponse(false, "", "something wrong");
		}
	}
}
