package com.EmployeeManagementRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userRepository.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("User not found");
			
		}
		return new User(user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));
	}
	
	private List<GrantedAuthority> getAuthorities(List<Role> roles){
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(Role role: roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			
		}
		return authorize;
	}
	
}
