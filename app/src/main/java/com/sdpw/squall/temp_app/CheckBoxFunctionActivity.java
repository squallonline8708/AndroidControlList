package com.sdpw.squall.temp_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxFunctionActivity extends AppCompatActivity {

    private CheckBox cbCheckAll;
    private CheckBox cbGame;
    private CheckBox cbMusic;
    private CheckBox cbCoding;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_function);

        cbCheckAll = (CheckBox) findViewById(R.id.cb_check_all);
        cbGame = (CheckBox) findViewById(R.id.cb_game);
        cbMusic = (CheckBox) findViewById(R.id.cb_music);
        cbCoding = (CheckBox) findViewById(R.id.cb_coding);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 被提示的结果
                String result = "";
                // 获取第1个CheckBox的勾选状态
                if (cbGame.isChecked()) {
                    result += cbGame.getText() + ", ";
                }
                // 获取第2个CheckBox的勾选状态
                if (cbMusic.isChecked()) {
                    result += cbMusic.getText() + ", ";
                }
                // 获取第3个CheckBox的勾选状态
                if (cbCoding.isChecked()) {
                    result += cbCoding.getText() + ", ";
                }
                if ("".equals(result)) {
                    Toast.makeText(CheckBoxFunctionActivity.this, "请至少勾选1个选项！", Toast.LENGTH_SHORT).show();
                } else {
                    result = result.trim();
                    result = result.substring(0, result.length() - 1);
                    Toast.makeText(CheckBoxFunctionActivity.this, result, Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbCheckAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbGame.setChecked(isChecked);
                cbMusic.setChecked(isChecked);
                cbCoding.setChecked(isChecked);
            }
        });
    }
}
