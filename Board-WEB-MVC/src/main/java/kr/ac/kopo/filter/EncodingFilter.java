package kr.ac.kopo.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = {"*"}, initParams = {@WebInitParam(name="encoding", value="utf-8")} )
public class EncodingFilter implements Filter {

	private FilterConfig filterConfig;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter 작업중...");

		String encoding = filterConfig.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("filter 종료.....");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter 시작.....");
		this.filterConfig = filterConfig;
	}

}
