package util;

/**
 * url地址的工厂
 * Created by Lee on 2016/6/16.
 */
public class FactoryUtil {
    /**
     * 获取新歌Url
     * @param offset
     * @param size
     * @return
     */
    public static String getNewMusicListUrl(int offset,int size) {
        return "http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.billboard.billList&format=xml&type=1&offset=" + offset + "&size=" + size;
    }

    /**
     * 获取热歌榜Url
     * @param offset
     * @param size
     * @return
     */
    public static String getHotMusicListUrl(int offset,int size){
        return "http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.billboard.billList&format=xml&type=2&offset="+offset+"&size="+size;
    }
}
