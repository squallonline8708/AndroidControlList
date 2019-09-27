package com.sdpw.squall.temp_app;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity {

    //显示Dialog的类型
    final int DATE_DIALOG = 1;
    //日期初始化
    final Calendar ca = Calendar.getInstance();
    //获取当前系统日期的年月日
    //初始化日期控件的年月日为系统日期
    private int initYear=ca.get(Calendar.YEAR);
    private int initMonth=ca.get(Calendar.MONTH);
    private int initDay=ca.get(Calendar.DAY_OF_MONTH);
    private EditText etDateSel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        etDateSel=(EditText)findViewById(R.id.etDateSel);
        //因为此处需要一个监听器而内部类InnerClassETSelListener已经实现了此接口
        //所以直接初始化一个此类作为参数即可
        etDateSel.setOnClickListener(new InnerClassETSelListener());
    }

    //创建一个内部类来实现OnClickListener的监听接口
    public class InnerClassETSelListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            showDialog(DATE_DIALOG);
        }
    }

    //创建一个内部类来实现OnDateSetListener的监听接口
    //来接收用户选择的年月日
    public class InnerClassDatePickListener implements DatePickerDialog.OnDateSetListener
    {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            initYear=year;
            initMonth=month;
            initDay=dayOfMonth;
            //将获取的值赋予TextView
            display();
        }
    }

    /**
     * 设置日期 利用StringBuffer追加
     * 注意： 由于Java内部原因所以month需要+1才能显示正确的月份
     */
    public void display() {
        etDateSel.setText(new StringBuffer().append(initYear).append("-").append(initMonth+1).append("-").append(initDay).append(" "));
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id)
        {
            case DATE_DIALOG:
                 new DatePickerDialog(DateTimeActivity.this,new InnerClassDatePickListener() ,initYear ,initMonth ,initDay );
            break;
        }
        return super.onCreateDialog(id);
    }


}
