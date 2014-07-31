package pyp.navigation.login;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.util.Log;
import pyp.navigation.login.LoginFragment;
public class LoginConn {
	// 模拟器自己把自己当成localhost了，服务器应该为10.0.2.2
	private static String url = "http://10.0.2.2:8080/JsonWeb/login.action?";
	private final static  String url_constant = "http://10.0.2.2:8080/JsonWeb/login.action?";
	public static String result;
	
	/**
	 * 获取Struts2 Http 登录的请求信息
	 * 
	 * @param userName
	 * @param password
	 */
	public static void loginRemoteService(String userName, String password) {
		result = null;
		try {

			// 创建一个HttpClient对象
			HttpClient httpclient = new DefaultHttpClient();
			// 远程登录URL
			// 下面这句是原有的
			// processURL=processURL+"userName="+userName+"&password="+password;
			url = url_constant + "userName=" + userName + "&password="
					+ password;

			Log.i("chenzj", "远程url为: " + url, null);
			
			// 创建HttpGet对象
			HttpGet request = new HttpGet(url);
			
			// 请求信息类型MIME每种响应类型的输出（普通文本、html 和 XML，json）。允许的响应类型应当匹配资源类中生成的 MIME
			// 类型
			// 资源类生成的 MIME 类型应当匹配一种可接受的 MIME 类型。如果生成的 MIME 类型和可接受的 MIME 类型不
			// 匹配，那么将
			// 生成 com.sun.jersey.api.client.UniformInterfaceException。例如，将可接受的
			// MIME 类型设置为 text/xml，而将
			// 生成的 MIME 类型设置为 application/xml。将生成 UniformInterfaceException。
			request.addHeader("Accept", "text/json");
			// 获取响应的结果
			HttpResponse response = httpclient.execute(request);
			// 获取HttpEntity
			HttpEntity entity = response.getEntity();
			// 获取响应的结果信息
			String json = EntityUtils.toString(entity, "UTF-8");
			
			Log.i("chenzj", "json数据为:" + json, null);
			// JSON的解析过程
			if (json != null) {
				JSONObject jsonObject = new JSONObject(json);
				result = jsonObject.get("message").toString();
			}
			if (result == null) {
				json = "登录失败请重新登录";
			}
			
			Log.i("chenzj", "服务器已经返回数据", null);
			Log.i("chenzj", "输出结果为:"+result, null);
			
			
			//弹出dialog提示用户用户登录成功or失败原因.
			
			
			LoginFragment.builder.setTitle("提示")
			 .setMessage(result)
			 .setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			}).create().show();

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
