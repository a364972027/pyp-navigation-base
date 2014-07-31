package pyp.navigation.login;

import java.util.regex.Pattern;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import pyp.navigation.R;
import pyp.navigation.main.MainActivity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

/**
 * @Title: RegisterFragment
 * @Description: 注册模块界面
 * @author chenzj
 * @date 2014-7-23
 * @email chenzhongjin@vip.qq.com
 */
public class RegisterFragment extends Fragment {

	private View parentView;
	private MainActivity parentActivity;
	private EditText txUserName;
	private EditText txPassword;
	private EditText txPasswordConfirm;
	private Button btnComplete;
	private View btnReturn;
	private ImageView btnPopuPhoto;
	public static AlertDialog.Builder builder;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 设置页面布局
		parentView = inflater.inflate(R.layout.register_main, container, false);
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
		txUserName = (EditText) parentView.findViewById(R.id.regist_name_et);
		txPassword = (EditText) parentView
				.findViewById(R.id.regist_password_et);
		txPasswordConfirm = (EditText) parentView
				.findViewById(R.id.regist_password_et_confirm);

		btnComplete = (Button) parentView.findViewById(R.id.regist_btn);
		btnReturn = (View) parentView.findViewById(R.id.title_bar_back_v);
		btnPopuPhoto = (ImageView) parentView.findViewById(R.id.regist_camera_img);
		
		Log.i("chenzj", "获取dialog", null);
		builder = new Builder(getActivity());

		// 设置监听事件
		btnComplete.setOnClickListener(RegisterOnClickListener);
		btnReturn.setOnClickListener(ReturnLoginFragmentOnClickListener);
		//btnPopuPhoto.setOnClickListener(PopuPhotoOnClickListener);
	}

	/**1
	 * @Fields RegisterOnClickListener : TODO
	 */
	OnClickListener RegisterOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String userName = txUserName.getText().toString();
			String password = txPassword.getText().toString();
			String passwordConfirm = txPasswordConfirm.getText().toString();

			if (isNumeric(userName) && userName.length() == 10) {

				if (password.equals(passwordConfirm)) {
					RegisterConn.RegisterRemoteService(userName, password);
				} else {
					Toast.makeText(parentActivity, "两次输入的密码不一致",
							Toast.LENGTH_SHORT).show();
					txPassword.setText("");
					txPasswordConfirm.setText("");
				}
			} else {
				Toast.makeText(parentActivity, "学号输入有误,请重新输入",
						Toast.LENGTH_SHORT).show();
				txUserName.setText("");
			}

		}
	};

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * @Fields RegisterOnClickListener : TODO
	 */
	OnClickListener ReturnLoginFragmentOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Log.i("chenzj", "从注册界面返回到登录界面");
			parentActivity.changeFragment(LoginFragment.class.getName());
		}
	};
	
	OnClickListener PopuPhotoOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Log.i("chenzj", "弹出选择头像界面");
			parentActivity.changeFragment(PopuPhotoFragment.class.getName());
		}
	};
	
}