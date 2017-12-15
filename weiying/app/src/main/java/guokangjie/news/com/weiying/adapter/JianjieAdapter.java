package guokangjie.news.com.weiying.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.activity.VedioActivity;
import guokangjie.news.com.weiying.bean.VedioBean;

/**
 * Created by cll on 2017/11/24.
 */

public class JianjieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<VedioBean.RetBean.ListBean.ChildListBean> list;
    private String dataId;

    public JianjieAdapter(Context context, List<VedioBean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shouitem, parent, false);

        return new MyAa(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyAa myAa = (MyAa) holder;
        myAa.dym.setText(list.get(position).getTitle());
        String pic = list.get(position).getPic();
        Uri parse = Uri.parse(pic);
        myAa.sd.setImageURI(parse);
        myAa.sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataId = list.get(position).getDataId();
                Intent intent = new Intent(context, VedioActivity.class);
                intent.putExtra("url", dataId);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyAa extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sd;
        private final TextView dym;

        public MyAa(View itemView) {
            super(itemView);
            sd = itemView.findViewById(R.id.imagename);
            dym = itemView.findViewById(R.id.dym);

        }
    }
}
