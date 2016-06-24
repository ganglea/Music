package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 用于发送http请求的工具类
 * Created by Lee on 2016/6/20.
 */
public class HttpUtils {
    /**
     * HttpURLConnection使用post的方式发送http请求
     * @param uri   请求资源路径
     * @param params 请求参数
     * @return
     * @throws IOException
     */
    public static InputStream postInputStream(String uri, Map<String,String> params) throws IOException {
        //URL
        URL url=new URL(uri);
        //openConnection
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        //设置请求方式
        conn.setRequestMethod("POST");
        //设置post的消息头 开启输入输出流
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        //设置参数
        StringBuilder param=new StringBuilder();
        //先获取Map集合的所有键的Set集合
        Set<String> keySet=params.keySet();
        //有了Set集合，就可以获取其迭代器
        Iterator<String> iterator=keySet.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            //有了键可以通过Map集合的get方法获取其对应的值
            String value = params.get(key);
            param.append(key+"="+value+"&");
        }
        //param: a=b&c=d&
        param.deleteCharAt(param.length()-1);
        //使用输出流传递参数
        OutputStream os=conn.getOutputStream();
        os.write(param.toString().getBytes("utf-8"));
        //输出流的缓冲
        os.flush();
        //获取输入流
        return conn.getInputStream();
    }
    public static InputStream postInputStream1(String uri,Map<String,String> params) throws IOException{
        URL url=new URL(uri);
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);

        // application/x-javascript text/xml->xml数据
        // application/x-javascript->json对象
        // application/x-www-form-urlencoded->表单数据
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        StringBuilder param=new StringBuilder();
        Set<Map.Entry<String, String>> entries = params.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            param.append(key+"="+value+"&");
        }
        if(param.length()>0) {
            param.deleteCharAt(param.length() - 1);
        }
        OutputStream os=conn.getOutputStream();
        os.write(param.toString().getBytes("utf-8"));
        os.flush();
        return conn.getInputStream();
    }

    /**
     * 发送get请求 获取输入流
     * @param path
     * @return
     * @throws IOException
     */
    public static InputStream getInputStream(String path) throws IOException {
        URL url=new URL(path);
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        InputStream is = conn.getInputStream();
        return is;
    }

    /**
     * 发送get请求 获取响应字符串
     * @param uri
     * @return
     * @throws IOException
     */
    public static String getString(String uri) throws IOException {
        //获取输入流
        InputStream is = getInputStream(uri);
        //处理输入流 获取xml文档 将内容转换成字符串
        StringBuilder sb=new StringBuilder();
        String line=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        while((line=br.readLine())!=null){
            sb.append(line);
        }
        return sb.toString();
    }
}
