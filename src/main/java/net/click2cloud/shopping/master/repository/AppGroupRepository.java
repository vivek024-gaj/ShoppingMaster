/**
 * 
 */
package net.click2cloud.shopping.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.click2cloud.shopping.master.model.AppGroup;

/**
 * @author Vivek Gajbhiye - Cropdata
 *
 * 03-Feb-2020
 */
@Repository
public interface AppGroupRepository extends JpaRepository<AppGroup, Integer>{

}
