package com.mjl.water_electricity_manager;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.mjl.water_electricity_manager.ui.LoginFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableTransactionManagement
public class WaterElectricityManagerApplication {

    @PostConstruct
    public void init() {
        FlatSolarizedLightIJTheme.setup();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(WaterElectricityManagerApplication.class).headless(false).run(args);
        LoginFrame bean = ctx.getBean(LoginFrame.class);
        bean.setVisible(true);
    }

}
