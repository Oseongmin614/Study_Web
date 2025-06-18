package kr.ac.kopo.filter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FirebaseAuthenticationFilter implements Filter {

    @Autowired
    private FirebaseAuth firebaseAuth;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // Skip filter for login page and public resources
        String requestURI = httpRequest.getRequestURI();
        if (isPublicResource(requestURI)) {
            chain.doFilter(request, response);
            return;
        }
        
        // Check if user is already authenticated in session
        HttpSession session = httpRequest.getSession();
        if (session.getAttribute("uid") != null) {
            chain.doFilter(request, response);
            return;
        }
        
        // Get token from Authorization header
        String authorizationHeader = httpRequest.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String idToken = authorizationHeader.substring(7);
            try {
                // Verify the ID token
                FirebaseToken decodedToken = firebaseAuth.verifyIdToken(idToken);
                String uid = decodedToken.getUid();
                
                // Store user info in session
                session.setAttribute("uid", uid);
                
                chain.doFilter(request, response);
            } catch (FirebaseAuthException e) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.do");
            }
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.do");
        }
    }
    
    private boolean isPublicResource(String uri) {
        return uri.endsWith("login.do") || 
               uri.endsWith(".css") || 
               uri.endsWith(".js") || 
               uri.endsWith(".jpg") || 
               uri.endsWith(".png");
    }
}
