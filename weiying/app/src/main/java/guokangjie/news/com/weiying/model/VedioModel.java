package guokangjie.news.com.weiying.model;

import android.content.Context;

import guokangjie.news.com.weiying.bean.PingBean;
import guokangjie.news.com.weiying.bean.VedioBean;
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

public class VedioModel {
    private Context context;

    public VedioModel(Context context) {
        this.context = context;
    }

    public void getPagerInfo(String url,final OnNetListener onNetListener) {
        Observable<VedioBean> observable = RetrofitUtils.getInstance(context).getApiService(Api.HOST, ApiService.class).getVedioInfo(url);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VedioBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(VedioBean vedioBean) {
                        onNetListener.setOnNetListener(vedioBean);
                    }
                });
    }

    public void getvedioping(String url,String num,final OnNetListener onNetListener) {
        Observable<PingBean> observable = RetrofitUtils.getInstance(context).getApiService(Api.HOST, ApiService.class).getpinglun(url,num);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PingBean pingBean) {
                        onNetListener.setOnNetListener(pingBean);
                    }
                });
    }
}
