package guokangjie.news.com.weiying.net;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 郭康杰 on 2017/11/3.
 */

public class RetrofitUtils {
    private Context context;
    private static Retrofit retrofit;
    private static RetrofitUtils retrofitUtils;
    private static OkHttpClient okHttpClient;

    public RetrofitUtils(Context context) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                if (Api.MYMEASUREMENT){
                    Log.e("HTTPLOGGING--TAG", message);
                }
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                .connectTimeout(5000, TimeUnit.SECONDS)
                .build();
        this.context = context;
    }

    public static RetrofitUtils getInstance(Context context) {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils(context);
                }
            }
        }
        return retrofitUtils;
    }

    public static synchronized Retrofit getRetrofit(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(url)
                    .build();
        }
        return retrofit;
    }

    public <T> T getApiService(String url, Class<T> clazz) {
        Retrofit retrofits = getRetrofit(url);
        return retrofits.create(clazz);
    }

}
