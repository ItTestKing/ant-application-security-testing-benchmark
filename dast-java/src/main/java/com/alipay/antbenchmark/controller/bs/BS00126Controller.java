package com.alipay.antbenchmark.controller.bs;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/xss")
public class BS00126Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @ResponseBody
    @RequestMapping(value = "/BS00126", method = {RequestMethod.POST, RequestMethod.GET})
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = request.getParameter("BS00126");
        if (param == null) {
            param = "";
        }
        param = StringUtils.replace(param, "&", "&amp;");
        param = StringUtils.replace(param, "<", "&lt;");
        param = StringUtils.replace(param, ">", "&gt;");
        param = StringUtils.replace(param, "\"", "&quot;");
        param = StringUtils.replace(param, "'", "&#x27;");
        param = StringUtils.replace(param, "/", "&#x2F;");

        response.setHeader("X-XSS-Protection", "0");
        if (param == null) {
            param = "";
        }
        response.getWriter().write(" <a href=\"" + param + "\">ClickMe</a>");
    }
}
