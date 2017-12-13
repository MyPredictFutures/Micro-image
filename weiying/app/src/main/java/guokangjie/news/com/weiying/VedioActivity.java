package guokangjie.news.com.weiying;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import guokangjie.news.com.weiying.bean.PingBean;
import guokangjie.news.com.weiying.bean.VedioBean;
import guokangjie.news.com.weiying.presenter.VedioPresenter;
import guokangjie.news.com.weiying.view.VedioView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class VedioActivity extends AppCompatActivity implements VedioView {

    @BindView(R.id.ijkPlayer)
    IjkVideoView videoView;
    @BindView(R.id.bt_all)
    Button mBtAll;
    private String url;
    private VedioPresenter vedioPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);
        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        Log.e("TAG", "----" + url);
        vedioPresenter = new VedioPresenter(this);
        vedioPresenter.getShow(url);
    }


    @Override
    public void getVedio(VedioBean vedioBean) {
        String smoothURL = vedioBean.getRet().getHDURL();
        String dataId = vedioBean.getRet().getList().get(0).getChildList().get(0).getDataId();
        // new VedioPresenter(this).getShowping(dataId, "20");
        Log.e("TAG", "--+++--" + smoothURL);
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

    @OnClick(R.id.bt_all)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_all:
                mBtAll.setVisibility(View.GONE);
                setOrientation(getResources().getConfiguration().orientation);
                break;
        }
    }
}
