/**
 * 
 */
package net.click2cloud.shopping.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.click2cloud.shopping.master.model.AppResourceGroup;

/**
 * @author Vivek Gajbhiye - Cropdata
 *
 * 03-Feb-2020
 */
@Repository
public interface AppResourceGroupRepository extends JpaRepository<AppResourceGroup, Integer>{
	

}
