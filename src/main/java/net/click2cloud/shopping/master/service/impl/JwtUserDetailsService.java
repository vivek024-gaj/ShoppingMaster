package net.click2cloud.shopping.master.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.click2cloud.shopping.master.dto.NavData;
import net.click2cloud.shopping.master.exception.InactiveUserException;
import net.click2cloud.shopping.master.interfaces.Menu;
import net.click2cloud.shopping.master.model.AppRestriction;
import net.click2cloud.shopping.master.model.AppUser;
import net.click2cloud.shopping.master.model.CustomUserDetails;
import net.click2cloud.shopping.master.repository.AppUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	AppUserRepository appUserRepository;

	@Autowired
	AppService appService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		net.click2cloud.shopping.master.interfaces.User foundAppUser = appUserRepository.getUserByEmailId(username.trim());
		AppUser appUser = null;
		if (foundAppUser != null) {
			appUser = new AppUser();
			appUser.setId(foundAppUser.getId());
			appUser.setRoleId(foundAppUser.getRoleId());
			appUser.setName(foundAppUser.getName());
			appUser.setRole(foundAppUser.getRole());
			appUser.setEmail(foundAppUser.getEmail());
			appUser.setPassword(foundAppUser.getPassword());
			appUser.setStatus(foundAppUser.getStatus());
			appUser.setCreatedAt(foundAppUser.getCreatedAt());
			appUser.setUpdatedAt(foundAppUser.getUpdatedAt());

			if (!appUser.getStatus().equals("Active")) {
				throw new InactiveUserException("User '" + username + "' is not active.");
			}

			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//	    System.err.println("Role: "+aclUser.getRole());
			grantedAuthorities.add(new SimpleGrantedAuthority(appUser.getRole()));

			User user = new User(appUser.getEmail(), appUser.getPassword(), grantedAuthorities);

			List<Menu> menuList = appUserRepository.getMenusByRole(foundAppUser.getRoleId());

			Map<String, NavData> navMap = new HashMap<String, NavData>();
			for (Menu menu : menuList) {
				String group = menu.getResourceGroupName();
				String icon = menu.getResourceIcon();
				if (navMap.get(group) == null) {
					NavData navData = new NavData();
					navData.setName(group);
					navData.setIcon(icon);
					if (menu.getResourceURL() != null && menu.getResourceURL().contains("/")) {
						String[] urls = menu.getResourceURL().split(File.separator);
						if (urls.length > 1) {
							navData.setUrl("/" + urls[1]);
						} else {
							navData.setUrl("#");
						}
					} // if menu url not null
					navMap.put(group, navData);
				} // if not exist in navMap

				NavData navData = new NavData();
				navData.setName(menu.getResourceName());
				navData.setUrl(menu.getResourceURL());
				navData.setIcon(menu.getResIcon());
				if (navMap.get(group) != null) {
					navMap.get(group).getChildren().add(navData);
				}
			} // for

//	    System.err.println(navMap.entrySet());
			return new CustomUserDetails(user, appUser, navMap);

		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

	}// loadUserByUsername

	public List<AppRestriction> getRestrictionsForRoleId(int roleId) {
		return appService.findAllByRoleId(roleId);
	}
}