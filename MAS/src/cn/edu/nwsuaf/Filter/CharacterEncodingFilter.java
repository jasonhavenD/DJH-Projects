package cn.edu.nwsuaf.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 过滤器解决中文编码问题
 */
public class CharacterEncodingFilter implements Filter {
    private FilterConfig config;
    private String encoding = "UTF-8";
    public void destroy() {
        config = null;
    }
    public void doFilter(ServletRequest request, ServletResponse response,
    FilterChain chain) throws IOException, ServletException {
    	System.out.println("LOG:ProtectFilter-deFilter()");
    	request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        String s = config.getInitParameter("encoding");
        if (s != null) {
            encoding = s;
        }
    }
}