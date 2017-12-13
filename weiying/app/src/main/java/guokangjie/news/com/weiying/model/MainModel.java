package guokangjie.news.com.weiying.model;

import android.content.Context;

import guokangjie.news.com.weiying.bean.PagerBean;
import guokangjie.news.com.weiying.net.Api;
import guokangjie.news.com.weiying.net.ApiService;
import guokangjie.news.com.weiying.net.OnNetListener;
import guokangjie.news.com.weiying.net.RetrofitUtils;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 郭康杰 on 2017/11/23.
 */

public class MainModel {
    private Context context;

    public MainModel(Context context) {
        this.context = context;
    }

    public void getPagerInfo(final OnNetListener onNetListener) {
        Observable<PagerBean> observable = RetrofitUtils.getInstance(context).getApiService(Api.HOST, ApiService.class).getPager();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PagerBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PagerBean pagerBean) {
                        onNetListener.setOnNetListener(pagerBean);
                    }
                });
    }
}
