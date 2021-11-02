package kr.hs.dukyoung.DYApp.jaehoon.utils;

import android.content.Context;

public class LayoutUtils {
    public static int dpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}
