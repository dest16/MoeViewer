package com.destin.moeviewer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String html = "<ul id=\"thumbs2\">\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999048\" tabindex=\"1\" style=\"width: 191px; \"><span>1 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Dazai.Osamu.240.1999048.jpg\"\n" +
                "\talt=\"Dazai Osamu\" title=\"600x760 333kB\"\n" +
                "\tstyle=\"width: 189px; height: 240px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Dazai+Osamu\">Dazai Osamu</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999047\" tabindex=\"1\" style=\"width: 242px; \"><span>1 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Bungou.Stray.Dogs.240.1999047.jpg\"\n" +
                "\talt=\"Bungou Stray Dogs\" title=\"1400x1000 837kB\"\n" +
                "\tstyle=\"width: 240px; height: 171px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Bungou+Stray+Dogs\">Bungou Stray Dogs</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999037\" tabindex=\"1\" style=\"width: 172px; \"><span>1 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Amatsukaze.%28Kantai.Collection%29.240.1999037.jpg\"\n" +
                "\talt=\"Amatsukaze (Kantai Collection)\" title=\"849x1200 977kB\"\n" +
                "\tstyle=\"width: 170px; height: 240px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Amatsukaze+%28Kantai+Collection%29\">Amatsukaze (Kantai Collection)</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999035\" tabindex=\"1\" style=\"width: 242px; \"><span>9 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Bloodborne.240.1999035.jpg\"\n" +
                "\talt=\"Bloodborne\" title=\"1809x1500 1567kB\"\n" +
                "\tstyle=\"width: 240px; height: 199px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Bloodborne\">Bloodborne</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999034\" tabindex=\"1\" style=\"width: 242px; \"><span>4 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Hazuki.Shizuku.240.1999034.jpg\"\n" +
                "\talt=\"Hazuki Shizuku\" title=\"900x800 386kB\"\n" +
                "\tstyle=\"width: 240px; height: 213px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Hazuki+Shizuku\">Hazuki Shizuku</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999033\" tabindex=\"1\" style=\"width: 242px; \"><span>1 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Ahagon.Umiko.240.1999033.jpg\"\n" +
                "\talt=\"Ahagon Umiko\" title=\"900x800 375kB\"\n" +
                "\tstyle=\"width: 240px; height: 213px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Ahagon+Umiko\">Ahagon Umiko</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999032\" tabindex=\"1\" style=\"width: 242px; \"><span>1 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Sakura.Nene.240.1999032.jpg\"\n" +
                "\talt=\"Sakura Nene\" title=\"900x800 374kB\"\n" +
                "\tstyle=\"width: 240px; height: 213px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Sakura+Nene\">Sakura Nene</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999031\" tabindex=\"1\" style=\"width: 242px; \"><span>1 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Iijima.Yun.240.1999031.jpg\"\n" +
                "\talt=\"Iijima Yun\" title=\"900x800 459kB\"\n" +
                "\tstyle=\"width: 240px; height: 213px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Iijima+Yun\">Iijima Yun</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999029\" tabindex=\"1\" style=\"width: 242px; \"><span>2 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Takimoto.Hifumi.240.1999029.jpg\"\n" +
                "\talt=\"Takimoto Hifumi\" title=\"900x800 388kB\"\n" +
                "\tstyle=\"width: 240px; height: 213px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Takimoto+Hifumi\">Takimoto Hifumi</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999028\" tabindex=\"1\" style=\"width: 242px; \"><span>2 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Touyama.Rin.240.1999028.jpg\"\n" +
                "\talt=\"Touyama Rin\" title=\"900x800 340kB\"\n" +
                "\tstyle=\"width: 240px; height: 213px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Touyama+Rin\">Touyama Rin</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999027\" tabindex=\"1\" style=\"width: 242px; \"><span>1 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Yagami.Kou.240.1999027.jpg\"\n" +
                "\talt=\"Yagami Kou\" title=\"900x800 372kB\"\n" +
                "\tstyle=\"width: 240px; height: 213px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Yagami+Kou\">Yagami Kou</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999026\" tabindex=\"1\" style=\"width: 242px; \"><span>5 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Axis.Powers%3A.Hetalia.240.1999026.jpg\"\n" +
                "\talt=\"Axis Powers: Hetalia\" title=\"1885x1320 1768kB\"\n" +
                "\tstyle=\"width: 240px; height: 168px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Axis+Powers%3A+Hetalia\">Axis Powers: Hetalia</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "\n" +
                "<li >\n" +
                "\t<a href=\"/1999025\" tabindex=\"1\" style=\"width: 208px; \"><span>11 Fav</span><img\n" +
                "\tsrc=\"http://s3.zerochan.net/Bulgaria.240.1999025.jpg\"\n" +
                "\talt=\"Bulgaria\" title=\"1200x1400 133kB\"\n" +
                "\tstyle=\"width: 206px; height: 240px; \" /></a>\n" +
                "\t<p>\n" +
                "\t<a href=\"/Bulgaria\">Bulgaria</a>\n" +
                "\t</p>\n" +
                "</li>\n" +
                "</ul>";
        String suggest = "Samonya|Mangaka|\n" +
                "Sha Gojyo|Character|Saiyuki\n" +
                "Special A|Series|Minami Maki\n" +
                "Sa-dui|Mangaka|\n" +
                "Ninja-wolfie|Mangaka|\n" +
                "Sa-co|Mangaka|\n" +
                "SA'yuki|Mangaka|\n" +
                "Sarasa-sasa|Mangaka|\n" +
                "Warino|Mangaka|\n" +
                "Sa Cheri|Mangaka|\n" +
                "Sa-eun|Character|Moon Boy\n" +
                "Sa Za|Mangaka|\n" +
                "Pixiv Id 3606536|Mangaka|\n" +
                "Pixiv Id 3008439|Mangaka|\n" +
                "SA-KI|Character|Wrestle Angels\n" +
                "Sa-do|Mangaka|\n" +
                "Sa Da Ham|Mangaka|\n" +
                "Sa Owari o Hajimeyou|Source|Vocaloid\n" +
                "Sasakama|Mangaka|\n";
        Document doc = Jsoup.parse(html);
        Element item = doc.getElementById("thumbs2").select("li").get(0);
//        System.out.println(Arrays.toString(item.select("a").first().attr("href").split("[x\u0008]")));
        System.out.println(Arrays.toString(suggest.split("\n")[0].split("\\|")));
        assertEquals(4, 2 + 2);
    }
}