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
* ��ȡ��֤�뵹��ʱ������������
* @author �е�����
* QQȺ��123869487
* ����ѹ�ͬ�������������Ⱥָ��
*
*/
public class MainActivity extends Activity {
	private static Button button = null;
	private static TimeCount time;	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = new TimeCount(60000, 1000);//����CountDownTimer����
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

	//ע���ʱ��
	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// ��������Ϊ��ʱ��,�ͼ�ʱ��ʱ����
		}

		@Override
		public void onFinish() {// ��ʱ���ʱ����
			button.setBackgroundResource(R.drawable.iv_getcode);
			button.setText("���»�ȡ");
			button.setClickable(true);
		}

		@Override
		public void onTick(long millisUntilFinished) {// ��ʱ������ʾ
			button.setClickable(false);
			button.setText(millisUntilFinished / 1000 + "��");
		}
	}
	
}
