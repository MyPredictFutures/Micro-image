package guokangjie.news.com.weiying.presenter;

import android.content.Context;

import guokangjie.news.com.weiying.bean.BaseBean;
import guokangjie.news.com.weiying.bean.PagerBean;
import guokangjie.news.com.weiying.model.MainModel;
import guokangjie.news.com.weiying.net.OnNetListener;
import guokangjie.news.com.weiying.view.MainView;

/**
 * Created by 郭康杰 on 2017/11/23.
 */

public class MainPresenter {
    private Context context;
    private MainModel mainModel;
    private MainView mainView;

    public MainPresenter(Context context, MainView mainView) {
        this.context = context;
        this.mainModel = new MainModel(context);
        this.mainView = mainView;
    }

    public void getShow() {
        mainModel.getPagerInfo(new OnNetListener() {
            @Override
            public void setOnNetListener(BaseBean baseBean) {
                mainView.ShowPgInfo((PagerBean) baseBean);
            }
        });
    }

    public void Mainnull() {
        if (mainView != null) {
            mainView = null;
        }
    }
}
