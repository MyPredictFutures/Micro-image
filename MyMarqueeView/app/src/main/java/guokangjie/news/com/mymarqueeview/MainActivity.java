package guokangjie.news.com.mymarqueeview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import guokangjie.news.com.mymarqueeview.adapter.FragmentPagerItemAdapter;
import guokangjie.news.com.mymarqueeview.fragment.TabFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter.Builder(this, getSupportFragmentManager())
                .add("TAB1", new TabFragment())
                .add("TAB2", new TabFragment())
                .add("TAB3", new TabFragment())
                .add("TAB4", new TabFragment())
                .build();
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        mTabLayout.setupWithViewPager(viewPager);
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

}
