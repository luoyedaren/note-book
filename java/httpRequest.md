jdk api中没有提供修改 request里参数的方法，绕过方式：
新建子类 `PrettyFacesWrappedRequest` 继承 `HttpServletRequestWrapper`

```java
package com.fdc.uc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

/**
 * project: user-center-system
 * Created by chenghai on 2017/10/18. - 星期三
 */
public class PrettyFacesWrappedRequest extends HttpServletRequestWrapper
{
	private final Map<String, String[]> modifiableParameters;
	private Map<String, String[]> allParameters = null;

	/**
	 * Create a new request wrapper that will merge additional parameters into
	 * the request object without prematurely reading parameters from the
	 * original request.
	 *
	 * @param request
	 * @param additionalParams
	 */
	public PrettyFacesWrappedRequest(final HttpServletRequest request,
									 final Map<String, String[]> additionalParams)
	{
		super(request);
		modifiableParameters = new TreeMap<>();
		modifiableParameters.putAll(additionalParams);
	}

	@Override
	public String getParameter(final String name)
	{
		String[] strings = getParameterMap().get(name);
		if (strings != null)
		{
			return strings[0];
		}
		return super.getParameter(name);
	}

	@Override
	public Map<String, String[]> getParameterMap()
	{
		if (allParameters == null)
		{
			allParameters = new TreeMap<>();
			allParameters.putAll(super.getParameterMap());
			allParameters.putAll(modifiableParameters);
		}
		//Return an unmodifiable collection because we need to uphold the interface contract.
		return Collections.unmodifiableMap(allParameters);
	}

	@Override
	public Enumeration<String> getParameterNames()
	{
		return Collections.enumeration(getParameterMap().keySet());
	}

	@Override
	public String[] getParameterValues(final String name)
	{
		return getParameterMap().get(name);
	}
}

```

filter 中实现添加或修改参数，修改参数其实就是覆盖map中的key-value
```java

package com.fdc.uc.filter;

import com.fdc.uc.interceptor.PrettyFacesWrappedRequest;
import com.fdc.uc.util.IdDecoderUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * project: user-center-system
 * Created by chenghai on 2017/10/18. - 星期三
 */
public class UserIdConvertorFilter implements Filter {
	private static final Logger log = LoggerFactory.getLogger(UserIdConvertorFilter.class);
	private static final String[] modifyParamArray = new String[]{"userid", "userids", "fid","uid","anomymousId"};

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


		if (request instanceof HttpServletRequest) {
			HttpServletRequest wrappedRequest = null;
			try {
				Map<String, String[]> extraParams = new TreeMap<>();
				for (String s : modifyParamArray) {
					String parameterValue = request.getParameter(s);
					if (StringUtils.isNotEmpty(parameterValue)) {
						extraParams.put(s, new String[]{IdDecoderUtil.decodeIfNeeded(parameterValue)});
					}
				}
				wrappedRequest = new PrettyFacesWrappedRequest((HttpServletRequest) request, extraParams);
			} catch (Exception e) {
				log.error("UserIdConvertorFilter error.",e);
			}

			if (wrappedRequest != null) {
				chain.doFilter(wrappedRequest,response);
			}else{
				chain.doFilter(request, response);
			}

		}else {
			chain.doFilter(request,response);
		}


	}

	@Override
	public void destroy() {

	}

}

```