package com.sdpw.squall.temp_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioButtonFunctionActivity extends Activity  {

    private RadioButton rbTabItemMsg;
    private RadioButton rbTabItemContact;
    private RadioButton rbTabItemFind;
    private RadioButton rbTabItemMy;
    private RadioGroup rgTabMenu;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_function);

        rbTabItemMsg = (RadioButton) findViewById(R.id.rb_tab_item_msg);
        rbTabItemContact = (RadioButton) findViewById(R.id.rb_tab_item_contact);
        rbTabItemFind = (RadioButton) findViewById(R.id.rb_tab_item_find);
        rbTabItemMy = (RadioButton) findViewById(R.id.rb_tab_item_my);
        rgTabMenu = (RadioGroup) findViewById(R.id.rg_tab_menu);
        tvContent = (TextView) findViewById(R.id.tv_content);

        rgTabMenu.setOnCheckedChangeListener(new InnerOnCheckListener());
//        rbTabItemMsg.setOnCheckedChangeListener(new InnerOnCheckListener());
//        rbTabItemContact.setOnCheckedChangeListener(new InnerOnCheckListener());
//        rbTabItemFind.setOnCheckedChangeListener(new InnerOnCheckListener());
//        rbTabItemMy.setOnCheckedChangeListener(new InnerOnCheckListener());

    }
    private class InnerOnCheckListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_tab_item_msg:
                    tvContent.setText("[微信]");
                    break;

                case R.id.rb_tab_item_contact:
                    tvContent.setText("[通讯录]");
                    break;

                case R.id.rb_tab_item_find:
                    tvContent.setText("[发现]");
                    break;

                case R.id.rb_tab_item_my:
                    tvContent.setText("[我]");
                    break;
            }
        }
    }

//    private class InnerOnCheckListener implements CompoundButton.OnCheckedChangeListener{
//        @Override
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            if (isChecked) {
//                // tvContent.setText(buttonView.getText());
//                switch (buttonView.getId()) {
//                    case R.id.rb_tab_item_msg:
//                        tvContent.setText("信息");
//                        break;
//
//                    case R.id.rb_tab_item_contact:
//                        tvContent.setText("通讯录");
//                        break;
//
//                    case R.id.rb_tab_item_find:
//                        tvContent.setText("发现");
//                        break;
//
//                    case R.id.rb_tab_item_my:
//                        tvContent.setText("我");
//                        break;
//                }
//            }
//        }
//    }

}
