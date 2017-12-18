package guokangjie.news.com.weiying.net;

import guokangjie.news.com.weiying.bean.PagerBean;
import guokangjie.news.com.weiying.bean.PingBean;
import guokangjie.news.com.weiying.bean.SouSuoBean;
import guokangjie.news.com.weiying.bean.VedioBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 郭康杰 on 2017/11/3.
 */

public interface ApiService {

    //展示首页数据
    @GET("homePageApi/homePage.do")
    Observable<PagerBean> getPager();

    //展示影片详情数据
    @POST("videoDetailApi/videoDetail.do")
    @FormUrlEncoded
    Observable<VedioBean> getVedioInfo(@Field("mediaId") String mediaId);

    //展示影片详情数据
    @POST("Commentary/getCommentList.do")
    @FormUrlEncoded
    Observable<PingBean> getpinglun(@Field("mediaId") String mediaId, @Field("pnum") String pnum);

    //搜素影片详情数据
    @POST("searchKeyWordApi/getVideoListByKeyWord.do")
    @FormUrlEncoded
    Observable<SouSuoBean> getSouSu(@Field("keyword") String keyword, @Field("pnum") String pnum);

}
