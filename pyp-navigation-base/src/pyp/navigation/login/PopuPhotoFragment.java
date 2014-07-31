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
import android.widget.SeekBar;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;


/**
 * @Title: PopuPhotoFragment
 * @Description: 选择头像的来源的界面
 * @author chenzj
 * @date 2014-7-30
 * @email chenzhongjin@vip.qq.com
 */
public class PopuPhotoFragment extends Fragment {

	private View parentView;
	private MainActivity parentActivity;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 设置页面布局
		parentView = inflater.inflate(R.layout.register_popu_photo_pick, container, false);
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
		
	}

}