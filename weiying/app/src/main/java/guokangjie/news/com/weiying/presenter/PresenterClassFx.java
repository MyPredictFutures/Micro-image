package guokangjie.news.com.weiying.presenter;

import android.net.Uri;

import java.util.List;

import guokangjie.news.com.weiying.bean.PagerBean;
import guokangjie.news.com.weiying.model.InterFx;
import guokangjie.news.com.weiying.model.ModelClassFx;
import guokangjie.news.com.weiying.model.ModelInterFx;
import guokangjie.news.com.weiying.view.ViewInterFx;

/**
 * Created by hasee on 2017/12/15.
 */

public class PresenterClassFx implements PresenterInterFx{
    ModelInterFx modelInter;
    ViewInterFx viewInter;

    public PresenterClassFx(ViewInterFx viewInter) {
        this.viewInter = viewInter;
        modelInter = new ModelClassFx(viewInter);
    }



    @Override
    public void getPresen(final int index) {
        modelInter.getData(new InterFx() {
            @Override
            public void getInter(PagerBean firstBean, Uri uri) {
                List<PagerBean.RetBean.ListBean.ChildListBean> childList = firstBean.getRet().getList().get(index).getChildList();
                viewInter.getView(childList);
                viewInter.getUri(uri);
            }
        });
    }
}
