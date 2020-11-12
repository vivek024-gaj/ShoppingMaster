/**
 * 
 */
package net.click2cloud.shopping.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.click2cloud.shopping.master.constant.SqlQueries;
import net.click2cloud.shopping.master.interfaces.Menu;
import net.click2cloud.shopping.master.interfaces.User;
import net.click2cloud.shopping.master.model.AppUser;

/**
 * @author Vivek Gajbhiye - Cropdata
 *
 *         03-Feb-2020
 */
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	@Query(value = SqlQueries.GET_USER_BY_EMAIL_ID, nativeQuery = true)
	User getUserByEmailId(String email);

	@Query(value = SqlQueries.GET_ALL_USERS_LIST, nativeQuery = true)
	List<User> getAllUserData();

	@Query(value = SqlQueries.GET_USER_BY_ID, nativeQuery = true)
	User getUserById(int id);

	@Query(value = SqlQueries.GET_MENUS_BY_ROLE_ID, nativeQuery = true)
	List<Menu> getMenusByRole(int roleID);

}
