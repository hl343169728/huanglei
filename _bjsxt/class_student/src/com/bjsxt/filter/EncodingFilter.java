package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义字符集过滤器，解决用GET方式提交表单字符集出现的问题
 *
 * @author bhz
 * @version 1.0.1 
 */
public class EncodingFilter implements Filter {

    private FilterConfig filterConfig;

    private String chartSet = "UTF-8";

    private static final String FORM_METHOD_POST = "POST";

    private static final String FORM_METHOD_GET = "GET";

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;

    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        String filterCharSet = filterConfig.getInitParameter("charset");
        if (filterCharSet != null && filterCharSet.trim().length() != 0) {
            this.chartSet = filterCharSet;
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String formMethod = request.getMethod();
        if (FORM_METHOD_POST.equalsIgnoreCase(formMethod)) {
            request.setCharacterEncoding(this.chartSet);
        } else if (FORM_METHOD_GET.equalsIgnoreCase(formMethod)) {
            request = new RequestUrlWrapper(request, chartSet);
        }
        response.setCharacterEncoding(this.chartSet);
        filterChain.doFilter(request, response);
    }

	public void destroy() {
		this.filterConfig = null;
		
	}


}