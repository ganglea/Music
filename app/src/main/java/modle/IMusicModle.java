package modle;

import java.util.List;

import entity.Song;

/**
 * Created by Lee on 2016/6/21.
 */
public interface IMusicModle {
    public interface Callback{
        /**
         * 音乐列表加载完毕后需要执行
         * @param songs
         */
        void onMusicListLoaded(List<Song> songs);
    }
}
