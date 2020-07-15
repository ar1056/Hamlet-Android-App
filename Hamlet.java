/*calculator*/
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Cal extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7;
    EditText e1;
    EditText e2;
    EditText e3;
    TextView t1;
    TextToSpeech t2;
    String s100="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        b1 = (Button) findViewById(R.id.button31);
        b2 = (Button) findViewById(R.id.button35);
        b3 = (Button) findViewById(R.id.button32);
        b4 = (Button) findViewById(R.id.button36);
        b5 = (Button) findViewById(R.id.button33);
        b6 = (Button) findViewById(R.id.button30);
        b7=(Button)findViewById(R.id.button34);
        e1 = (EditText) findViewById(R.id.editText11);
        e2 = (EditText) findViewById(R.id.editText12);
        e3=(EditText)findViewById(R.id.editText13);

        t2=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t2.setLanguage(Locale.ENGLISH);
                t2.setSpeechRate(0.5f);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s100="";
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Float i1 = Float.parseFloat(s1);
                Float i2 = Float.parseFloat(s2);
                Float i3 = i1 + i2;
                String s3 = Float.toString(i3);
                s100=s3;

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s100="";
                String s4=e1.getText().toString();
                String s5=e2.getText().toString();
                Float i4=Float.parseFloat(s4);
                Float i5=Float.parseFloat(s5);
                Float i6=i4-i5;
                String s6=Float.toString(i6);
                s100=s6;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s100="";
                String s7=e1.getText().toString();
                String s8=e2.getText().toString();
                Float i7=Float.parseFloat(s7);
                Float i8=Float.parseFloat(s8);
                Float i9=i7*i8;
                String s9=Float.toString(i9);
                s100=s9;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s100="";
                String s10=e1.getText().toString();
                String s11=e2.getText().toString();
                Float i10=Float.parseFloat(s10);
                Float i11=Float.parseFloat(s11);
                Float i12=i10/i11;
                String s12=Float.toString(i12);
                s100=s12;
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e3.setText(s100);
                t2.speak(s100, TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(Cal.this, "Hamlet", Toast.LENGTH_SHORT).show();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Cal.this,Third.class);
                startActivity(i);
                finish();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                e3.setText("");

            }
        });


    }


}


/*camera*/
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {
    Button b1,b2;
    ImageView m1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        b1=(Button)findViewById(R.id.button14);
        b2=(Button)findViewById(R.id.button15);
        m1=(ImageView)findViewById(R.id.imageView4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Camera.this,Third.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(l,0);


            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Bitmap b7=(Bitmap)data.getExtras().get("data");
        m1.setImageBitmap(b7);

    }
}
/*login*/
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))


                {
                    Toast.makeText(MainActivity.this,"fill all",Toast.LENGTH_SHORT).show();

                }
                else{
                    SQLiteDatabase db=openOrCreateDatabase("netcamp",MODE_PRIVATE,null);
                    db.execSQL("create table if not exists diya (name varchar,password varchar,email varchar,city varchar,phone varchar) ");
                    String s3="select * from diya where name ='"+s1+"' and password = '"+s2+"'";
                    Cursor cursor=db.rawQuery(s3,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(MainActivity.this,"login success",Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(MainActivity.this,Third.class);
                        startActivity(j);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"no shuch user",Toast.LENGTH_SHORT).show();
                        Intent k=new Intent(MainActivity.this,Second.class);
                        startActivity(k);
                        finish();
                    }
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Second.class);
                startActivity(i);
                finish();
            }
        });
    }
}


/*music magic*/
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class Magic extends AppCompatActivity implements SensorEventListener {
    Button b1;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic);
        b1 = (Button) findViewById(R.id.button13);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Magic.this,Special.class);
                startActivity(i);
                finish();
                mp.stop();
            }
        });
        mp = MediaPlayer.create(this, R.raw.k);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0]>3)
        {
            mp.start();
        }
        else
        {
            mp.pause();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
/*media player*/
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Media extends AppCompatActivity {
    Button b1,b2,b3;
    MediaPlayer mp;
    SeekBar s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        b1=(Button)findViewById(R.id.button16);
        b2=(Button)findViewById(R.id.button17);
        b3=(Button)findViewById(R.id.button18);


        mp=MediaPlayer.create(this,R.raw.k);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Media.this,Third.class);
                startActivity(i);
                finish();
                mp.stop();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
    }
}
/*register*/
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);  e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        e3=(EditText)findViewById(R.id.editText5);
        e4=(EditText)findViewById(R.id.editText6);
        e5=(EditText)findViewById(R.id.editText7);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Second.this,MainActivity.class);
                startActivity(j);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s5=e4.getText().toString();
                String s6=e5.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals(""))
                {
                    Toast.makeText(Second.this,"fill alll",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase db=openOrCreateDatabase("netcamp",MODE_PRIVATE,null);
                    db.execSQL("create table if not exists diya (name varchar,password varchar,email varchar,city varchar,phone varchar)");
                    String s4="select * from diya where name='"+s1+"' and email='"+s3+"'";
                    Cursor cursor=db.rawQuery(s4,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(Second.this," already present",Toast.LENGTH_SHORT).show();
                        Intent k=new Intent(Second.this,MainActivity.class);
                        startActivity(k);
                        finish();
                    }
                    else
                    {
                        db.execSQL("insert into diya values('"+s1+"','"+s2+"','"+s3+"','"+s5+"','"+s6+"')");
                        Toast.makeText(Second.this,"user entered",Toast.LENGTH_SHORT).show();
                        Intent n=new Intent(Second.this,MainActivity.class);
                        startActivity(n);
                        finish();
                    }
                }
            }
        });
    }
}


/*Quiz*/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Q1 extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    TextView t1;
    Button b1,b2;
    static int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);
        b1=(Button)findViewById(R.id.button31);
        b2=(Button)findViewById(R.id.button35);
        t1=(TextView)findViewById(R.id.textView4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Q1.this,Special.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r1.isChecked())
                {
                    ++score;
                }
                else{
                    --score;
                }
                Intent j=new Intent(Q1.this,Q2.class);
                startActivity(j);
                finish();
            }
        });
    }
}
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Q2 extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    TextView t1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);
        r1=(RadioButton)findViewById(R.id.radioButton5);
        r2=(RadioButton)findViewById(R.id.radioButton6);
        r3=(RadioButton)findViewById(R.id.radioButton7);
        r4=(RadioButton)findViewById(R.id.radioButton8);

        b2=(Button)findViewById(R.id.button36);
        t1=(TextView)findViewById(R.id.textView5);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r1.isChecked())
                {
                    ++Q1.score;
                }
                else{
                    --Q1.score;
                }
                Intent j=new Intent(Q2.this,Q3.class);
                startActivity(j);
                finish();
            }
        });
    }
}
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Q2 extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    TextView t1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);
        r1=(RadioButton)findViewById(R.id.radioButton5);
        r2=(RadioButton)findViewById(R.id.radioButton6);
        r3=(RadioButton)findViewById(R.id.radioButton7);
        r4=(RadioButton)findViewById(R.id.radioButton8);

        b2=(Button)findViewById(R.id.button36);
        t1=(TextView)findViewById(R.id.textView5);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r1.isChecked())
                {
                    ++Q1.score;
                }
                else{
                    --Q1.score;
                }
                Intent j=new Intent(Q2.this,Q3.class);
                startActivity(j);
                finish();
            }
        });
    }
}

