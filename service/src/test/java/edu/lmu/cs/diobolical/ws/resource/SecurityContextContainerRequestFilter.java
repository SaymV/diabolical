package edu.lmu.cs.diobolical.ws.resource;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import org.apache.http.auth.BasicUserPrincipal;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

/**
 * A test-only container request filter for inserting a test security context into
 * a request.
 */
public class SecurityContextContainerRequestFilter implements ContainerRequestFilter {

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        request.setSecurityContext(new SecurityContext() {

            @Override
            public Principal getUserPrincipal() {
                return new BasicUserPrincipal("testuser");
            }

            @Override
            public boolean isUserInRole(String role) {
                // This user has every role.
                return true;
            }

            @Override
            public boolean isSecure() {
                return true;
            }

            @Override
            public String getAuthenticationScheme() {
                // Doesn't matter for this test.
                return null;
            }
            
        });

        return request;
    }

}
