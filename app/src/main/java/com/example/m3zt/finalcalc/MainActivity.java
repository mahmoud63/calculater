package com.example.m3zt.finalcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    int dot,io=0;
    TextView txt1;
    TextView txt;
    String Text="";
    String pro="";
    public void onbutton(String j)
    {
        Text+=j;
        txt.setText(Text);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.textView6);
        txt1=(TextView)findViewById(R.id.textView5);
    }
    public static String cal(String s)
    {
        DecimalFormat df=new DecimalFormat("#.####");
        if(s.charAt(0)=='-')
        {
            s=s.replaceFirst("-", "z");
        }
        s=s.replace("--", "-z");
        s=s.replace("+-", "+z");
        s=s.replace("*-", "*z");
        s=s.replace("/-", "/z");
        String []num;
        List<Character>op;
        op=new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)=='*'||s.charAt(i)=='/'||s.charAt(i)=='+'||s.charAt(i)=='-')
            {
                op.add(s.charAt(i));
            }
        }
        for (int i = 0; i < op.size(); i++)
        {
            num=s.split("-|\\+|\\*|\\/");
            switch(op.get(i))
            {
                case'*':
                {
                    num[i]=num[i].replace("z","-");
                    num[i+1]=num[i+1].replace("z", "-");
                    Float s1=Float.valueOf(num[i]).floatValue() * Float.valueOf(num[i+1]).floatValue();
                    String s0=df.format(s1);
                    num[i]=num[i].replace("-","z");
                    num[i+1]=num[i+1].replace("-", "z");
                    s=s.replace(num[i]+"*"+num[i+1], ""+s0);
                    if(s.charAt(0)=='-')
                    {
                        s=s.replaceFirst("-", "z");
                    }
                    s=s.replace("--", "-z");
                    s=s.replace("+-", "+z");
                    s=s.replace("*-", "*z");
                    s=s.replace("/-", "/z");
                    op.remove(i);
                    i=-1;
                }
                break;
                case '/':
                {
                    num[i]=num[i].replace("z","-");
                    num[i+1]=num[i+1].replace("z", "-");
                    Float s1=Float.valueOf(num[i]).floatValue() / Float.valueOf(num[i+1]).floatValue();
                    String s0=df.format(s1);
                    num[i]=num[i].replace("-","z");
                    num[i+1]=num[i+1].replace("-", "z");
                    s=s.replace(num[i]+"/"+num[i+1], ""+s0);
                    if(s.charAt(0)=='-')
                    {
                        s=s.replaceFirst("-", "z");
                    }
                    s=s.replace("--", "-z");
                    s=s.replace("+-", "+z");
                    s=s.replace("*-", "*z");
                    s=s.replace("/-", "/z");
                    op.remove(i);
                    i=-1;
                }
                break;
            }
        }

        for (int i = 0; i < op.size(); i++)
        {
            num=s.split("-|\\+|\\*|\\/");
            switch(op.get(i))
            {
                case'+':
                {
                    num[i]=num[i].replace("z","-");
                    num[i+1]=num[i+1].replace("z", "-");
                    Float s1=Float.valueOf(num[i]).floatValue() + Float.valueOf(num[i+1]).floatValue();
                    String s0=df.format(s1);
                    num[i]=num[i].replace("-","z");
                    num[i+1]=num[i+1].replace("-", "z");
                    s=s.replace(num[i]+"+"+num[i+1], ""+s0);
                    if(s.charAt(0)=='-')
                    {
                        s=s.replaceFirst("-", "z");
                    }
                    s=s.replace("--", "-z");
                    s=s.replace("+-", "+z");
                    s=s.replace("*-", "*z");
                    s=s.replace("/-", "/z");
                    op.remove(i);
                    i=-1;
                }
                break;
                case '-':
                {
                    num[i]=num[i].replace("z","-");
                    num[i+1]=num[i+1].replace("z", "-");
                    Float s1=Float.valueOf(num[i]).floatValue() - Float.valueOf(num[i+1]).floatValue();
                    String s0=df.format(s1);
                    num[i]=num[i].replace("-","z");
                    num[i+1]=num[i+1].replace("-", "z");
                    s=s.replace(num[i]+"-"+num[i+1], ""+s0);
                    if(s.charAt(0)=='-')
                    {
                        s=s.replaceFirst("-", "z");
                    }
                    s=s.replace("--", "-z");
                    s=s.replace("+-", "+z");
                    s=s.replace("*-", "*z");
                    s=s.replace("/-", "/z");
                    op.remove(i);
                    i=-1;
                }
                break;
            }
        }
        s=s.replace("z", "-");
        return s;
    }

    public void onclback(View view)    {
        io=0;
        if(Text.length()>=1)
        {
            if(Text.charAt(Text.length()-1)=='.')
            {
                Text = Text.substring(0, Text.length() - 1);
                txt.setText(Text);
                dot=0;
            }
            else if(Text.charAt(Text.length()-1)=='+'||Text.charAt(Text.length()-1)=='-'||Text.charAt(Text.length()-1)=='x'||Text.charAt(Text.length()-1)=='/')
            {
                String[]aq=Text.split("-|\\+|\\/|x");
                if(aq[aq.length-1].contains("."))
                {
                    Text = Text.substring(0, Text.length() - 1);
                    txt.setText(Text);
                    dot=1;
                }
                else
                {
                    Text = Text.substring(0, Text.length() - 1);
                    txt.setText(Text);
                    dot=0;
                }

            }
            else
            {
                Text = Text.substring(0, Text.length() - 1);
                txt.setText(Text);
            }
        }
    }
    public void onclclear(View view)
    {
        Text="";
        pro="";
        txt.setText(Text);
        dot=0;
        io=0;
    }
    public void oncldot(View view)
    {
        if(dot==0&&io!=2)
        {
            onbutton(".");
            dot=1;
        }
        pro="";
    }
    public void onclzero(View view)
    {
        onbutton("0");
        pro="";
    }
    public void onclone(View view)
    {
        onbutton("1");
        pro="";
    }
    public void oncltwo(View view)
    {
        onbutton("2");
        pro="";
    }
    public void onclthree(View view)
    {
        onbutton("3");
        pro="";
    }
    public void onclfour(View view)
    {
        onbutton("4");
        pro="";
    }
    public void onclfive(View view)
    {
        onbutton("5");
        pro="";
    }
    public void onclsix(View view)
    {
        onbutton("6");
        pro="";
    }
    public void onclseven(View view)
    {
        onbutton("7");
        pro="";
    }
    public void oncleight(View view)
    {
        onbutton("8");
        pro="";
    }
    public void onclnine(View view)
    {
        onbutton("9");
        pro="";
    }
    public void onclplus(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0) {
            if (Text != "") {
                if (Text.charAt(Text.length() - 1) != '+' && Text.charAt(Text.length() - 1) != '-'&& Text.charAt(Text.length() - 1) != '.' && Text.charAt(Text.length() - 1) != '/' && Text.charAt(Text.length() - 1) != 'x') {

                    onbutton("+");
                    dot = 0;
                    io = 0;
                }
            }
        }
    }
    public void onclmin(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0) {
            if (Text != "") {
                if (Text.charAt(Text.length() - 1) != '+' && Text.charAt(Text.length() - 1) != '-'&& Text.charAt(Text.length() - 1) != '.' && Text.charAt(Text.length() - 1) != '/' && Text.charAt(Text.length() - 1) != 'x') {

                    onbutton("-");
                    dot = 0;
                    io = 0;
                }
            }
        }
    }
    public void oncldiv(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0) {
            if (Text != "") {
                if (Text.charAt(Text.length() - 1) != '+' && Text.charAt(Text.length() - 1) != '-'&& Text.charAt(Text.length() - 1) != '.' && Text.charAt(Text.length() - 1) != '/' && Text.charAt(Text.length() - 1) != 'x') {

                    onbutton("/");
                    dot = 0;
                    io = 0;
                }
            }
        }
    }
    public void onclmulti(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0) {
            if (Text != "") {
                if (Text.charAt(Text.length() - 1) != '+'&& Text.charAt(Text.length() - 1) != '.' && Text.charAt(Text.length() - 1) != '-' && Text.charAt(Text.length() - 1) != '/' && Text.charAt(Text.length() - 1) != 'x')
                {

                    onbutton("x");
                    dot = 0;
                    io = 0;
                }
            }
        }
    }
    public void onclequal(View view)
    {
        if(Text.length()>0)
        {
            if (Text != "" && Text.charAt(Text.length() - 1) != '+'&& Text.charAt(Text.length() - 1) != '-' && Text.charAt(Text.length() - 1) != '/' && Text.charAt(Text.length() - 1) != 'x' && Text.charAt(Text.length() - 1) != '.') {
                String res = cal(txt.getText().toString().replace("x", "*"));
                txt1.setText(res);
                pro = res;
                Text="";
                if (Text.contains(".")) {
                    io = 2;
                }
            }
        }
    }
    public void onclswitch(View view)
    {
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
        this.finish();
    }
}
