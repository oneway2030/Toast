package com.oneway.sample

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.oneway.toast.ToastConfig
import com.oneway.toast.ToastManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化 Toast
        ToastConfig.builder(this)
                .setTextSize(12)
                .setDefaultTextColor(Color.WHITE)
                .setSuccessColor(Color.GREEN)
                .setErrorColor(Color.RED)
                .setWarningColor(Color.BLUE)
                .setTintIcon(true)//是否图标与文字同色
                .build()
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn1 -> {//
                ToastManager.normal("普通Toast")
            }
            R.id.btn2 -> {//
                ToastManager.warning("警告Toast")
            }
            R.id.btn3 -> {//
                ToastManager.success("成功Toast")
            }
            R.id.btn4 -> {//
                ToastManager.error("错误Toast")
            }
            R.id.btn5 -> {//
                ToastManager.centerNormal("显示在中,普通Toast,不带图标")
            }
            R.id.btn6 -> {//
                ToastManager.centerWarning("显示在中,警告Toast")
            }
            R.id.btn7 -> {//
                ToastManager.centerSuccess("显示在中,成功Toast")
            }
            R.id.btn8 -> {//
                ToastManager.centerError("显示在中,错误Toast")
            }
        }
    }
}

