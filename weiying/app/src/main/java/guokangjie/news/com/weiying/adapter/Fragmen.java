package guokangjie.news.com.weiying.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import guokangjie.news.com.weiying.fragment.jianjieFragment;
import guokangjie.news.com.weiying.fragment.PingFragment;


/**
 * Created by cll on 2017/11/23.
 */

public class Fragmen extends FragmentPagerAdapter {

    public Fragmen(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new jianjieFragment();
                break;
            case 1:
                fragment=new PingFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
