package com.keyboard.test;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.keyboard.monitor.KeyboardHelper;
import com.keyboard.monitor.OnKeyboardListener;

public class MainActivity extends AppCompatActivity {
    private TextView tvPan;
    private EditText etInput;
    private Button btAdd;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        DebugBox.init(getApplication());
//        DebugBox.get().open();

        KeyboardHelper.registerKeyboardListener(getWindow(), new OnKeyboardListener() {
            @Override
            public void onKeyBoardEvent(boolean isShow, int height) {
                if (isShow) {
                    tvPan.setVisibility(View.GONE);
                } else {
                    if (height > 0) {
                        tvPan.setText("键盘高度为:" + height);
                        tvPan.getLayoutParams().height = height;
                        tvPan.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this,TwoActivity.class));
        initView();
//        Resources system = Resources.getSystem();
//        TypedValue.applyDimension();
        Log.e("noah",getResources().getDisplayMetrics().toString());
    }

    private void initView() {
        tvPan = findViewById(R.id.tv_pan);
        etInput = findViewById(R.id.et_input);
        btAdd = findViewById(R.id.bt_add);
        layout = findViewById(R.id.layout);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TextView view = new TextView(MainActivity.this);
//                view.setText("哈哈");
//                view.setGravity(View.TEXT_ALIGNMENT_CENTER);
//                view.setTextColor(Color.BLACK);
//                layout.addView(view);
                new AlertDialog.Builder(MainActivity.this).setView(R.layout.layout_input_alert_view).create().show();
            }
        });
    }
}