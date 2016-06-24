package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cnc.link.music.R;
import entity.Song;
import util.ImageLoader;

/**
 * Created by Lee on 2016/6/20.
 */
public class MusicAdapter extends BaseAdapter{
    private Context context;
    private List<Song> songs;
    private LayoutInflater inflater;
    private ImageLoader imageLoader;

    public MusicAdapter(Context context, List<Song> songs, ListView listView) {
        this.context = context;
        this.songs = songs;
        this.inflater = LayoutInflater.from(context);
        this.imageLoader = new ImageLoader(context,listView);
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Song getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(songs.get(position).getSong_id());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.item_lv_music,null);
            holder=new ViewHolder();
            holder.ivAlbum= (ImageView) convertView.findViewById(R.id.ivAlbum);
            holder.tvName= (TextView) convertView.findViewById(R.id.tvName);
            holder.tvSinger= (TextView) convertView.findViewById(R.id.tvSinger);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        Song song=getItem(position);
        holder.tvName.setText(song.getTitle());
        holder.tvSinger.setText(song.getArtist_name());
        //调ImageLoader对象的方法 异步设置bitmap
        imageLoader.displayImage(holder.ivAlbum,song.getPic_small());
        return convertView;
    }
    class ViewHolder{
        ImageView ivAlbum;
        TextView tvName;
        TextView tvSinger;
    }

    /**
     * 停止工作线程
     */
    public void stopThread(){
        imageLoader.stopThread();
    }
}
