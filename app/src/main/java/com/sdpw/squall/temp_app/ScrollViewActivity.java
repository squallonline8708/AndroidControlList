package com.sdpw.squall.temp_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScrollViewActivity extends AppCompatActivity {

    private TextView tvTile;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        TextView tvTile = (TextView) findViewById(R.id.tv_title);
        tvTile.setTextSize(40);
        tvTile.setText("文章标题：。。。");
        TextView tv = (TextView) findViewById(R.id.tv_content);
        tv.setTextSize(30);
        CharSequence text = "锅盔的原材料都是庄稼人自家酿种的。"
                + "\n" + "面粉是自家地里种的小麦磨成的；"
                + "\n" + "是自家饲养的鸡产的；香豆子，" + "\n"
                + "是自家地埂上撒出来的。这些材料，" + "\n"
                +  "也是靠老天的眷顾，才有的。山区，" + "\n"
                + "就是靠天吃饭。万一哪一年，" + "\n"
                + "老天一生气不下雨，山就荒了，" + "\n"
                + "地也荒了，人也慌了，" + "\n"
                + "妈妈的锅盔也会瘪了。" + "\n"
                + "妈妈经过泡发面、和面、醒面等几道程序，" + "\n"
                + "把这些材料依次揉进面里，" + "\n"
                + "再切成碗口大的面团，揉成馒头，再用擀杖稍稍一擀，"
                + "\n"
                + "或用手掌稍稍一按，就成了一寸多高、盘子大小的圆饼。"
                + "\n" + "灵巧、细心、唯美的妈妈总不忘在饼上面"
                + "\n" + "用菜刀画出美丽对称的图案：三角形、四边形、菱形等等。" + "\n"
                + "妈妈的爱，就在那揉、擀、按、画的过程中，" + "\n"
                + "一点一点渗进锅盔里，流进我的血脉里。弄好的锅";
        tv.setText(text);

    }
}
