//package pl.january.jbrowski.storeeverything.Configuration;
//
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import pl.january.jbrowski.storeeverything.Model.Client;
//import pl.january.jbrowski.storeeverything.Repositories.ClientRepository;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//@NoArgsConstructor
//@AllArgsConstructor
//public class MyUserDetailService implements UserDetailsService {
//    @Autowired
//    private ClientRepository clientRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Client client = clientRepository.findByLogin(username).stream().findFirst().get();
//        if(client==null){
//            throw new UsernameNotFoundException(username);
//        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("USR"));
//        return new User(username, client.getPassword(), authorities);
//    }
//}
