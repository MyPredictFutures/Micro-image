package guokangjie.news.com.weiying.view;

import android.net.Uri;

import java.util.List;

import guokangjie.news.com.weiying.bean.PagerBean;

/**
 * Created by hasee on 2017/12/15.
 */

public interface ViewInterFx {
        void  getView(List<PagerBean.RetBean.ListBean.ChildListBean> beanList);
        void getUri(Uri uri);
}
