package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cnc.link.music.R;

/**
 * Created by Lee on 2016/6/20.
 */
public class NewMusicListFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建view对象,并返回类似BaseAdater中的getView()
        View view=inflater.inflate(R.layout.fragment_music_list,null);
        return view;
    }
}
