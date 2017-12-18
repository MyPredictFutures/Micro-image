package guokangjie.news.com.weiying.model;

import android.content.Context;

import guokangjie.news.com.weiying.bean.SouSuoBean;
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

public class SouSuModel {
    private Context context;

    public SouSuModel(Context context) {
        this.context = context;
    }

    public void getSouSuoInfo(String url, String num, final OnNetListener onNetListener) {
        Observable<SouSuoBean> observable = RetrofitUtils.getInstance(context).getApiService(Api.HOST, ApiService.class).getSouSu(url, num);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SouSuoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SouSuoBean souSuoBean) {
                        onNetListener.setOnNetListener(souSuoBean);
                    }
                });
    }
}
