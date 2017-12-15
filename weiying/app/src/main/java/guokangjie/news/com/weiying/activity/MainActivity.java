package guokangjie.news.com.weiying.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.fragment.fragment_fx;
import guokangjie.news.com.weiying.fragment.fragment_jx;
import guokangjie.news.com.weiying.fragment.fragment_presonal;
import guokangjie.news.com.weiying.fragment.fragment_zt;
import guokangjie.news.com.weiying.myview.MyFrameLayout;
import guokangjie.news.com.weiying.myview.MyMainDragView;

public class MainActivity extends BaseActivity {

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
    @BindView(R.id.avatar)
    ImageView mAvatar;
    @BindView(R.id.desc)
    TextView mDesc;
    @BindView(R.id.tv_collect)
    TextView mTvCollect;
    @BindView(R.id.tv_mydown)
    TextView mTvMydown;
    @BindView(R.id.tv_fuli)
    TextView mTvFuli;
    @BindView(R.id.tv_share)
    TextView mTvShare;
    @BindView(R.id.tv_feedback)
    TextView mTvFeedback;
    @BindView(R.id.tv_setting)
    TextView mTvSetting;
    @BindView(R.id.about)
    TextView mAbout;
    @BindView(R.id.theme)
    TextView mTheme;
    @BindView(R.id.main_content_frame_parent)
    MyFrameLayout mMainContentFrameParent;
    @BindView(R.id.my_drawer)
    MyMainDragView mMyMainDragView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        changeFramgnet(new fragment_jx());
        mMyMainDragView.setDragListener(new MyMainDragView.DragListener() {
            @Override
            public void onOpen() {
                if(mMyMainDragView.getStatus () == MyMainDragView.Status.Open){}
            }

            @Override
            public void onClose() {
                mMyMainDragView.close();
            }

            @Override
            public void onDrag(float percent) {

            }
        });
    }

    //切换
    public void changeFramgnet(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment);
        fragmentTransaction.commit();

    }

    //切换
    @OnClick({R.id.ll_main_jx, R.id.ll_main_zt, R.id.ll_main_fx, R.id.ll_main_my, R.id.avatar, R.id.desc, R.id.tv_collect, R.id.tv_mydown, R.id.tv_fuli, R.id.tv_share, R.id.tv_feedback, R.id.tv_setting, R.id.about, R.id.theme,  R.id.fl_main})
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
            case R.id.avatar:
                break;
            case R.id.desc:
                break;
            case R.id.tv_collect:
                break;
            case R.id.tv_mydown:
                break;
            case R.id.tv_fuli:
                break;
            case R.id.tv_share:
                break;
            case R.id.tv_feedback:
                break;
            case R.id.tv_setting:
                break;
            case R.id.about:
                break;
            case R.id.theme:
                break;
            case R.id.fl_main:
                break;
        }
    }

}
