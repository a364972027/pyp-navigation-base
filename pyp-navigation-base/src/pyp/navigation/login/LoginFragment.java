package pyp.navigation.login;

import java.util.regex.Pattern;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import pyp.navigation.R;
import pyp.navigation.main.MainActivity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import pyp.navigation.login.InputMethodRelativeLayout.OnSizeChangedListenner;
import pyp.navigation.login.LoginConn;

/**
 * @Title: LoginFragment
 * @Description: 登录模块页面
 * @author chenzj
 * @date 2014-7-20
 * @email chenzhongjin@vip.qq.com
 */

public class LoginFragment extends Fragment implements OnSizeChangedListenner {

	private View parentView;
	private MainActivity parentActivity;

	private InputMethodRelativeLayout layout;
	private LinearLayout boot;
	private LinearLayout login_logo_layout_h;
	private LinearLayout login_logo_layout_v;
	private EditText txUserName;
	private EditText txPassword;
	private Button btnLogin;
	private Button btnNewRegister;
	private Button btnNewFindPassword;
	public static AlertDialog.Builder builder;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// /在Android2.2以后必须添加以下代码
		// 本应用采用的Android4.0
		// 设置线程的策略
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork() // or
																		// .detectAll()
																		// for
																		// all
																		// detectable
																		// problems
				.penaltyLog().build());
		// 设置虚拟机的策略
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects()
				// .detectLeakedClosableObjects()
				.penaltyLog().penaltyDeath().build());
		super.onCreate(savedInstanceState);

		// 设置页面布局
		parentView = inflater.inflate(R.layout.login_main, container, false);
		if (getActivity() instanceof MainActivity)
			parentActivity = (MainActivity) getActivity();

		// 设置初始化视图
		initView(parentView);
		return parentView;
	}

	/**
	 * 初始化组件
	 */
	private void initView(View parentView) {

		// 取得InputMethodRelativeLayout组件
		layout = (InputMethodRelativeLayout) parentView
				.findViewById(R.id.loginpage);

		Log.i("chenzj", "页面加载成功", null);

		// 取得大LOGO布局
		login_logo_layout_v = (LinearLayout) parentView
				.findViewById(R.id.login_logo_layout_v);
		// 取得小LOGO布局
		login_logo_layout_h = (LinearLayout) parentView
				.findViewById(R.id.login_logo_layout_h);

		// 取得找回密码和新注册布局
		boot = (LinearLayout) parentView
				.findViewById(R.id.reg_and_forget_password_layout);

		// 取得学号、密码和登录按钮
		txUserName = (EditText) parentView.findViewById(R.id.student_no);
		txPassword = (EditText) parentView.findViewById(R.id.passWord);
		btnLogin = (Button) parentView.findViewById(R.id.login_btn);
		btnNewRegister = (Button) parentView.findViewById(R.id.reg_btn);
		btnNewFindPassword = (Button) parentView
				.findViewById(R.id.findPassword_btn);

		Log.i("chenzj", "获取dialog", null);
		builder = new Builder(getActivity());

		// 设置监听事件
		// layout.setOnSizeChangedListenner(this);
		btnLogin.setOnClickListener(LoginOnClickListener);
		btnNewRegister.setOnClickListener(newRegisterOnClickListener);
		btnNewFindPassword.setOnClickListener(newFindPassWordOnClickListener);
	}

	OnClickListener LoginOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String userName = txUserName.getText().toString();
			String password = txPassword.getText().toString();

			if (isNumeric(userName) && userName.length() == 10) {
				LoginConn.loginRemoteService(userName, password);
			}else {
				Toast.makeText(parentActivity, "账户输入有误,请重新输入",
						Toast.LENGTH_SHORT).show();
				txUserName.setText("");
			}
		}
	};

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	OnClickListener newRegisterOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Log.i("chenzj", "切换到注册界面");
			parentActivity.changeFragment(RegisterFragment.class.getName());
		}
	};

	OnClickListener newFindPassWordOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Log.i("chenzj", "切换到找回密码界面");
			parentActivity.changeFragment(FindPasswordFragment.class.getName());
		}
	};

	/**
	 * 在LoginFragment中实现OnSizeChangedListener，原理是设置该布局的paddingTop属性来控制子View的偏移
	 */
	@Override
	public void onSizeChange(boolean flag, int w, int h) {
		if (flag) {// 键盘弹出时
			layout.setPadding(0, -10, 0, 0);
			boot.setVisibility(View.GONE);
			login_logo_layout_v.setVisibility(View.GONE);
			login_logo_layout_h.setVisibility(View.VISIBLE);
		} else { // 键盘隐藏时
			layout.setPadding(0, 0, 0, 0);
			boot.setVisibility(View.VISIBLE);
			login_logo_layout_v.setVisibility(View.VISIBLE);
			login_logo_layout_h.setVisibility(View.GONE);
		}
	};

}