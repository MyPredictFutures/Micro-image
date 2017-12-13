package guokangjie.news.com.weiying.app;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.youth.banner.loader.ImageLoader;

import guokangjie.news.com.weiying.R;

/**
 * Created by 郭康杰 on 2017/11/6.
 */

public class FrescoImage extends ImageLoader {


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_launcher)  //设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .build();
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage((String) path, imageView, options);

    }
}
