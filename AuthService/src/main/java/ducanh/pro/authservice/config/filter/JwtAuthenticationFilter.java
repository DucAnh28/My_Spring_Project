//package ducanh.pro.authservice.config.filter;
//
//
//import ducanh.pro.commonconfig.service.JwtService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@AllArgsConstructor
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private JwtService jwtService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            String token = getTokenFormRequest(request);
//            if (token != null) {
//                // Lấy username từ token:
//                String username = jwtService.getUsernameFromJwtToken(token);
//                // Lấy userDetail thông qua username:
////                UserDetails userDetails = appUserService.loadUserByUsername(username);
//                // Thực hiện việc xác thực thông qua token
////                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//        } catch (Exception e) {
//            logger.error("Can NOT set Can NOT set user authentication -> Message: {}", e);
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private String getTokenFormRequest(HttpServletRequest request) {
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            return authHeader.replace("Bearer ", "");
//        } else return null;
//    }
//
//
//}
