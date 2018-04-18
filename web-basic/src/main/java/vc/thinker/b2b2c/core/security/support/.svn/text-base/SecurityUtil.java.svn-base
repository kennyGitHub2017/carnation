package vc.thinker.b2b2c.core.security.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.sinco.carnation.sys.model.Role;
import com.sinco.common.utils.StringUtils;

public class SecurityUtil {

	public static Collection<GrantedAuthority> get_all_Authorities(List<Role> roles) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles.size());
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
		}
		return grantedAuthorities;// .toArray(new GrantedAuthority[roles.size()]);
	}

	public static Collection<GrantedAuthority> get_common_Authorities(List<Role> roles) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles.size());
		for (Role role : roles) {
			if (!role.getType().equals("ADMIN"))
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
		}
		return grantedAuthorities;
		// .toArray(new GrantedAuthority[grantedAuthorities.size()]);
	}

	public static String getAuthoritiesString(Collection<GrantedAuthority> gas) {
		List<String> authorities = new ArrayList<String>();
		for (GrantedAuthority authority : gas) {
			authorities.add(authority.getAuthority());
		}
		return StringUtils.join(authorities.toArray(), ",");
	}

}
