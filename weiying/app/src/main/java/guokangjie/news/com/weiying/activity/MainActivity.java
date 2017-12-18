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

import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.fragment.fragment_fx;
import guokangjie.news.com.weiying.fragment.fragment_jx;
import guokangjie.news.com.weiying.fragment.fragment_presonal;
import guokangjie.news.com.weiying.fragment.fragment_zt;
import guokangjie.news.com.weiying.myview.MyFrameLayout;
import guokangjie.news.com.weiying.myview.MyMainDragView;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mAvatar;
    /**
     * 微影，微一下
     */
    private TextView mDesc;
    private LinearLayout mTopMenu;
    /**
     * 我的收藏
     */
    private TextView mTvCollect;
    /**
     * 我的下载
     */
    private TextView mTvMydown;
    /**
     * 福利
     */
    private TextView mTvFuli;
    /**
     * 分享
     */
    private TextView mTvShare;
    /**
     * 建议反馈
     */
    private TextView mTvFeedback;
    /**
     * 设置
     */
    private TextView mTvSetting;
    /**
     * 关于
     */
    private TextView mAbout;
    /**
     * 主题
     */
    private TextView mTheme;
    private FrameLayout mFlMain;
    private LinearLayout mLlMainJx;
    private LinearLayout mLlMainZt;
    private LinearLayout mLlMainFx;
    private LinearLayout mLlMainMy;
    private MyFrameLayout mMainContentFrameParent;
    private MyMainDragView mMyDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        changeFramgnet(new fragment_jx());
        mMyDrawer.setDragListener(new MyMainDragView.DragListener() {
            @Override
            public void onOpen() {
                if (mMyDrawer.getStatus() == MyMainDragView.Status.Open) {
                }
            }

            @Override
            public void onClose() {
                mMyDrawer.close();
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

    private void initView() {
        mAvatar = (ImageView) findViewById(R.id.avatar);
        mDesc = (TextView) findViewById(R.id.desc);
        mTopMenu = (LinearLayout) findViewById(R.id.top_menu);
        mTvCollect = (TextView) findViewById(R.id.tv_collect);
        mTvMydown = (TextView) findViewById(R.id.tv_mydown);
        mTvFuli = (TextView) findViewById(R.id.tv_fuli);
        mTvShare = (TextView) findViewById(R.id.tv_share);
        mTvFeedback = (TextView) findViewById(R.id.tv_feedback);
        mTvSetting = (TextView) findViewById(R.id.tv_setting);
        mAbout = (TextView) findViewById(R.id.about);
        mTheme = (TextView) findViewById(R.id.theme);
        mFlMain = (FrameLayout) findViewById(R.id.fl_main);
        mLlMainJx = (LinearLayout) findViewById(R.id.ll_main_jx);
        mLlMainJx.setOnClickListener(this);
        mLlMainZt = (LinearLayout) findViewById(R.id.ll_main_zt);
        mLlMainZt.setOnClickListener(this);
        mLlMainFx = (LinearLayout) findViewById(R.id.ll_main_fx);
        mLlMainFx.setOnClickListener(this);
        mLlMainMy = (LinearLayout) findViewById(R.id.ll_main_my);
        mLlMainMy.setOnClickListener(this);
        mMainContentFrameParent = (MyFrameLayout) findViewById(R.id.main_content_frame_parent);
        mMyDrawer = (MyMainDragView) findViewById(R.id.my_drawer);
    }

    @Override
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
