package guokangjie.news.com.weiying;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import guokangjie.news.com.weiying.fragment.fragment_fx;
import guokangjie.news.com.weiying.fragment.fragment_jx;
import guokangjie.news.com.weiying.fragment.fragment_presonal;
import guokangjie.news.com.weiying.fragment.fragment_zt;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_main)
    FrameLayout mFlMain;
    @BindView(R.id.ll_main_jx)
    LinearLayout mLlMainJx;
    @BindView(R.id.ll_main_zt)
    LinearLayout mLlMainZt;
    @BindView(R.id.ll_main_fx)
    LinearLayout mLlMainFx;
    @BindView(R.id.ll_main_my)
    LinearLayout mLlMainMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        changeFramgnet(new fragment_jx());
    }

    //切换
    public void changeFramgnet(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment);
        fragmentTransaction.commit();

    }

    //切换
    @OnClick({R.id.ll_main_jx, R.id.ll_main_zt, R.id.ll_main_fx, R.id.ll_main_my})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_main_jx:
                changeFramgnet(new fragment_jx());
                break;
            case R.id.ll_main_zt:
                changeFramgnet(new fragment_zt());
                break;
            case R.id.ll_main_fx:
                changeFramgnet(new fragment_fx());
                break;
            case R.id.ll_main_my:
                changeFramgnet(new fragment_presonal());
                break;
        }
    }
}
