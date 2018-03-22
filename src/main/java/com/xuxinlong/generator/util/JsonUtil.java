package com.xuxinlong.generator.util;

import com.alibaba.fastjson.JSON;
import com.xuxinlong.generator.core.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xuxinlong
 * @version 2018年03月07日
 */
public class JsonUtil {

    /**
     * 返回json数据
     *
     * @param response
     * @param result
     */
    public static void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
