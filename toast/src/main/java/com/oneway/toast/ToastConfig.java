package com.oneway.toast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import androidx.annotation.ColorInt;

/**
 * 作者 oneway on 2018/11/20
 * 描述:
 * 参考链接:
 */
public class ToastConfig {
    private static Context mContext;
    @ColorInt //默认文字白色
    public static int DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
    @ColorInt //默认黑色
    public static int INFO_COLOR = Color.parseColor("#C0000000");
    @ColorInt//默认黑色
    public static int SUCCESS_COLOR = Color.parseColor("#C0000000");
    @ColorInt //默认黑色
    public static int ERROR_COLOR = Color.parseColor("#C0000000");
    @ColorInt//默认黑色
    public static int WARNING_COLOR = Color.parseColor("#C0000000");
    @ColorInt//默认黑色
    public static int NORMAL_COLOR = Color.parseColor("#C0000000");
    //默认文字大小
    public static int textSize = 14; // in SP
    public static final Typeface LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
    public static Typeface currentTypeface = LOADED_TOAST_TYPEFACE;
    public static boolean tintIcon = true;

    public static Context getContext() {
        return mContext;
    }

    public static void init(Builder builder) {
        mContext = builder.mContext;
        DEFAULT_TEXT_COLOR = builder.DEFAULT_TEXT_COLOR;
        SUCCESS_COLOR = builder.SUCCESS_COLOR;
        ERROR_COLOR = builder.ERROR_COLOR;
        WARNING_COLOR = builder.WARNING_COLOR;
        NORMAL_COLOR = builder.NORMAL_COLOR;
        textSize = builder.textSize;
        currentTypeface = builder.currentTypeface;
        tintIcon = builder.tintIcon;
    }

    public static final class Builder {
        @ColorInt //默认文字白色
        public int DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
        @ColorInt//默认黑色
        public int SUCCESS_COLOR = Color.parseColor("#C0000000");
        @ColorInt //默认黑色
        public int ERROR_COLOR = Color.parseColor("#C0000000");
        @ColorInt//默认黑色
        public int WARNING_COLOR = Color.parseColor("#C0000000");
        @ColorInt//默认黑色
        public int NORMAL_COLOR = Color.parseColor("#C0000000");
        //默认文字大小
        public int textSize = 14; // in SP
        public final Typeface LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
        public Typeface currentTypeface = LOADED_TOAST_TYPEFACE;
        public boolean tintIcon = true;
        public Context mContext;

        private Builder(Context context) {
            this.mContext = context;
        }


        public Builder setDefaultTextColor(@ColorInt int DEFAULT_TEXT_COLOR) {
            this.DEFAULT_TEXT_COLOR = DEFAULT_TEXT_COLOR;
            return this;
        }

        public Builder setSuccessColor(@ColorInt int SUCCESS_COLOR) {
            this.SUCCESS_COLOR = SUCCESS_COLOR;
            return this;
        }

        public Builder setErrorColor(@ColorInt int ERROR_COLOR) {
            this.ERROR_COLOR = ERROR_COLOR;
            return this;
        }

        public Builder setWarningColor(@ColorInt int WARNING_COLOR) {
            this.WARNING_COLOR = WARNING_COLOR;
            return this;
        }

        public Builder setNormalColor(@ColorInt int NORMAL_COLOR) {
            this.NORMAL_COLOR = NORMAL_COLOR;
            return this;
        }

        public Builder setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder setCurrentTypeface(Typeface currentTypeface) {
            this.currentTypeface = currentTypeface;
            return this;
        }

        /**
         * @param tintIcon 默认true  图片和文字同色, false 图片原色
         */
        public Builder setTintIcon(boolean tintIcon) {
            this.tintIcon = tintIcon;
            return this;
        }

        public void build() {
            ToastConfig.init(this);
        }
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }
}
