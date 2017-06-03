package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	private String characterSet;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CharacterEncodingFilter init()");
		characterSet = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// 전처리 (서블릿이 실행하기전에 처리: 요청처리전)
		System.out.println("CharacterEncodingFilter dofilter()-전처리");
		request.setCharacterEncoding(characterSet); // 필터로 넘어온 코드를 전처리로 디코딩을
													// 수행함.
		// -----------------------------------------------------------------------------
		filterChain.doFilter(request, response); // 이 코드를 기준으로 위가 전처리 아래가 후처리
		// ----------------------------------------------------------------------------
		// 후처리 (서블릿이 실행한후에 처리 : 응답을 보내기전)
		System.out.println("CharacterEncodingFilter dofilter()-후처리");
	}

	@Override
	public void destroy() {
		System.out.println("CharacterEncodingFilter destroy()");
	}

}
