package entity;

import java.text.SimpleDateFormat;

    /**
     * 描述一首歌
     * Created by Lee on 2016/6/20.
     */
    public class Song {
        private static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        private String pic_big;
        private String pic_small;
        private String lrclink;
        private String style;
        private String song_id;
        private String title;
        private String author;
        private String album_title;
        private String artist_name;

        public Song() {
        }

        public Song(String pic_big, String pic_small, String lrclink, String style,
                    String song_id, String title, String author, String album_title,
                    String artist_name) {
            super();
            this.pic_big = pic_big;
            this.pic_small = pic_small;
            this.lrclink = lrclink;
            this.style = style;
            this.song_id = song_id;
            this.title = title;
            this.author = author;
            this.album_title = album_title;
            this.artist_name = artist_name;
        }

        public String getPic_big() {
            return pic_big;
        }

        public void setPic_big(String pic_big) {
            this.pic_big = pic_big;
        }

        public String getPic_small() {
            return pic_small;
        }

        public void setPic_small(String pic_small) {
            this.pic_small = pic_small;
        }

        public String getLrclink() {
            return lrclink;
        }

        public void setLrclink(String lrclink) {
            this.lrclink = lrclink;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getSong_id() {
            return song_id;
        }

        public void setSong_id(String song_id) {
            this.song_id = song_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAlbum_title() {
            return album_title;
        }

        public void setAlbum_title(String album_title) {
            this.album_title = album_title;
        }

        public String getArtist_name() {
            return artist_name;
        }

        public void setArtist_name(String artist_name) {
            this.artist_name = artist_name;
        }

        @Override
        public String toString() {
            return this.title + "   " + this.author;
        }
}
