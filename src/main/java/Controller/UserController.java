package Controller;

import Configuration.TokenProvider;
import Model.AuthToken;
import Model.LoginDataHolder;
import Model.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginDataHolder loginDataHolder) throws AuthenticationException {
        // validate username and password
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDataHolder.getUsername(),
                        loginDataHolder.getPassword()
                )
        );
        // if validation result in success, set the authentication object to context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // generate a jwt token from authentication object
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }
}
