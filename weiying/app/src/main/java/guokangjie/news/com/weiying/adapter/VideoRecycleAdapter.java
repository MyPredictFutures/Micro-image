package guokangjie.news.com.weiying.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.bean.PagerBean;
import guokangjie.news.com.weiying.event.MessageNumEvent;

/**
 * Created by 郭康杰 on 2017/11/7.
 */

public class VideoRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<PagerBean.RetBean.ListBean.ChildListBean> list;

    public VideoRecycleAdapter(Context context, List<PagerBean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new MyPhoneHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyPhoneHolder myPhoneHolder = (MyPhoneHolder) holder;
        myPhoneHolder.sd_img.setImageURI(list.get(position).getPic());
        myPhoneHolder.tv_title.setText(list.get(position).getTitle());
        myPhoneHolder.ll_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageNumEvent messageNumEvent = new MessageNumEvent(list.get(position).getDataId());
                EventBus.getDefault().post(messageNumEvent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyPhoneHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_item;
        private SimpleDraweeView sd_img;
        private TextView tv_title;

        public MyPhoneHolder(View itemView) {
            super(itemView);
            ll_item = itemView.findViewById(R.id.ll_item);
            sd_img = itemView.findViewById(R.id.sd_img);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

}
