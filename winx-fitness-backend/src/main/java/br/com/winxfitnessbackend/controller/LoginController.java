package br.com.winxfitnessbackend.controller;

import br.com.winxfitnessbackend.config.ManualAuth;
import br.com.winxfitnessbackend.dto.LoginDto;
import br.com.winxfitnessbackend.service.LoginService;
import jakarta.servlet.ServletRequest;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String token = loginService.efetuarLogin(loginDto);

        if (!token.isBlank()) {
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.badRequest().body("");
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(ServletRequest request) {
        ManualAuth.mTokens.remove(((RequestFacade) request).getHeader("token"));

        return ResponseEntity.accepted().build();
    }
}
