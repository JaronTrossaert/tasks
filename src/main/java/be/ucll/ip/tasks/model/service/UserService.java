package be.ucll.ip.tasks.model.service;

import be.ucll.ip.tasks.model.dto.CreateUserDTO;
import be.ucll.ip.tasks.model.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDTO createUser(CreateUserDTO createUserDTO);
}
