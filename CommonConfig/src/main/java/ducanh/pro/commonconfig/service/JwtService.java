package ducanh.pro.commonconfig.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value(value = "${spring.jwt.key}")
    private final String KEY_UNLOCK_TOKEN;
    private static final long EXPIRE_TIME = 69600000000L;

    public String createToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + EXPIRE_TIME * 1000))
                .signWith(SignatureAlgorithm.HS512, KEY_UNLOCK_TOKEN)
                .compact();
    }

    // Lấy tên user từ token:
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(KEY_UNLOCK_TOKEN)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
