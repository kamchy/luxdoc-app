package pl.chyla.luxdoc.infrastructure.sec;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.chyla.luxdoc.application.sec.CurrentUserProvider;

import java.util.Collection;

/**
 * Created by Luxoft on 4/27/2016.
 */
@Component
public class SpringCurrentUserProviderImpl implements CurrentUserProvider {

    @Override

    public void ensureRole(String roleName) {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if (!authorities.stream().filter(a -> a.getAuthority().equalsIgnoreCase(roleName)).findFirst().isPresent()){
            throw new RuntimeException("Does not have a role " + roleName);
        };
    }
}
