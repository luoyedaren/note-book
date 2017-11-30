package note.book.okhttp;

import com.squareup.okhttp.*;
import org.junit.Test;

/**
 * project: note-book
 * Created by chenghai on 2017/11/30. - 星期四
 * 参考资料 : http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0106/2275.html
 */
public class OKhttpTest {

	public static final MediaType JSON
			= MediaType.parse("application/json; charset=utf-8");

	OkHttpClient okHttpClient = new OkHttpClient();

	@Test
	public void one() throws Exception {
		String json = "";
		String url = "http://huoban.fdc.com.cn/router/rest?method=datamarket.account.showmenulist";
		RequestBody requestBody = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(requestBody).build();
		Response execute = okHttpClient.newCall(request).execute();
		System.out.println(execute.body().string());

		Request build = new Request.Builder().url(url).get().build();
		System.out.println(okHttpClient.newCall(build).execute().body().string());

	}

	@Test
	public void two() throws Exception {

		String url = "http://huoban.fdc.com.cn/router/rest?method=datamarket.account.showmenulist";
		RequestBody formBody = new FormEncodingBuilder()
				.add("platform", "android")
				.add("name", "bug")
				.add("subject", "XXXXXXXXXXXXXXX")
				.build();
		Request build = new Request.Builder().url(url).post(formBody).build();
		Response execute = okHttpClient.newCall(build).execute();
		if (execute.isSuccessful()) {
			String string = execute.body().string();
			System.out.println(string);
		} else {
			String s = execute.body().string();
			System.out.println(s);

		}
	}
}
