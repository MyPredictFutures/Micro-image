package guokangjie.news.com.weiying.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.databinding.ActivitySearch2Binding;
import guokangjie.news.com.weiying.vmbean.VmSearchBean;

public class SearchorActivity extends AppCompatActivity {


    private ImageView mImgClear;
    /**
     * @={search.info}
     */
    private EditText mEdtSearch;
    /**
     * 取消
     */
    private TextView mTvOperate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearch2Binding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_search2);
        initView();
        VmSearchBean vmSearchBean = new VmSearchBean(this, mImgClear, mTvOperate);
        viewDataBinding.setSearch(vmSearchBean);
        ButterKnife.bind(this);
        vmSearchBean.setListener(new VmSearchBean.OnsetListener() {
            @Override
            public void delete() {
                mEdtSearch.setText(" ");
                mImgClear.setVisibility(View.GONE);
                mTvOperate.setText("取消");
            }
        });
    }

    private void initView() {
        mImgClear = (ImageView) findViewById(R.id.img_clear);
        mEdtSearch = (EditText) findViewById(R.id.edt_search);
        mTvOperate = (TextView) findViewById(R.id.tv_operate);
    }
}
