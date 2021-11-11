package kr.co.ggabi.springboot.controller;

import kr.co.ggabi.springboot.dto.LoginDto;
import kr.co.ggabi.springboot.dto.MembersSaveRequestDto;
import kr.co.ggabi.springboot.dto.StatusDto;
import kr.co.ggabi.springboot.dto.TokenDto;
import kr.co.ggabi.springboot.jwt.JwtFilter;
import kr.co.ggabi.springboot.jwt.TokenProvider;
import kr.co.ggabi.springboot.service.CreateMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final CreateMemberService createMemberService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/signup")
    public Long save(@RequestBody MembersSaveRequestDto requestDto) throws IOException {
        return createMemberService.save(requestDto);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        return new ResponseEntity<>(tokenDto, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/status")
    public Map<String, String> status(HttpServletRequest httpServletRequest, StatusDto statusDto){
        String token = tokenProvider.resolveToken(httpServletRequest);
        Map<String, String> res = new HashMap<>();
        res.put("username", tokenProvider.getUsernameFromToken(token));
        res.put("auth", tokenProvider.getAuthFromToken(token));
        return res;
    }
}