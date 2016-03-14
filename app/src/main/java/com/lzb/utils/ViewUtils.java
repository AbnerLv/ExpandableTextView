package com.lzb.utils;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * Created by Abner on 2016/3/14.
 */
public class ViewUtils {
    private static ExpandHandler expandHandler;

    public static void expandTextView(TextView tv) {
        if (expandHandler == null || (expandHandler != null && expandHandler.expand != tv)){
            expandHandler = new ExpandHandler(tv);
        }
        expandHandler.sendEmptyMessage(1);
    }

    static class ExpandHandler extends Handler {

        private TextView expand;
        private int CollapseHeight;
        private int ExpandHeight;
        private int currentHeight;
        private int distance = 10;
        private int timeDelay = 2;
        private boolean isExpand;
        //
        ExpandHandler(TextView tv) {
            expand = tv;
            CollapseHeight = expand.getMeasuredHeight();
            int lines = expand.getLineCount();
            int lineHeight = expand.getLineHeight();
            ExpandHeight = lineHeight * lines;
        }

        @Override
        public void handleMessage(Message msg) {
            currentHeight = expand.getMeasuredHeight();
            if(!isExpand){
                if(currentHeight < ExpandHeight - distance){
                    expand.setHeight(currentHeight+distance);
                    this.sendEmptyMessageDelayed(1,timeDelay);
                }else if(currentHeight <ExpandHeight){
                    expand.setHeight(ExpandHeight);
                    isExpand = !isExpand;
                }
            }else{
                if(currentHeight > ExpandHeight + distance){
                    expand.setHeight(currentHeight - distance);
                    this.sendEmptyMessageDelayed(1,timeDelay);
                }else{
                    expand.setHeight(CollapseHeight);
                    isExpand = !isExpand;
                }
            }
        }
    }
}
