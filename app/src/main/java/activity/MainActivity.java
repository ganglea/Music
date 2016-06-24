package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cnc.link.music.R;
import fragment.HotMusicListFragment;
import fragment.NewMusicListFragment;

/**
 * Created by Lee on 2016/6/20.
 */
public class MainActivity extends AppCompatActivity {
    //初始化ViewPager
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    //声明Fragment的数据源
    private List<Fragment> fragments;
    //初始化viewPager的适配器
    private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化butterknife
        ButterKnife.bind(this);
        //初始化viewPager
        setViewPager();
    }
    /**
     * 初始化viewPager
     */
    private void setViewPager(){
        //对数据进行初始化
        fragments =new ArrayList<>();
        fragments.add(new NewMusicListFragment());
        fragments.add(new HotMusicListFragment());
        //创建fragment的adapter
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

    /**
     * 为viewPager编写适配器
     */
    class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
