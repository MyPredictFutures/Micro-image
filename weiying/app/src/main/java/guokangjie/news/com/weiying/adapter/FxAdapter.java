package guokangjie.news.com.weiying.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import guokangjie.news.com.weiying.R;
import guokangjie.news.com.weiying.bean.PagerBean;

/**
 * Created by hasee on 2017/12/15.
 */

public class FxAdapter extends RecyclerView.Adapter<FxAdapter.MyViewHolder>{
    private Context context;
    private List<PagerBean.RetBean.ListBean.ChildListBean> childListBeen;

    public FxAdapter(Context context, List<PagerBean.RetBean.ListBean.ChildListBean> childListBeen) {
        this.context = context;
        this.childListBeen = childListBeen;
    }

    IOnclick iOnclick;

    public void setiOnclick(IOnclick iOnclick) {
        this.iOnclick = iOnclick;
    }

    public  interface IOnclick{
        void onclick();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fx,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.tvName.setText(childListBeen.get(position).getTitle());
        if (holder.tvName==null){
            holder.tvName.setText("");
        }
        holder.hua.setText(childListBeen.get(position).getDescription());
        if (holder.hua==null){
            holder.hua.setText("");
        }
        String pic = childListBeen.get(position).getPic();
        holder.iv.setImageURI(Uri.parse(pic));
        if (holder.iv==null){
            holder.iv.setImageURI(Uri.parse(R.mipmap.ic_launcher+""));
        }
        holder.lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(iOnclick!=null){
                        iOnclick.onclick();
                    }
            }
        });
    }



    @Override
    public int getItemCount() {
        return childListBeen.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView iv;
        private final TextView tvName;
        private final TextView hua;
        private final LinearLayout lin;

        public MyViewHolder(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.dis_image_view);
            tvName = itemView.findViewById(R.id.text_head);
            hua = itemView.findViewById(R.id.text_dis);
            lin = itemView.findViewById(R.id.lin);
        }
    }
}
