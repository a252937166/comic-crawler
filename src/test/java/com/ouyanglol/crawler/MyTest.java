package com.ouyanglol.crawler;

import com.ouyanglol.crawler.config.mq.MqComicProducer;
import com.ouyanglol.crawler.entity.ComicUrl;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ouyanglol.crawler.model.ComicHome;
import com.ouyanglol.crawler.service.ComicHomeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ouyang
 * @date 18/12/23 15:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private MqComicProducer producer;

    @Autowired
    private ComicHomeService comicHomeService;


    private void getImg(String s) throws IOException {
        String pattern = "var\\s+mhurl\\s*=\\s*\"(.*?)(\";){1}";
        Pattern r = Pattern.compile(pattern);
        String pattern2 = "<a\\s+href=\"(.*?)\"\\s+class=\"pure-button pure-button-primary\">下一页</a>";
        Pattern r2 = Pattern.compile(pattern2);
        Document doc = Jsoup.connect(s).get();
        String orignUrl = doc.getElementById("readurl").attributes().get("content");
        Matcher m = r.matcher(doc.body().toString());
        if (m.find()) {
            String mhurl = m.group(1);
            String mhss = "p1.xiaoshidi.net";
            if (!mhurl.contains("2016") && !mhurl.contains("2017") && !mhurl.contains("2018") && !mhurl.contains("2019")) {
                mhss = "p0.xiaoshidi.net";
            }
            String mhpicurl = "http://"+mhss+"/"+mhurl;
            if (mhurl.contains("http")) {
                mhpicurl = mhurl;
            }
            String fileName = "海贼王"+mhurl.substring(mhurl.lastIndexOf("/")+1);
            ComicUrl comicUrl = new ComicUrl(fileName,mhpicurl);
            System.out.println(fileName+":"+mhpicurl);
            System.out.println("存入队列.....");
            producer.sendMsg(comicUrl);
            Matcher m2 = r2.matcher(doc.body().toString());
            if (m2.find()) {
                String newUrl = orignUrl + m2.group(1);
                getImg(newUrl);
            }
        }
    }


//    /**
//     * 保存文件
//     * */
//    @Test
//    public void saveFile(){
//        FileChannel foChannel;
//        try {
//            foChannel = new FileOutputStream("D://"+"海贼王.jpg").getChannel();
//            foChannel.write(ByteBuffer.wrap(getImgBytes("http://p17.xiaoshidi.net/2017/07/02.png")));
//            foChannel.close();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    @Test
    public void test() {
        String s  = "http://p1.xiaoshidi.net/2017/07/06-07.png";
        s = s.substring(s.lastIndexOf("/")+1);
        System.out.println(s);
    }


    @Test
    public void getAll() throws IOException {
        System.out.println(111111);
        Document doc = Jsoup.connect("https://manhua.fzdm.com/").get();
        Element element = doc.getElementById("mhmain");
        List<Element> list = element.getElementsByTag("a");
        list.forEach(e->{
            if (e.childNode(0) instanceof TextNode) {
                String comicName = e.childNode(0).toString();
                String url = "https://manhua.fzdm.com/"+e.attributes().get("href");
                ComicHome comicHome = new ComicHome();
                comicHome.setName(comicName);
                comicHome.setUrl(url);
                comicHomeService.add(comicHome);
                System.out.println(e.childNode(0).toString()+":https://manhua.fzdm.com/"+e.attributes().get("href"));
            }
        });
        System.out.println(111111111);
    }


    @Test
    public void getChapter() throws IOException {
        Document doc = Jsoup.connect("https://manhua.fzdm.com/88/").get();
        List<Element> list = doc.getElementsByClass("pure-u-1-2 pure-u-lg-1-4");
        Collections.reverse(list);
        list.forEach(e -> {
            Element element = e.child(0);
            System.out.println(element.childNode(0).toString()+":https://manhua.fzdm.com/88/"+element.attributes().get("href"));
            if (list.indexOf(e)==list.size()-1) {
                System.out.println("========================================");
            } else {
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            }
        });
    }
}
