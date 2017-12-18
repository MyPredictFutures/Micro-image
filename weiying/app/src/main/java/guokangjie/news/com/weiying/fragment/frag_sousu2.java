package guokangjie.news.com.weiying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.adapter.SouSuAdapter;
import guokangjie.news.com.weiying.bean.SouSuoBean;
import guokangjie.news.com.weiying.event.MessageinfoEvent;
import guokangjie.news.com.weiying.presenter.SouSuPresenter;
import guokangjie.news.com.weiying.view.SouSuView;

/**
 * Created by 郭康杰 on 2017/11/20.
 */

public class frag_sousu2 extends Fragment implements SouSuView {


    private SouSuPresenter souSuPresenter;
    private RecyclerView mRecycleSsout;
    private String info;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ssfrag2, container, false);
        Bundle bundle = getArguments();//从activity传过来的Bundle
        if (bundle != null) {
            info = bundle.getString("info");
        }
        initView(view);
        souSuPresenter = new SouSuPresenter(getActivity(), this);
        souSuPresenter.getShowall(info, "1");
        return view;
    }

    @Subscribe
    public void Messageinfo(MessageinfoEvent messageinfoEvent) {
        String url = messageinfoEvent.getUrl();
        Log.e("tag", url + "---" + "bbb");
        souSuPresenter.getShowall(url, "1");
    }

    @Override
    public void getSouSu(SouSuoBean souSuoBean) {
        if (souSuoBean.getCode().equals("200")) {
            List<SouSuoBean.RetBean.ListBean> list = souSuoBean.getRet().getList();
            SouSuAdapter souSuAdapter = new SouSuAdapter(getActivity(), list);
            mRecycleSsout.setAdapter(souSuAdapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        souSuPresenter.Mainnull();
    }

    private void initView(View view) {
        Log.e("tag", "---" + "bbb4");
        mRecycleSsout = (RecyclerView) view.findViewById(R.id.recycle_ssout);
        Log.e("tag", "---" + "bbb5");
        mRecycleSsout.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    }
}
