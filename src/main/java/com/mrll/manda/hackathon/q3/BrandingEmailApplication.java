package com.mrll.manda.hackathon.q3;

import com.mrll.javelin.common.event.EnableJavelinCommonEvent;
import com.mrll.javelin.common.security.EnableJavelinCommonSecurity;
import com.mrll.javelin.common.web.EnableJavelinCommonWeb;
import com.mrll.javelin.common.web.logging.LogHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJavelinCommonWeb
@EnableJavelinCommonSecurity
@EnableJavelinCommonEvent
public class BrandingEmailApplication {

    public static void main(String[] args) {
        LogHelper.setMdcForAppStartup();
        SpringApplication.run(BrandingEmailApplication.class, args);
    }

}
