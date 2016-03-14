package com.lzb.expandabletextview;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lzb.utils.ViewUtils;

public class MainActivity extends Activity {

    private String text = "fuck0\nfuck1\nfuck2\nfuck3\njehrkjwerhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
    private String text2 = "fuck0";
    private TextView expandTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandTextView = (TextView)findViewById(R.id.hello);
        expandTextView.setText(text2);
        expandTextView.setMaxLines(3);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtils.expandTextView(expandTextView);
            }
        });
    }
}
