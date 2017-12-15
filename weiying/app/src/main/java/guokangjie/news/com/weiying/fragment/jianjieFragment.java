package guokangjie.news.com.weiying.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.adapter.JianjieAdapter;
import guokangjie.news.com.weiying.bean.PingBean;
import guokangjie.news.com.weiying.bean.VedioBean;
import guokangjie.news.com.weiying.presenter.VedioPresenter;
import guokangjie.news.com.weiying.view.VedioView;

/**
 * Created by cll on 2017/11/23.
 */

public class jianjieFragment extends Fragment implements VedioView {
    private View view;
    private TextView mDaoyan;
    private TextView mYanyuan;
    private RecyclerView mGi;
    private VedioPresenter bofangPresenter;
    private String url;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f1, container, false);
        Intent intent = getActivity().getIntent();
        url = intent.getStringExtra("url");
        if (url == null) {
            return null;
        }
        initView(view);
        bofangPresenter.getShow(url);
        url = null;
        return view;
    }

    private void initView(View view) {
        mDaoyan = (TextView) view.findViewById(R.id.daoyan);
        mYanyuan = (TextView) view.findViewById(R.id.yanyuan);
        mGi = (RecyclerView) view.findViewById(R.id.Gi);
        mGi.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        bofangPresenter = new VedioPresenter(getActivity(), this);
    }


    @Override
    public void getVedio(VedioBean bofangBean) {
        VedioBean.RetBean ret = bofangBean.getRet();
        mDaoyan.setText("导演:" + ret.getDirector());
        mYanyuan.setText("演员:" + ret.getActors());

        List<VedioBean.RetBean.ListBean.ChildListBean> childList = bofangBean.getRet().getList().get(0).getChildList();
        JianjieAdapter jianjieAdapter = new JianjieAdapter(getActivity(), childList);
        mGi.setAdapter(jianjieAdapter);
    }

    @Override
    public void getVedio2(PingBean pingBean) {

    }

}
