package com.sdpw.squall.temp_app;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_two;
    private Button btn_three;
    private Button btn_list;
    private Button btn_MultiSel;
    private AlertDialog.Builder builder;
    private ProgressDialog progressDialog;
    private Button btn_Single_select;
    private Button btn_Waiting;
    private int choice;
    private Button btn_Loading;
    private Button btn_Single_input;
    private Button btn_Customer_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btn_two=(Button)findViewById(R.id.btn_two);
        btn_three=(Button)findViewById(R.id.btn_three);
        btn_list=(Button)findViewById(R.id.btn_list);
        btn_MultiSel=(Button)findViewById(R.id.btn_multi_select);
        btn_Single_select=(Button)findViewById(R.id.btn_Single_select);
        btn_Waiting=(Button)findViewById(R.id.btn_Waiting);
        btn_Loading=(Button)findViewById(R.id.btn_Loading);
        btn_Single_input=(Button)findViewById(R.id.btn_Single_input);
        btn_Customer_input=(Button)findViewById(R.id.btn_Customer_input);


        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_list.setOnClickListener(this);
        btn_MultiSel.setOnClickListener(this);
        btn_Single_select.setOnClickListener(this);
        btn_Waiting.setOnClickListener(this);
        btn_Loading.setOnClickListener(this);
        btn_Single_input.setOnClickListener(this);
        btn_Customer_input.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.btn_two:
                showTwo();
                break;
            case R.id.btn_three:
                showThree();
                break;
            case R.id.btn_list:
                showList();
                break;
            case R.id.btn_multi_select:
                showMultiList();
                break;
            case R.id.btn_Single_select:
                showSingleSelect();
                break;
            case R.id.btn_Waiting:
                showWaiting();
                break;
            case R.id.btn_Loading:
                showLoading();
                break;
            case R.id.btn_Single_input:
                showSingleInput();
                break;
            case R.id.btn_Customer_input:
                showMyStyle();
                break;
        }
    }

    private void showTwo()
    {
        builder=new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("最普通的Dialog")
                .setMessage("我是最简单的Dialog").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "点击了确认", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "点击了取消", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }

    private void showThree()
    {
        builder=new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("三个按钮的Dialog")
                .setMessage("三个按钮的Dialog")
                .setPositiveButton("查询", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "点击了查询", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("打印", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "点击了打印", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "点击了取消", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }

    private void showList()
    {
        final String[] items={"apple","pear","banana","orange","watermelon"};
        builder=new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("列表dialog")
               .setItems(items, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(DialogActivity.this, "你点选了"+items[which], Toast.LENGTH_SHORT).show();
                   }
               });
        builder.create().show();
    }

    private void showMultiList()
    {
        final List<Integer> choice=new ArrayList<>();
        final String[] items={"apple","pear","banana","orange","watermelon"};
        //默认均未选中
        boolean[] isSelect={false,false,false,false,false};


        builder=new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("多选dialog")
              .setMultiChoiceItems(items, isSelect, new DialogInterface.OnMultiChoiceClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if(isChecked)
                    {
                        choice.add(which);
                    }
                    else
                    {
                        choice.remove(which);
                    }
                  }
              })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder str=new StringBuilder();
                        for(int j=0;j<choice.size();j++)
                        {
                            str.append(items[choice.get(j)]);
                        }
                        Toast.makeText(DialogActivity.this,"你选择了："+str,Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }

    public void showSingleSelect()
    {
        final String[] items={"apple","pear","banana","orange","watermelon"};
        choice=-1;
        builder=new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("多选dialog")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choice=which;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(choice!=-1)
                        {
                            Toast.makeText(DialogActivity.this,"你选择了："+items[choice],Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        builder.create().show();
    }

    public void showWaiting()
    {
        progressDialog=new ProgressDialog(this);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setTitle("加载Dialog");
        progressDialog.setMessage("加载中...");
        //转圈圈动画
        progressDialog.setIndeterminate(true);
        //按钮返回键或者点击其他空白处是否关闭
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    public void showLoading()
    {
        final int MAX_VALUE=100;
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setTitle("带有加载进度的Dialog");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_VALUE);
        progressDialog.show();
        final Thread thread=new Thread(new Runnable(){
            @Override
            public void run()
            {
                int progress=0;
                while(progress<MAX_VALUE)
                {
                    try
                    {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                }
                progressDialog.cancel();
            }
        });
        thread.start();
    }

    public void showSingleInput()
    {
        final EditText editText=new EditText(this);
        builder=new AlertDialog.Builder(this).setTitle("输入框Dialog").setView(editText)
                .setPositiveButton("读取输入框的内容", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"你输入了："+editText.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }

    public void showMyStyle()
    {
        @SuppressLint("InflateParams")View view= LayoutInflater.from(this).inflate(R.layout.layout_test,null);
        final EditText etUserName=view.findViewById(R.id.et_username);
        final EditText et_password=view.findViewById(R.id.et_password);

        builder=new AlertDialog.Builder(this).setView(view).setTitle("自定义Dialog-登录").setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"账号："+etUserName.getText().toString()+",密码："
                                +et_password.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }
}
