package com.mrll.manda.hackathon.q3;

import com.mrll.javelin.common.event.EnableJavelinCommonEvent;
import com.mrll.javelin.common.security.EnableJavelinCommonSecurity;
import com.mrll.javelin.common.security.jwt.JwtConverter;
import com.mrll.javelin.common.security.service.JavelinJwtService;
import com.mrll.javelin.common.security.service.JavelinJwtServiceImpl;
import com.mrll.javelin.common.security.service.TokenServiceDelegate;
import com.mrll.javelin.common.security.service.TokenServiceDelegateImpl;
import com.mrll.javelin.common.security.util.SecurityHelper;
import com.mrll.javelin.common.security.util.ServiceJwtHelper;
import com.mrll.javelin.common.web.EnableJavelinCommonWeb;
import com.mrll.javelin.common.web.logging.LogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJavelinCommonWeb
@EnableJavelinCommonSecurity
@EnableAspectJAutoProxy
public class BrandingEmailApplication {

    @Autowired
    @Qualifier("javelinRestTemplate")
    private RestTemplate javelinRestTemplate;

    @Value("${javelin.security.tokens.service.id}")
    private String serviceId;

    @Value("${javelin.security.tokens.service.id}")
    private String servicePassword;

    @Autowired
    private JwtConverter jwtConverter;

    @Autowired
    private SecurityHelper securityHelper;

    /*@Autowired
    private ServiceJwtHelper serviceJwtHelper;*/

    public static void main(String[] args) {
        LogHelper.setMdcForAppStartup();
        SpringApplication.run(BrandingEmailApplication.class, args);
    }

    @Bean
    public TokenServiceDelegate tokenServiceDelegate() {
        return new TokenServiceDelegateImpl(javelinRestTemplate, 24);
    }
    /*@Bean
    public ServiceJwtHelper serviceJwtHelper(){
        return new ServiceJwtHelper();
    }*/
    @Bean
    public JavelinJwtService javelinJwtService(RestTemplate restTemplate, ServiceJwtHelper serviceJwtHelper) {
        return new JavelinJwtServiceImpl(serviceId, servicePassword, serviceJwtHelper, jwtConverter, securityHelper, tokenServiceDelegate());
    }

}
