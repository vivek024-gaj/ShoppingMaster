/**
 * 
 */
package net.click2cloud.shopping.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

/**
 * @author Admin
 *
 */
@Data
@Entity(name = "product_details")
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "ProductName")
	private String productName;

	@Column(name = "ProductDescription")
	private String productDescription;

	@Column(name = "Price")
	private Integer price;
	
	@Lob
	@Column(name = "Image")
	private byte[] img;

	@Column(name = "Status")
	private String status;
}
