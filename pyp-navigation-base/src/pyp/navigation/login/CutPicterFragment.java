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

/*
 * 代码是怎么实现的：
 * 一：主布局界面
 * 二：点击控件触发事件后效果图
 * 三：拍照完之后效果图
 * 四：裁剪界面效果图
 * 五：点击相册后返回的图片效果图
 * 六：裁剪完从相册PICK的保存后的效果图
 */


/**
 * @Title: RegisterFragment
 * @Description: 剪切自定义头像界面
 * @author chenzj
 * @date 2014-7-30
 * @email chenzhongjin@vip.qq.com
 */
public class CutPicterFragment extends Fragment{

	private View parentView;
	private MainActivity parentActivity;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.register_popu_photo_pick, container, false);
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