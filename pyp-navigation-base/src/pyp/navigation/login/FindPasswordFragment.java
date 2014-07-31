package pyp.navigation.login;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import pyp.navigation.R;
import pyp.navigation.main.MainActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
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


/**
 * @Title: RegisterFragment
 * @Description: 找回密码界面
 * @author chenzj
 * @date 2014-7-23
 * @email chenzhongjin@vip.qq.com
 */
public class FindPasswordFragment extends Fragment{

	private View parentView;
	private MainActivity parentActivity;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.register_main, container, false);
		if (getActivity() instanceof MainActivity) 
			parentActivity = (MainActivity) getActivity();
		initView(parentView);
		return parentView;
	}

	

	/**
	 * 初始化组件
	 */
	private void initView(View parentView) {
		
				
	}

	
	
}