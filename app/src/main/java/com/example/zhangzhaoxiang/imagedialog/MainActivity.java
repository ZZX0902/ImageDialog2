package com.example.zhangzhaoxiang.imagedialog;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


/**
 *程序功能：Dialog显示图片
 */
public class MainActivity extends Activity {

    Dialog dia;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dia.show();
            }
        });

        Context context = MainActivity.this;
        dia = new Dialog(context, R.style.edit_AlertDialog_style);
        dia.setContentView(R.layout.dialog);
        ImageView imageView = (ImageView) dia.findViewById(R.id.ok);
        //选择true的话点击其他地方可以使dialog消失，为false的话不会消失
        dia.setCanceledOnTouchOutside(true); // Sets whether this dialog is
        Window w = dia.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.x = 0;
        lp.y = 40;
        dia.onWindowAttributesChanged(lp);
        imageView.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dia.dismiss();
                    }
                });
    }

}