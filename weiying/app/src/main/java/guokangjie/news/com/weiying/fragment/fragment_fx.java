package guokangjie.news.com.weiying.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;

import java.util.ArrayList;
import java.util.List;

import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.activity.VedioActivity;
import guokangjie.news.com.weiying.adapter.FxAdapter;
import guokangjie.news.com.weiying.bean.PagerBean;
import guokangjie.news.com.weiying.presenter.PresenterClassFx;
import guokangjie.news.com.weiying.presenter.PresenterInterFx;
import guokangjie.news.com.weiying.view.ViewInterFx;

/**
 * Created by 郭康杰 on 2017/11/20.
 */

public class fragment_fx extends Fragment implements ViewInterFx{

    private FxAdapter adapter;
    private RecyclerView rc;
    private List<PagerBean.RetBean.ListBean.ChildListBean> list;
    private Button bt;
    private SimpleDraweeView image;
    private int index=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fx, container, false);

        list = new ArrayList<>();
        rc = (RecyclerView) view.findViewById(R.id.rc);
        bt = (Button) view.findViewById(R.id.bt_dis);
        image = (SimpleDraweeView) view.findViewById(R.id.dis_image_view);

        PresenterInterFx presenterInter = new PresenterClassFx(this);
        presenterInter.getPresen(index);
        rc.setLayoutManager(new OverLayCardLayoutManager());
        CardConfig.initConfig(getContext());
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PresenterInterFx presenterInter = new PresenterClassFx(fragment_fx.this);
                presenterInter.getPresen(++index);
            }
        });
        return view;
    }

    @Override
    public void getView(final List<PagerBean.RetBean.ListBean.ChildListBean> beanList) {

        adapter=new FxAdapter(getContext(),beanList);
        ItemTouchHelper.Callback callback = new RenRenCallback(rc,adapter,beanList);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(rc);
        rc.setAdapter(adapter);
        adapter.setiOnclick(new FxAdapter.IOnclick() {
            @Override
            public void onclick() {

                Intent intent = new Intent(getContext(),VedioActivity.class);
                intent.putExtra("url",beanList.get(0).getDataId());
                startActivity(intent);
                if (beanList.get(0).getDataId()==null){
                    Toast.makeText(getContext(), "暂无数据", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void getUri(Uri uri) {
        image.setImageURI(uri);
    }


}
