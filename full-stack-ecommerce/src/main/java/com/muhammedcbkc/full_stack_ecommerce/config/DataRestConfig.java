package com.muhammedcbkc.full_stack_ecommerce.config;


import com.muhammedcbkc.full_stack_ecommerce.entities.Product;
import com.muhammedcbkc.full_stack_ecommerce.entities.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    // Bu kofigürasyon sınıfı bazı methodların disable etmeye yarar.
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        //Disabled Method
        HttpMethod[] theUnsupportActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE };

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportActions)));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportActions)));

        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

    }
}
