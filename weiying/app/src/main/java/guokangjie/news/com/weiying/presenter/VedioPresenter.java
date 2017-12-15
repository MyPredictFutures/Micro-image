package guokangjie.news.com.weiying.presenter;

import android.content.Context;

import guokangjie.news.com.weiying.bean.BaseBean;
import guokangjie.news.com.weiying.bean.PingBean;
import guokangjie.news.com.weiying.bean.VedioBean;
import guokangjie.news.com.weiying.model.VedioModel;
import guokangjie.news.com.weiying.net.OnNetListener;
import guokangjie.news.com.weiying.view.VedioView;

/**
 * Created by 郭康杰 on 2017/11/23.
 */

public class VedioPresenter {
    private Context context;
    private VedioModel vedioModel;
    private VedioView vedioView;

    public VedioPresenter(Context context, VedioView vedioView) {
        this.context = context;
        this.vedioModel = new VedioModel(context);
        this.vedioView = vedioView;
    }

    public VedioPresenter(VedioView vedioView) {
        this.context = (Context) vedioView;
        this.vedioModel = new VedioModel(context);
        this.vedioView = vedioView;
    }

    public void getShow(String url) {
        vedioModel.getPagerInfo(url, new OnNetListener() {
            @Override
            public void setOnNetListener(BaseBean baseBean) {
                vedioView.getVedio((VedioBean) baseBean);
            }
        });
    }

    public void getShowping(String url, String num) {
        vedioModel.getvedioping(url, num, new OnNetListener() {
            @Override
            public void setOnNetListener(BaseBean baseBean) {
                vedioView.getVedio2((PingBean) baseBean);
            }
        });
    }

    public void Mainnull() {
        if (vedioView != null) {
            vedioView = null;
        }
    }
}
