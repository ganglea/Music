package app;

import android.app.Application;

import java.util.List;

import entity.Song;

/**
 * 启动应用时创建对象
 * Created by Lee on 2016/6/20.
 */
public class MusicApplication extends Application{
    private List<Song> songList;
    private int position;
    private static MusicApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public static MusicApplication getApp() {
        return app;
    }
}
