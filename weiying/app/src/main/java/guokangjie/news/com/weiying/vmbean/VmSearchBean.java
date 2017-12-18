package guokangjie.news.com.weiying.vmbean;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.activity.SearchorActivity;
import guokangjie.news.com.weiying.fragment.frag_sousu1;
import guokangjie.news.com.weiying.fragment.frag_sousu2;

/**
 * Created by 郭康杰 on 2017/12/15.
 */

public class VmSearchBean {
    private String info;
    private SearchorActivity context;
    private ImageView img_delete;
    private TextView mTvOperate;

    public VmSearchBean() {
    }

    public VmSearchBean(SearchorActivity context, ImageView img_delete, TextView mTvOperate) {
        this.context = context;
        this.img_delete = img_delete;
        this.mTvOperate = mTvOperate;
        changeFramgnet(new frag_sousu1());
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        if (!TextUtils.isEmpty(info.toString().trim())) {
            img_delete.setVisibility(View.VISIBLE);
            mTvOperate.setText("搜索");
        } else {
            img_delete.setVisibility(View.GONE);
            mTvOperate.setText("取消");
        }
        this.info = info;
    }

    public void deleteinfo() {
        OnsetListener.delete();
    }

    public void Searchorcan() {
        String text = mTvOperate.getText().toString().trim();
        if (text.equals("取消")) {
            context.finish();
        } else {
            frag_sousu2 frag_sousu2 = new frag_sousu2();
            Bundle bundle = new Bundle();
            bundle.putString("info", info.toString().trim());
            frag_sousu2.setArguments(bundle);
            changeFramgnet(frag_sousu2);
        }

    }

    private OnsetListener OnsetListener;

    //接口回调
    public interface OnsetListener {
        void delete();
    }

    public void setListener(OnsetListener onserListener) {
        this.OnsetListener = onserListener;
    }

    //切换
    public void changeFramgnet(Fragment fragment) {
        FragmentManager supportFragmentManager = context.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_search, fragment);
        fragmentTransaction.commit();
    }
}
