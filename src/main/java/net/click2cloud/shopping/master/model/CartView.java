/**
 * 
 */
package net.click2cloud.shopping.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Admin
 *
 */
@Data
@Entity(name = "cart_view")
public class CartView {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "UserID")
	private Integer userId;
	
	@Column(name = "ProductID")
	private Integer productId;

}
