package minjjing.springboot.blog_study.service;

import lombok.RequiredArgsConstructor;

import minjjing.springboot.blog_study.domain.RefreshToken;
import minjjing.springboot.blog_study.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}