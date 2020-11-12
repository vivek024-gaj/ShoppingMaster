/**
 * 
 */
package net.click2cloud.shopping.master.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.click2cloud.shopping.master.dto.MediaDTO;
import net.click2cloud.shopping.master.model.ProductDetails;
import net.click2cloud.shopping.master.response.ResponseMessage;
import net.click2cloud.shopping.master.service.impl.ProductDetailsService;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/product")
public class ProductDetailsController {
	
	
	@Autowired
	ProductDetailsService productDetailsService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@GetMapping("/list")
	public List<ProductDetails> getAllProductDetails(){
		return this.productDetailsService.getAllProductDetails();
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseMessage addNewProduct(@ModelAttribute MediaDTO mediaDTO)
			throws IOException {

		ProductDetails productDetails = objectMapper.readValue(mediaDTO.getProductDetails(), ProductDetails.class);

		System.out.println(mediaDTO.getFile().getOriginalFilename());

		String fileName = StringUtils.cleanPath(mediaDTO.getFile().getOriginalFilename());

		if (!(fileName == null) || fileName.contains("..")) {
			byte[] photoBytes = mediaDTO.getFile().getBytes();
			productDetails.setImg(photoBytes);

		}
		return this.productDetailsService.addNewProductDetails(productDetails);
	}

}
