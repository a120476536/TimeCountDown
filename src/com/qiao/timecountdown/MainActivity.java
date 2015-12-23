package com.qiao.timecountdown;




import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
/**
* 获取验证码倒计时。。。。。。
* @author 有点凉了
* QQ群：123869487
* 求基友共同进步，求大神入群指点
*
*/
public class MainActivity extends Activity {
	private static Button button = null;
	private static TimeCount time;	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = new TimeCount(60000, 1000);//构造CountDownTimer对象
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
    	
        public PlaceholderFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
        	// TODO Auto-generated method stub
        	super.onCreate(savedInstanceState);
        	
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            button = (Button) rootView.findViewById(R.id.bt_get);
            button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					time.start();
				}
			});
            return rootView;
        }
    }

	//注册计时器
	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		}

		@Override
		public void onFinish() {// 计时完毕时触发
			button.setBackgroundResource(R.drawable.iv_getcode);
			button.setText("重新获取");
			button.setClickable(true);
		}

		@Override
		public void onTick(long millisUntilFinished) {// 计时过程显示
			button.setClickable(false);
			button.setText(millisUntilFinished / 1000 + "秒");
		}
	}
	
}
