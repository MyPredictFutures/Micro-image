package guokangjie.news.com.weiying.activity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.adapter.Fragmen;
import guokangjie.news.com.weiying.bean.PingBean;
import guokangjie.news.com.weiying.bean.VedioBean;
import guokangjie.news.com.weiying.presenter.VedioPresenter;
import guokangjie.news.com.weiying.view.VedioView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class VedioActivity extends BaseActivity implements VedioView {

    @BindView(R.id.ijkPlayer)
    IjkVideoView videoView;
    @BindView(R.id.but1)
    RadioButton mBut1;
    @BindView(R.id.but2)
    RadioButton mBut2;
    @BindView(R.id.vp)
    ViewPager mVp;

    private String url;
    private VedioPresenter vedioPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);
        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        if (url == null) {
            return;
        }
        vedioPresenter = new VedioPresenter(this);
        vedioPresenter.getShow(url);
        mVp.setAdapter(new Fragmen(getSupportFragmentManager()));
    }


    @Override
    public void getVedio(VedioBean vedioBean) {
        String smoothURL = vedioBean.getRet().getHDURL();
        String dataId = vedioBean.getRet().getList().get(0).getChildList().get(5).getDataId();
        new VedioPresenter(this).getShowping(dataId, "20");
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        AndroidMediaController controller = new AndroidMediaController(this, false);
        videoView.setMediaController(controller);
        videoView.setVideoURI(Uri.parse(smoothURL));
        videoView.start();
    }

    @Override
    public void getVedio2(PingBean pingBean) {
        //mTvShow.setText(pingBean.getRet().getList().get(0).getMsgX());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IjkMediaPlayer.native_profileEnd();
        vedioPresenter.Mainnull();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.resume();
    }

    private void setOrientation(int orientation) {
        if (orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @OnClick({R.id.but1, R.id.but2})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:
                mVp.setCurrentItem(0);
                break;
            case R.id.but2:
                mVp.setCurrentItem(1);
                break;
        }
    }
}
