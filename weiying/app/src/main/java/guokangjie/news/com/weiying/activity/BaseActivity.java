package guokangjie.news.com.weiying.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;

/**
 * Created by 郭康杰 on 2017/12/15.
 */

public class BaseActivity extends AppCompatActivity {
    private LinkedList<Activity> linkedList = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
