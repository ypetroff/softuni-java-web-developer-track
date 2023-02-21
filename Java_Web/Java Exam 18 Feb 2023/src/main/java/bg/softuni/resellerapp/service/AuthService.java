package bg.softuni.resellerapp.service;

import bg.softuni.resellerapp.model.binding.UserLoginModel;
import bg.softuni.resellerapp.model.binding.UserRegisterModel;
import bg.softuni.resellerapp.model.entity.User;
import bg.softuni.resellerapp.repository.UserRepository;
import bg.softuni.resellerapp.util.LoggedUser;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession session;

    public AuthService(UserRepository userRepository, ModelMapper modelMapper,
                       LoggedUser loggedUser, PasswordEncoder passwordEncoder, HttpSession session) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
        this.session = session;
    }

    public void registerUser(UserRegisterModel user) {

        User userEntity = this.modelMapper.map(user, User.class);

        userEntity.setPassword(this.passwordEncoder.encode(user.getPassword()));

        this.userRepository.saveAndFlush(userEntity);
    }


    public void loginUser(UserLoginModel userLoginModel) {

        User user = this.userRepository.findByUsername(userLoginModel.getUsername()).get();

        this.loggedUser.setId(user.getId());
        //TODO: check if you need to store the username
        this.loggedUser.setUsername(user.getUsername());
    }

    public void logoutUser() {
        this.session.invalidate();
        this.loggedUser.clearUser();
    }

    public boolean checkCredentials(String username, String password) {

        User user = this.userRepository.findByUsername(username).orElse(null);

        if (user == null) {
            return false;
        }

        return passwordEncoder.matches(password, user.getPassword());
    }
}
