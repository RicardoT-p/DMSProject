package cn.ylcto.dms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/pages/back/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession ses = request.getSession();
        if(ses.getAttribute("admin") != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            request.setAttribute("msg","你还没有登录，请登录后操作数据！");
            request.setAttribute("url","/login.jsp");
            request.getRequestDispatcher("/pages/forward.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
