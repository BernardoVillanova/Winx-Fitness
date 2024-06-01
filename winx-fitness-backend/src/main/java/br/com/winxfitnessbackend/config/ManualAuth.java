package br.com.winxfitnessbackend.config;

import jakarta.servlet.ServletRequest;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public abstract class ManualAuth {

    public static Map<String, List<String>> mTokens = new HashMap<>();

    public static void validaAuth(ServletRequest request) throws Exception {
        if (!ManualAuth.mTokens.containsKey(((RequestFacade) request).getHeader("token").toString())) {
            throw new Exception("Erro ao buscar usuario!");
        }
    }
}
