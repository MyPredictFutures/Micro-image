package guokangjie.news.com.weiying.model;

import android.net.Uri;

import java.util.List;

import guokangjie.news.com.weiying.bean.PagerBean;
import guokangjie.news.com.weiying.net.ApiService;
import guokangjie.news.com.weiying.view.ViewInterFx;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hasee on 2017/12/15.
 */

public class ModelClassFx implements ModelInterFx{

    ViewInterFx viewInter;

    public ModelClassFx(ViewInterFx viewInter) {
        this.viewInter = viewInter;
    }

    @Override
    public void getData(final InterFx inter) {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://api.svipmovie.com/front/homePageApi/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiService gitService = retrofit.create(ApiService.class);
        Observable<PagerBean> jsonData = gitService.getJson();
        jsonData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PagerBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PagerBean firstBean) {
                        List<PagerBean.RetBean.ListBean.ChildListBean> childList = firstBean.getRet().getList().get(0).getChildList();
                        String pic = childList.get(0).getPic();
                        Uri uri = Uri.parse(pic);
                        inter.getInter(firstBean,uri);
                        for (int i = 0;i<childList.size();i++){
                            PagerBean.RetBean.ListBean.ChildListBean childListBean = childList.get(i);
                            viewInter.getView((List<PagerBean.RetBean.ListBean.ChildListBean>) childListBean);
                            String title = childListBean.getTitle();
                            String pic1 = childListBean.getPic();
                        }
                    }
                });

    }
}
