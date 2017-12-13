package guokangjie.news.com.weiying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import guokangjie.news.com.weiying.R;

/**
 * Created by 郭康杰 on 2017/11/20.
 */

public class fragment_presonal extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_presonal, container, false);
        return view;
    }
}
