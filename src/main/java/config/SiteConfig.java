package config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.MultipartConfigElement;

/**
 * Created by joe on 11/2/14.
 */
@Configuration
public class SiteConfig extends WebMvcConfigurerAdapter {


    public static final String REWRITE_FILTER_NAME = "rewriteFilter";
    public static final String REWRITE_FILTER_CONF_PATH = "urlrewrite.xml";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/bower_components/**").addResourceLocations("file:./src-web/bower_components/");
//        registry.addResourceHandler("/styles/**").addResourceLocations("file:./src-web/.tmp/styles/");
          registry.addResourceHandler("/images/**").addResourceLocations("file:./src-web/app/images/");
//        registry.addResourceHandler("/scripts/**").addResourceLocations("file:./src-web/app/scripts/");
//        registry.addResourceHandler("/files/**").addResourceLocations("file:../files/");
    }

    @Bean
    public FilterRegistrationBean rewriteFilterConfig() {
        FilterRegistrationBean reg = new FilterRegistrationBean();
        reg.setName(REWRITE_FILTER_NAME);
        reg.setFilter(new UrlRewriteFilter());
        reg.addInitParameter("confPath", REWRITE_FILTER_CONF_PATH);
        reg.addInitParameter("confReloadCheckInterval", "-1");
        reg.addInitParameter("statusPath", "/redirect");
        reg.addInitParameter("statusEnabledOnHosts", "*");
        reg.addInitParameter("logLevel", "WARN");
        return reg;
    }

    @Bean
    public CommonsMultipartResolver
         commonsMultipartResolver(){
        CommonsMultipartResolver re  =  new CommonsMultipartResolver();
        re.setMaxUploadSize(1);
        re.setDefaultEncoding("utf-8");
        return  re  ;
    }

    //@Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("100MB");
        factory.setMaxRequestSize("100MB");
        return factory.createMultipartConfig();
    }
}
