package com.oneway.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;


/**
 * 作者 oneway on 2018/9/7
 * 描述:toast 管理类
 * 参考链接:
 */
public class ToastManager {

    /**
     * ****************** 不带图标 ************************
     */
    /**
     * 显示在底部
     */
    public static void normal(Object msg) {
        showBottom(msg, 0, ToastConfig.NORMAL_COLOR, Toast.LENGTH_SHORT, false).show();
    }

    public static void normalLong(Object msg) {
        showBottom(msg, 0, ToastConfig.NORMAL_COLOR, Toast.LENGTH_LONG, false).show();
    }

    /**
     * 显示在中心
     */
    public static void centerNormal(Object msg) {
        showCenter(msg, 0, ToastConfig.NORMAL_COLOR, Toast.LENGTH_SHORT, false).show();
    }

    public static void centerNormalLong(Object msg) {
        showCenter(msg, 0, ToastConfig.NORMAL_COLOR, Toast.LENGTH_LONG, false).show();
    }


    /**
     * ***************自定义图标的提示信息*****************
     */

    public static void customIcon(Object msg, @DrawableRes int id) {
        showBottom(msg, id, ToastConfig.NORMAL_COLOR, Toast.LENGTH_SHORT, true).show();
    }

    public static void customIconLong(Object msg, @DrawableRes int id) {
        showBottom(msg, id, ToastConfig.NORMAL_COLOR, Toast.LENGTH_LONG, true).show();
    }

    public static void centerCustomIcon(Object msg, @DrawableRes int id) {
        showCenter(msg, id, ToastConfig.NORMAL_COLOR, Toast.LENGTH_SHORT, true).show();
    }

    public static void centerCustomIconLong(Object msg, @DrawableRes int id) {
        showCenter(msg, id, ToastConfig.NORMAL_COLOR, Toast.LENGTH_LONG, true).show();
    }


    /**
     * ****************** 在下面显示 ************************
     */
    /**
     * 成功提示
     *
     * @param msg 显示的文本 String or int
     */
    public static void success(Object msg) {
        showBottom(msg, R.drawable.ic_success_white_48dp, ToastConfig.SUCCESS_COLOR, Toast.LENGTH_SHORT, true).show();
    }

    public static void successLong(Object msg) {
        showBottom(msg, R.drawable.ic_success_white_48dp, ToastConfig.SUCCESS_COLOR, Toast.LENGTH_LONG, true).show();
    }

    /**
     * 失败提示
     *
     * @param msg
     */
    public static void error(Object msg) {
        showBottom(msg, R.drawable.ic_error_white_48dp, ToastConfig.ERROR_COLOR, Toast.LENGTH_SHORT, true).show();
    }

    public static void errorLong(Object msg) {
        showBottom(msg, R.drawable.ic_error_white_48dp, ToastConfig.ERROR_COLOR, Toast.LENGTH_LONG, true).show();
    }

    /**
     * 警告提示信息
     */
    public static void warning(Object msg) {
        showBottom(msg, R.drawable.ic_warn_white_48dp, ToastConfig.WARNING_COLOR, Toast.LENGTH_SHORT, true).show();
    }

    public static void warningLong(Object msg) {
        showBottom(msg, R.drawable.ic_warn_white_48dp, ToastConfig.WARNING_COLOR, Toast.LENGTH_LONG, true).show();
    }


    /**
     * 成功提示信息
     * 显示在中心
     */

    public static void centerSuccess(Object msg) {
        showCenter(msg, R.drawable.ic_success_white_48dp, ToastConfig.SUCCESS_COLOR, Toast.LENGTH_SHORT, true).show();
    }

    public static void centerSuccessLong(Object msg) {
        showCenter(msg, R.drawable.ic_success_white_48dp, ToastConfig.SUCCESS_COLOR, Toast.LENGTH_LONG, true).show();
    }


    /**
     * 错误提示信息
     * 显示在中心
     */
    public static void centerError(Object msg) {
        showCenter(msg, R.drawable.ic_error_white_48dp, ToastConfig.ERROR_COLOR, Toast.LENGTH_SHORT, true).show();
    }

