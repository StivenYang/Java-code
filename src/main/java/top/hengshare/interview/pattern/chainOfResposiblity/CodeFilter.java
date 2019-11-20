package top.hengshare.interview.pattern.chainOfResposiblity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: Java-Interview
 * @description: CodeFilter
 * @author: StivenYang
 * @create: 2019-11-18 19:26
 **/
public class CodeFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getAttribute("");
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
