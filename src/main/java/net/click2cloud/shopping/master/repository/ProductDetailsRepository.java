/**
 * 
 */
package net.click2cloud.shopping.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.click2cloud.shopping.master.model.ProductDetails;

/**
 * @author Admin
 *
 */
@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{

}