    public static void centerErrorLong(Object msg) {
        showCenter(msg, R.drawable.ic_error_white_48dp, ToastConfig.ERROR_COLOR, Toast.LENGTH_LONG, true).show();
    }

    /**
     * 警告提示信息
     */
    public static void centerWarning(Object msg) {
        showCenter(msg, R.drawable.ic_warn_white_48dp, ToastConfig.WARNING_COLOR, Toast.LENGTH_SHORT, true).show();
    }

    public static void centerWarningLong(Object msg) {
        showCenter(msg, R.drawable.ic_warn_white_48dp, ToastConfig.WARNING_COLOR, Toast.LENGTH_LONG, true).show();
    }

    /**
     * 显示在底部
     */
    @SuppressLint("ShowToast")
    @CheckResult
    public static Toast showBottom(@NonNull Object message, int icon,
                                   @ColorInt int tintColor, int duration,
                                   boolean isShowIcon) {
        checkNotNull(ToastConfig.getContext());
        return custom(ToastConfig.getContext(), message, icon, tintColor, duration, isShowIcon, true, false);
    }

    /**
     * 显示在中间
     */
    @SuppressLint("ShowToast")
    @CheckResult
    public static Toast showCenter(@NonNull Object message, int icon,
                                   @ColorInt int tintColor, int duration,
                                   boolean isShowIcon) {
        checkNotNull(ToastConfig.getContext());
        return custom(ToastConfig.getContext(), message, icon, tintColor, duration, isShowIcon, true, true);
    }

    /**
     * @param context
     * @param message    需要显示的文本
     * @param iconId     图标
     * @param tintColor  背景颜色
     * @param duration   时长
     * @param isShowIcon 是否显示背景图
     * @param shouldTint 是否上色  默认true都上色 如果要使用默认气泡背景则传false
     * @param isCenter   是否显示在中间 true的时候 shouldTint无效
     * @return
     */
    @SuppressLint("ShowToast")
    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull Object message, int iconId,
                               @ColorInt int tintColor, int duration,
                               boolean isShowIcon, boolean shouldTint, boolean isCenter) {

        final Toast currentToast = Toast.makeText(context, "", duration);
        if (isCenter)
            currentToast.setGravity(Gravity.CENTER, 0, 0);
        final View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(isCenter ? R.layout.ww_toast_center_layout : R.layout.ww_toast_layout, null);
        final ImageView toastIcon = toastLayout.findViewById(R.id.toast_icon);
        final TextView toastTextView = toastLayout.findViewById(R.id.toast_text);
        Drawable drawableFrame;
        if (isCenter) {
            drawableFrame = ToastyUtils.getDrawable(context, R.drawable.toast_bg_shape);
        } else {
            if (shouldTint)
                drawableFrame = ToastyUtils.tint9PatchDrawableFrame(context, tintColor);
            else
                drawableFrame = ToastyUtils.getDrawable(context, R.drawable.toast_frame);
        }
        ToastyUtils.setBackground(toastLayout, drawableFrame);

        if (isShowIcon) {
            if (iconId != 0) {
                Drawable icon = ToastyUtils.getDrawable(context, iconId);
                if (ToastConfig.tintIcon)
                    icon = ToastyUtils.tintIcon(icon, ToastConfig.DEFAULT_TEXT_COLOR);
                ToastyUtils.setBackground(toastIcon, icon);
            }
        } else {
            toastIcon.setVisibility(View.GONE);
        }
        if (message instanceof String) {
            toastTextView.setText((String) message);
        } else if (message instanceof Integer) {
            toastTextView.setText(context.getString((Integer) message));
        }
        toastTextView.setTextColor(ToastConfig.DEFAULT_TEXT_COLOR);
        toastTextView.setTypeface(ToastConfig.currentTypeface);
        toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, ToastConfig.textSize);

        currentToast.setView(toastLayout);
        return currentToast;
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException("请在Application里初始化:ToastConfig.getInstance().init(this)");
        } else {
            return reference;
        }
    }
}
