package guokangjie.news.com.weiying.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.VedioActivity;
import guokangjie.news.com.weiying.adapter.VideoRecycleAdapter;
import guokangjie.news.com.weiying.app.FrescoImage;
import guokangjie.news.com.weiying.bean.PagerBean;
import guokangjie.news.com.weiying.event.MessageNumEvent;
import guokangjie.news.com.weiying.presenter.MainPresenter;
import guokangjie.news.com.weiying.view.MainView;

/**
 * Created by 郭康杰 on 2017/11/20.
 */

public class fragment_jx extends Fragment implements MainView {
    @BindView(R.id.banner_jx)
    Banner mBannerJx;
    @BindView(R.id.recycle_jx)
    RecyclerView mRecycleJx;
    private Unbinder unbinder;
    private MainPresenter mainPresenter;
    private String Gurl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_jx, container, false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        //获取数据
        mRecycleJx.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mainPresenter = new MainPresenter(getActivity(), this);
        mainPresenter.getShow();
        return view;
    }

    @Subscribe
    public void getJump(MessageNumEvent messageNumEvent) {
        //传送过去
        Intent intent = new Intent(getActivity(), VedioActivity.class);
        intent.putExtra("url", messageNumEvent.getUrl());
        startActivity(intent);
    }

    @Override
    public void ShowPgInfo(PagerBean pagerBean) {
        //得到数据的时候放入里面
        ArrayList<String> picList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();
        final ArrayList<String> LoadUrlList = new ArrayList<>();
        List<PagerBean.RetBean.ListBean.ChildListBean> List = pagerBean.getRet().getList().get(0).getChildList();
        for (PagerBean.RetBean.ListBean.ChildListBean arr : List) {
            String pic = arr.getPic();
            String title = arr.getTitle();
            String loadURL = arr.getDataId();
            picList.add(pic);
            titleList.add(title);
            LoadUrlList.add(loadURL);
        }
        //进行展示
        mBannerJx.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        mBannerJx.setImageLoader(new FrescoImage());
        mBannerJx.setBannerTitles(titleList);
        mBannerJx.setDelayTime(3000);
        mBannerJx.setBannerAnimation(Transformer.ZoomOutSlide);
        mBannerJx.setImages(picList);
        mBannerJx.start();
        mBannerJx.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                String url = LoadUrlList.get(position);
                Intent intent = new Intent(getActivity(), VedioActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        //展示
        java.util.List<PagerBean.RetBean.ListBean.ChildListBean> childList = pagerBean.getRet().getList().get(2).getChildList();
        VideoRecycleAdapter videoRecycleAdapter = new VideoRecycleAdapter(getActivity(), childList);
        mRecycleJx.setAdapter(videoRecycleAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mainPresenter.Mainnull();
    }
}
