package com.example.m3zt.finalcalc;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    TextToSpeech ttsobject;
    String re="";
    int op,cl=0;
    String pro="";
    protected static final int RESULT_SPEECH = 1;
    private ImageButton btnSpeak;
    TextView txt;
    String Text="";
    int result;
    Button b1;
    TextView txt1;
    public void onbutton(String j)
    {
        Text+=j;
        txt.setText(Text);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt=(TextView)findViewById(R.id.textView8);
        txt1=(TextView)findViewById(R.id.textView7);
        b1=(Button) findViewById(R.id.button76);
        //txt = (TextView) findViewById(R.id.txtText);
        ttsobject=new TextToSpeech(Main2Activity.this,new TextToSpeech.OnInitListener() {
            public  void onInit (int status ){
                if(status==TextToSpeech.SUCCESS){
                    result= ttsobject.setLanguage(Locale.US);
                }else {
                    Toast.makeText(getApplicationContext(), "Feature is not supported in tour device ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSpeak=(ImageButton) findViewById(R.id.imageButton);
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    txt.setText("");
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Opps! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
    }
    public void onclequel(View view)
    {
        String res = "";
        try {

            if (Text.length() > 0) {
                while (op - cl != 0) {
                    Text += ")";
                    cl++;
                    txt.setText(Text);
                }


                if (Text.charAt(Text.length() - 1) != '-' && op == cl && Text.charAt(Text.length() - 1) != '+' && !(Text.contains("()")) && Text.charAt(Text.length() - 1) != 'x' && Text.charAt(Text.length() - 1) != '/' && Text.charAt(Text.length() - 1) != '.' && Text.charAt(Text.length() - 1) != '^') {
                    res = mm(txt.getText().toString().replace("x", "*"));

                    txt1.setText(res);
                    pro = res;
                    Text = "";

                }
            }
            res = mm(txt.getText().toString().replace("x", "*"));
            txt1.setText(res);
            pro = res;
            switch (view.getId()) {
                case R.id.button76:
                    if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                        Toast.makeText(getApplicationContext(), "Feature is not supported in tour device ", Toast.LENGTH_SHORT).show();
                    } else {
                        ttsobject.speak(res, TextToSpeech.QUEUE_FLUSH, null);
                    }
                    ;
            }
        }
        catch(IndexOutOfBoundsException ioob)
        {
            res = mm("0");

            txt1.setText(res);
            pro = res;
            Text = "";
        }


}
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null!=data)
                {
                    String te="";

                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                       re=text.get(0).replace("by","/").replace("fact","!").replace("up","^")
                       ;
                    for (int i = 0; i < re.length(); i++)
                    {
                        if(re.charAt(i)>=42&&re.charAt(i)<=57||re.charAt(i)==33||re.charAt(i)==94)
                        {
                            te+=re.charAt(i);
                        }
                    }

                        txt.setText(te);

                }
                break;
            }

        }
    }

    protected void onDestroy(){
        super.onDestroy();
        if(ttsobject!=null){
            ttsobject.stop();
            ttsobject.shutdown();
        }
    }

    public void onclswitch(View view)
    {
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }















































































    public static double fact(double n)
    {


        if(n<=0)
        {
            return 1;
        }
        else
        {
            return n*fact(n-1);
        }
    }
    public static String mm(String t)
    {

        if(t.contains("!("))
        {
            t=t.replace("!(", "!*(");
        }
        if(t.contains(")("))
        {
            t=t.replace(")(", ")*(");
        }
        if(t.contains(")1"))
        {
            t=t.replace(")1", ")*1");
        }
        if(t.contains(")2"))
        {
            t=t.replace(")2", ")*2");
        }
        if(t.contains(")3"))
        {
            t=t.replace(")3", ")*3");
        }
        if(t.contains(")4"))
        {
            t=t.replace(")4", ")*4");
        }
        if(t.contains(")5"))
        {
            t=t.replace(")5", ")*5");
        }
        if(t.contains(")6"))
        {
            t=t.replace(")6",")*6" );
        }
        if(t.contains(")7"))
        {
            t=t.replace(")7",")*7" );
        }
        if(t.contains(")8"))
        {
            t=t.replace(")8",")*8" );
        }
        if(t.contains(")9"))
        {
            t=t.replace(")9",")*9" );
        }
        if(t.contains(")0"))
        {
            t=t.replace(")0",")*0" );
        }
        if(t.contains("0("))
        {
            t=t.replace("0(","0*(" );
        }
        if(t.contains("1("))
        {
            t=t.replace("1(","1*(" );
        }
        if(t.contains("2("))
        {
            t=t.replace("2(","2*(" );
        }
        if(t.contains("3("))
        {
            t=t.replace("3(","3*(" );
        }
        if(t.contains("4("))
        {
            t=t.replace("4(","4*(" );
        }
        if(t.contains("5("))
        {
            t=t.replace("5(","5*(" );
        }
        if(t.contains("6("))
        {
            t=t.replace("6(","6*(" );
        }
        if(t.contains("7("))
        {
            t=t.replace("7(","7*(" );
        }
        if(t.contains("8("))
        {
            t=t.replace("8(","8*(" );
        }
        if(t.contains("9("))
        {
            t=t.replace("9(","9*(" );
        }
//
//
//            for (int j = 0; j < t.length(); j++)
//            {
//                if(t.charAt(j)=='(')
//                {
//                    if(j!=0)
//                    {
//                        if(t.charAt(j-1)!='+'||t.charAt(j-1)!='-'||t.charAt(j-1)!='*'||t.charAt(j-1)!='/'||t.charAt(j-1)!='^')
//                        {
//                            t=t.replace("(", "*(");
//
//                        }
//                    }
//                   return m(t);
//                }
//            }
//            for (int i = 0; i < t.length(); i++)
//            {
//
//                if(t.charAt(i)==')')
//                {
//                    if(i!=t.length())
//                    {
//                        if(t.charAt(i+1)!='+'||t.charAt(i+1)!='-'||t.charAt(i+1)!='*'||t.charAt(i+1)!='/'||t.charAt(i+1)!='^')
//                        {
//                            t=t.replace(")", ")*");
//                        }
//                    }
//                   return m(t);
//                }
//
//            }
        return m(t);
    }

    public static String m(String t)
    {

        String ee="";
        int e=0;
        String k="";
        String s=t;


        for (int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)=='(')
            {
                e=i;
            }
            if (s.charAt(i)==')')
            {
                for (int j = e+1; j <i ; j++)
                {
                    k+=s.charAt(j);

                    //System.out.println(ee);


                }
                // System.out.println(k);
//                System.out.println("("+k+")");
//                System.out.println(mee(k));
                s=s.replace("("+k+")",mee(k));
                return m(s);
            }

        }
        if(s.contains("("))
        {
            return m(s);
        }
        return mee(s);

    }




    public static String mee(String s)
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
        s=s.replace("!-","!z");
        String []num;
        List<Character>op;
        op=new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)=='*'||s.charAt(i)=='/'||s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='!'||s.charAt(i)=='^')
            {
                op.add(s.charAt(i));
            }
        }
        for (int i = 0; i < op.size(); i++)
        {
            num=s.split("-|\\+|\\*|\\/|\\!|\\^");
            switch(op.get(i))
            {
                case'!':
                {
                    num[i]=num[i].replace("z","-");
                    double s1= fact(Float.parseFloat(num[i]));
                    String s0=df.format(s1);
                    num[i]=num[i].replace("-", "z");
                    s=s.replace(num[i]+"!", s0);
                    if(s.charAt(0)=='-')
                    {
                        s=s.replaceFirst("-", "z");
                    }
                    s=s.replace("--", "-z");
                    s=s.replace("+-", "+z");
                    s=s.replace("*-", "*z");
                    s=s.replace("/-", "/z");
                    s=s.replace("^-", "^z");
                    op.remove(i);
                    i=-1;
                }
                break;
            }
        }
        for (int i = 0; i < op.size(); i++)
        {
            num=s.split("-|\\+|\\*|\\/|\\^");
            switch(op.get(i))
            {
                case '^':
                {
                    num[i]=num[i].replace("z","-");
                    num[i+1]=num[i+1].replace("z", "-");
                    double s1=Math.pow(Float.parseFloat(num[i]) , Float.parseFloat(num[i+1])) ;
                    String s0=df.format(s1);
                    num[i]=num[i].replace("-", "z");
                    num[i+1]=num[i+1].replace("-", "z");
                    s=s.replace(num[i]+"^"+num[i+1], s0);
                    if(s.charAt(0)=='-')
                    {
                        s=s.replaceFirst("-", "z");
                    }
                    s=s.replace("--", "-z");
                    s=s.replace("+-", "+z");
                    s=s.replace("*-", "*z");
                    s=s.replace("/-", "/z");
                    s=s.replace("^-", "^z");
                    op.remove(i);
                    i=-1;
                }
                break;
            }
        }
        for (int i = 0; i < op.size(); i++)
        {
            num=s.split("-|\\+|\\*|\\/|\\^");
            switch(op.get(i))
            {
                case'*':
                {
                    num[i]=num[i].replace("z","-");
                    num[i+1]=num[i+1].replace("z", "-");
                    Float s1=Float.valueOf(num[i]).floatValue() * Float.valueOf(num[i+1]).floatValue();
                    String s0=df.format(s1);
                    num[i]=num[i].replace("-", "z");
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
                    s=s.replace("^-", "^z");
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
                    s=s.replace("^-", "^z");
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
                    num[i]=num[i].replace("-", "z");
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
                    s=s.replace("^-", "^z");
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
                    s=s.replace("^-", "^z");
                    op.remove(i);
                    i=-1;
                }
                break;
            }
        }
        s=s.replace("z", "-");
        return s;
    }
    public void onclback(View view)
    {
        if(Text.length()>=1)
        {
            if(Text.charAt(Text.length()-1)==')')
            {
                cl--;
            }
            if(Text.charAt(Text.length()-1)=='(')
            {
                op--;
            }
            Text = Text.substring(0, Text.length() - 1);
            txt.setText(Text);
        }
    }
    public void onclclear(View view)
    {
        pro="";
        Text="";
        txt.setText(Text);
        op=cl=0;
    }
    public void oncldot(View view)
    {
        String []d=Text.split("x|\\+|\\-|\\/|\\^");
        if(d[d.length-1].contains("."))
        {
            if(Text.charAt(Text.length()-1)=='+'||Text.charAt(Text.length()-1)=='x'||Text.charAt(Text.length()-1)=='-'||Text.charAt(Text.length()-1)=='/'||Text.charAt(Text.length()-1)=='^')
            {
                onbutton(".");
            }
        }
        else
        {
            onbutton(".");

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
        onbutton("1");pro="";
    }
    public void oncltwo(View view)
    {
        onbutton("2");pro="";
    }
    public void onclthree(View view)
    {
        onbutton("3");pro="";
    }
    public void onclfour(View view)
    {
        onbutton("4");pro="";
    }
    public void onclfive(View view)
    {
        onbutton("5");pro="";
    }
    public void onclsix(View view)
    {
        onbutton("6");pro="";
    }
    public void onclseven(View view)
    {
        onbutton("7");pro="";
    }
    public void oncleight(View view)
    {
        onbutton("8");pro="";
    }
    public void onclnine(View view)
    {
        onbutton("9");pro="";
    }

    public void onclplus(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0)
        {
            if(Text.charAt(Text.length()-1)!='+'&&Text.charAt(Text.length()-1)!='-'&&Text.charAt(Text.length()-1)!='.'&&Text.charAt(Text.length()-1)!='/'&&Text.charAt(Text.length()-1)!='x'&&Text.charAt(Text.length()-1)!='^')
            {
                onbutton("+");
            }
            else
            {
               Text= Text.replace(""+Text.charAt(Text.length()-1),"+");
                txt.setText(Text);
            }
        }


    }
    public void onclmin(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0)
        {
            if(Text.charAt(Text.length()-1)!='+'&&Text.charAt(Text.length()-1)!='-'&&Text.charAt(Text.length()-1)!='.'&&Text.charAt(Text.length()-1)!='/'&&Text.charAt(Text.length()-1)!='x'&&Text.charAt(Text.length()-1)!='^')
                onbutton("-");
            else
            {
                Text= Text.replace(""+Text.charAt(Text.length()-1),"-");
                txt.setText(Text);
            }
        }
    }
    public void oncldiv(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0)
        {
            if(Text.charAt(Text.length()-1)!='+'&&Text.charAt(Text.length()-1)!='.'&&Text.charAt(Text.length()-1)!='-'&&Text.charAt(Text.length()-1)!='/'&&Text.charAt(Text.length()-1)!='x'&&Text.charAt(Text.length()-1)!='^')
                onbutton("/");
            else
            {
                Text= Text.replace(""+Text.charAt(Text.length()-1),"/");
                txt.setText(Text);
            }
        }
    }
    public void onclmulti(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0)
        {
            if(Text.charAt(Text.length()-1)!='+'&&Text.charAt(Text.length()-1)!='.'&&Text.charAt(Text.length()-1)!='-'&&Text.charAt(Text.length()-1)!='/'&&Text.charAt(Text.length()-1)!='x'&&Text.charAt(Text.length()-1)!='^')
                onbutton("x");
            else
            {
                Text= Text.replace(""+Text.charAt(Text.length()-1),"x");
                txt.setText(Text);
            }
        }
    }
    public void onclpow (View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0)
        {
            if(Text.charAt(Text.length()-1)!='+'&&Text.charAt(Text.length()-1)!='.'&&Text.charAt(Text.length()-1)!='-'&&Text.charAt(Text.length()-1)!='/'&&Text.charAt(Text.length()-1)!='x'&&Text.charAt(Text.length()-1)!='^')
                onbutton("^");
            else
            {
                Text= Text.replace(""+Text.charAt(Text.length()-1),"^");
                txt.setText(Text);
            }
        }
    }
    public void onclfact(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        if(Text.length()>0)
        {
            if(Text.charAt(Text.length()-1)!='+'&&Text.charAt(Text.length()-1)!='.'&&Text.charAt(Text.length()-1)!='-'&&Text.charAt(Text.length()-1)!='/'&&Text.charAt(Text.length()-1)!='x'&&Text.charAt(Text.length()-1)!='^')
                onbutton("!");
        }
    }
    public void onclop(View view)
    {
        if(pro!="")
        {
            Text=pro;
        }
        onbutton("(");
        op++;
        Toast.makeText(Main2Activity.this,""+op, Toast.LENGTH_SHORT).show();
    }
    public void onclinfor(View view)
    {
        Toast.makeText(Main2Activity.this, "Plus     +"+"\n"
                                         + "Mins     -"+"\n"
                                         + "By        /"+"\n"
                                         + "X         x"+"\n"
                                         +"Fact      !"+"\n"
                                         +"Up        ^"   , Toast.LENGTH_LONG).show();
    }
    public void onclclo(View view)
    {
        if(Text.length()>0)
        {
            if(Text.charAt(Text.length()-1)!='+'&&Text.charAt(Text.length()-1)!='.'&&Text.charAt(Text.length()-1)!='-'&&Text.charAt(Text.length()-1)!='/'&&Text.charAt(Text.length()-1)!='x'&&Text.charAt(Text.length()-1)!='^')
                onbutton(")");
            cl++;
            Toast.makeText(Main2Activity.this, ""+(op-cl), Toast.LENGTH_SHORT).show();
        }

    }}
