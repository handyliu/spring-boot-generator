package com.xuxinlong.generator.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.xuxinlong.generator.core.Result;
import com.xuxinlong.generator.core.ResultCode;
import com.xuxinlong.generator.core.ServiceException;
import com.xuxinlong.generator.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Spring MVC 配置
 *
 * @author xuxinlong
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 使用阿里 FastJson 作为JSON MessageConverter
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        //保留空的字段
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue,
                //String null -> ""
                SerializerFeature.WriteNullStringAsEmpty,
                //Number null -> 0
                SerializerFeature.WriteNullNumberAsZero);
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }


    /**
     * 统一异常处理
     *
     * @param exceptionResolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add((request, response, handler, e) -> {
            ModelAndView mav = new ModelAndView();
            Result result = new Result();
            String requestedWith = request.getHeader("X-Requested-With");
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                if ("XMLHttpRequest".equals(requestedWith)) {
                    //JSON视图
                    if (e instanceof ServiceException) {
                        //业务失败的异常，如“账号或密码错误”
                        result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
                        logger.info(e.getMessage());
                    } else if (e instanceof ServletException) {
                        result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
                    } else {
                        String message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                                request.getRequestURI(),
                                handlerMethod.getBean().getClass().getName(),
                                handlerMethod.getMethod().getName(),
                                e.getMessage());
                        result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("内部错误：" + e.getMessage());
                        logger.error(message, e);
                    }
                    JsonUtil.responseResult(response, result);
                } else {//普通视图
                    if (response.getStatus() == ResultCode.NOT_FOUND.code()) {
                        mav.setViewName("error/404");
                    } else {
                        mav.setViewName("error/500");
                        logger.error(e.getMessage(), e);
                    }
                }
            } else {
                mav.setViewName("error/500");
                logger.error(e.getMessage(), e);
            }
            return mav;
        });
    }

}
