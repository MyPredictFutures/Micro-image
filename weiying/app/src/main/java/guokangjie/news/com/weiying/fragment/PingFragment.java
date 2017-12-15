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


import java.util.List;

import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.adapter.PingAdapter;
import guokangjie.news.com.weiying.bean.PingBean;
import guokangjie.news.com.weiying.bean.VedioBean;
import guokangjie.news.com.weiying.presenter.VedioPresenter;
import guokangjie.news.com.weiying.view.VedioView;

/**
 * Created by cll on 2017/11/23.
 */

public class PingFragment extends Fragment implements VedioView{
    private View view;
    private RecyclerView mRv;
    private String id1;
    private VedioPresenter pingPresenter;
    private String url;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2, container, false);
        Intent intent = getActivity().getIntent();
        url = intent.getStringExtra("url");
        if (url==null){
         return null;
        }
        initView(view);
        pingPresenter.getShowping(url,"20");
        url=null;
        return view;
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        pingPresenter = new VedioPresenter(getActivity(), this);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }



    @Override
    public void getVedio(VedioBean vedioBean) {

    }

    @Override
    public void getVedio2(PingBean pingBean) {
        List<PingBean.RetBean.ListBean> list = pingBean.getRet().getList();
        PingAdapter pingAdapter = new PingAdapter(getActivity(), list);
        mRv.setAdapter(pingAdapter);
    }

}
