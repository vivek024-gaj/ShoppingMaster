/**
 * 
 */
package net.click2cloud.shopping.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.click2cloud.shopping.master.interfaces.AppSessionI;
import net.click2cloud.shopping.master.model.AppSession;

/**
 * @author Vivek Gajbhiye - Cropdata
 *
 *         07-Mar-2020
 */
public interface AppSessionRepositoty extends JpaRepository<AppSession, Integer> {

	@Query(value = "select s.STATUS=1 as STATUS,u.Name from app_session s "
			+ "inner join app_users u on u.ID = s.USER_ID where u.Email=?1 and s.JWT_TOKEN=?2", nativeQuery = true)
	public AppSessionI checkedUser(String email, String token);

}
