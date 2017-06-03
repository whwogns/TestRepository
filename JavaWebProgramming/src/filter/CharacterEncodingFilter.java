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
		// ��ó�� (������ �����ϱ����� ó��: ��ûó����)
		System.out.println("CharacterEncodingFilter dofilter()-��ó��");
		request.setCharacterEncoding(characterSet); // ���ͷ� �Ѿ�� �ڵ带 ��ó���� ���ڵ���
													// ������.
		// -----------------------------------------------------------------------------
		filterChain.doFilter(request, response); // �� �ڵ带 �������� ���� ��ó�� �Ʒ��� ��ó��
		// ----------------------------------------------------------------------------
		// ��ó�� (������ �������Ŀ� ó�� : ������ ��������)
		System.out.println("CharacterEncodingFilter dofilter()-��ó��");
	}

	@Override
	public void destroy() {
		System.out.println("CharacterEncodingFilter destroy()");
	}

}
