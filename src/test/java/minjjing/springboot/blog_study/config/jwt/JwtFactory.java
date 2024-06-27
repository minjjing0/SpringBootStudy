package minjjing.springboot.blog_study.config.jwt;


import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Builder;
import lombok.Getter;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Getter
public class JwtFactory {
    private String subject = "test@email.com";
    private Date issuedAt = new Date();
    private Date expriation = new Date(new Date().getTime()+ Duration.ofDays(14).getSeconds());
    private Map<String, Object> claims = Collections.emptyMap();

    //빌터 패턴을 사용해 설정이 필요한 데이터만 선택 설정
    @Builder
    public JwtFactory(String subject, Date issuedAt, Date expriation,Map<String, Object> claims) {
        this.subject = subject!=null?subject:this.subject;
        this.issuedAt = issuedAt!=null?issuedAt:this.issuedAt;
        this.expriation = expriation!=null?expriation:this.expriation;
        this.claims = claims !=null? claims:this.claims;

    }

    public static JwtFactory withDefaultValues() {
        return JwtFactory.builder().build();
    }

    //jjwt 라이브러리를 사용해 JWT 토큰 생성
    public String createToken(JwtProperties jwtProperties) {
        return Jwts.builder()
                .setSubject(subject)
                .setHeaderParam(Header.TYPE,Header.JWT_TYPE)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(issuedAt)
                .setExpiration(expriation)
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,jwtProperties.getSecretKey())
                .compact();
    }
}
