package net.click2cloud.shopping.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.click2cloud.shopping.master.dto.CartViewDTO;
import net.click2cloud.shopping.master.model.CartView;

@Repository
public interface CartViewRepository extends JpaRepository<CartView, Integer> {

	@Query(value = "SELECT pd.ProductName,pd.Price,cv.Quantity,(cv.Quantity*pd.Price) as TotalPrice FROM app.cart_view cv "
			+ "left join product_details pd on pd.ID = cv.ProductID left join app_users au on au.ID = cv.UserID "
			+ "where cv.UserID = ?1", nativeQuery = true)
	public List<CartViewDTO> getCartListByUserId(Integer userId);
	
	@Query(value = "SELECT count(*) FROM app.cart_view where UserID=?1",nativeQuery = true)
	public Integer getCartCountByUser(Integer userId);

}
