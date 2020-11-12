package net.click2cloud.shopping.master.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * @author admin
 *
 */
@Data
public class MediaDTO {
	
	private MultipartFile file;
	private String productDetails;
	

}