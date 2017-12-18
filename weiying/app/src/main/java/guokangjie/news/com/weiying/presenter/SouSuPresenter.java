package guokangjie.news.com.weiying.presenter;

import android.content.Context;

import guokangjie.news.com.weiying.bean.BaseBean;
import guokangjie.news.com.weiying.bean.SouSuoBean;
import guokangjie.news.com.weiying.model.SouSuModel;
import guokangjie.news.com.weiying.net.OnNetListener;
import guokangjie.news.com.weiying.view.SouSuView;

/**
 * Created by 郭康杰 on 2017/11/23.
 */

public class SouSuPresenter {
    private Context context;
    private SouSuModel vedioModel;
    private SouSuView vedioView;

    public SouSuPresenter(Context context, SouSuView vedioView) {
        this.context = context;
        this.vedioModel = new SouSuModel(context);
        this.vedioView = vedioView;
    }



    public void getShowall(String url, String num) {
        vedioModel.getSouSuoInfo(url, num, new OnNetListener() {
            @Override
            public void setOnNetListener(BaseBean baseBean) {
                vedioView.getSouSu((SouSuoBean) baseBean);
            }
        });
    }

    public void Mainnull() {
        if (vedioView != null) {
            vedioView = null;
        }
    }
}
