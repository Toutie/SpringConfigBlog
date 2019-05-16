package com;

import com.config.MvcConfig;
import com.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author wang
 */
public class EotakWebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 配置父容器
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //配置spring管理的bean

        return new Class[] {RootConfig.class};
    }

    /**
     * 配置springmvc的容器
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        //配置springmvc
        return new Class[] {MvcConfig.class};
    }

    /**
     * 配置分发器的handerlerMapping
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};

    }
}
