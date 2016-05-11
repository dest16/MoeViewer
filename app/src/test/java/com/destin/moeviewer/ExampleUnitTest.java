package com.destin.moeviewer;

import org.jsoup.Jsoup;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String html = "<ul class=\"scans\">\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697266\"\n" +
                "\tstyle=\"width: 182px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/16/45/697266.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Macross Delta\" title=\"5916x4080\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Macross+Delta\">Macross Delta</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697265\"\n" +
                "\tstyle=\"width: 126px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/15/45/697265.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Bishoujo Senshi Sailor Moon\" title=\"4077x5928\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Bishoujo+Senshi+Sailor+Moon\">Bishoujo Senshi Sailor Moon</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697264\"\n" +
                "\tstyle=\"width: 182px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/14/45/697264.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"GIRLS und PANZER\" title=\"6110x4081\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/GIRLS+und+PANZER\">GIRLS und PANZER</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697263\"\n" +
                "\tstyle=\"width: 132px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/13/45/697263.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Ryohka\" title=\"4882x6734\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Ryohka\">Ryohka</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697262\"\n" +
                "\tstyle=\"width: 182px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/12/45/697262.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Macross Delta\" title=\"2862x2833\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Macross+Delta\">Macross Delta</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697260\"\n" +
                "\tstyle=\"width: 130px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/10/45/697260.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Konomi Kino\" title=\"4787x6722\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Konomi+Kino\">Konomi Kino</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697259\"\n" +
                "\tstyle=\"width: 182px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/09/45/697259.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Tsujidou-san no Junai Road\" title=\"1920x1080\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Tsujidou-san+no+Junai+Road\">Tsujidou-san no Junai Road</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697258\"\n" +
                "\tstyle=\"width: 182px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/08/45/697258.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Tsujidou-san no Junai Road\" title=\"1920x1080\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Tsujidou-san+no+Junai+Road\">Tsujidou-san no Junai Road</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697257\"\n" +
                "\tstyle=\"width: 131px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/07/45/697257.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Konomi Kino\" title=\"4801x6724\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Konomi+Kino\">Konomi Kino</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697256\"\n" +
                "\tstyle=\"width: 136px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/06/45/697256.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Kurone Mishima\" title=\"4356x5838\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Kurone+Mishima\">Kurone Mishima</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697255\"\n" +
                "\tstyle=\"width: 128px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/05/45/697255.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Ryohka\" title=\"4573x6522\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Ryohka\">Ryohka</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697254\"\n" +
                "\tstyle=\"width: 125px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/04/45/697254.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Kamisama Hajimemashita\" title=\"2062x3023\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Kamisama+Hajimemashita\">Kamisama Hajimemashita</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697252\"\n" +
                "\tstyle=\"width: 126px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/02/45/697252.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Hiroyuki Maeda\" title=\"4416x6390\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Hiroyuki+Maeda\">Hiroyuki Maeda</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697251\"\n" +
                "\tstyle=\"width: 125px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/01/45/697251.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Hiroyuki Maeda\" title=\"4981x7264\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Hiroyuki+Maeda\">Hiroyuki Maeda</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697250\"\n" +
                "\tstyle=\"width: 126px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/00/45/697250.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Hiroyuki Maeda\" title=\"4957x7192\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Hiroyuki+Maeda\">Hiroyuki Maeda</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697249\"\n" +
                "\tstyle=\"width: 120px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/49/44/697249.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Hiroyuki Maeda\" title=\"4796x7319\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Hiroyuki+Maeda\">Hiroyuki Maeda</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697248\"\n" +
                "\tstyle=\"width: 128px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/48/44/697248.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Hiroyuki Maeda\" title=\"4964x7091\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Hiroyuki+Maeda\">Hiroyuki Maeda</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697247\"\n" +
                "\tstyle=\"width: 132px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/47/44/697247.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Yan-yam\" title=\"3642x5062\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Yan-yam\">Yan-yam</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697246\"\n" +
                "\tstyle=\"width: 128px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/46/44/697246.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Linda (Mangaka)\" title=\"3011x4308\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Linda+%28Mangaka%29\">Linda (Mangaka)</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697245\"\n" +
                "\tstyle=\"width: 128px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/45/44/697245.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Linda (Mangaka)\" title=\"3011x4304\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Linda+%28Mangaka%29\">Linda (Mangaka)</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697244\"\n" +
                "\tstyle=\"width: 182px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/44/44/697244.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Shibamoto Thores\" title=\"5000x4034\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Shibamoto+Thores\">Shibamoto Thores</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697243\"\n" +
                "\tstyle=\"width: 114px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/43/44/697243.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Shibamoto Thores\" title=\"2500x4007\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Shibamoto+Thores\">Shibamoto Thores</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697242\"\n" +
                "\tstyle=\"width: 124px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/42/44/697242.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Shibamoto Thores\" title=\"2400x3539\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Shibamoto+Thores\">Shibamoto Thores</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "<li\n" +
                "><a href=\"http://gallery.minitokyo.net/view/697241\"\n" +
                "\tstyle=\"width: 122px; \" tabindex=\"1\"><img\n" +
                "\tsrc=\"http://static3.minitokyo.net/thumbs/41/44/697241.jpg\"\n" +
                "\tstyle=\"\n" +
                "\tborder: 1px solid #000;\n" +
                "\t\"\n" +
                "\talt=\"Shibamoto Thores\" title=\"2300x3461\" /></a>\n" +
                "\t<p><a href=\"http://www.minitokyo.net/Shibamoto+Thores\">Shibamoto Thores</a>\n" +
                "</p>\n" +
                "</li>\n" +
                "</ul>\n";
        String rs = Jsoup.connect("http://www.minitokyo.net/Sword+Art+Online").get().getElementById("tabs").select("li a[href]").get(1).attr("href");
        getTid("Sword+Art+Online", rs);
        assertEquals(4, 2 + 2);
    }

    String getTid(String tag, String s) {
        String tid = s.substring(s.indexOf("tid=") + 4, s.indexOf("&amp;"));
        return tid;
    }
}