package s07150712.gdmec.edu.cn.dialog;



import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView) findViewById(R.id.charactor);
        tv2=(TextView)findViewById(R.id.uidate);
        tv3=(TextView)findViewById(R.id.uitime);
    }
    public void characterpickerdialog(View v){
        final String options="0123456789#";
        CharacterPickerDialog cpd=new CharacterPickerDialog(this,new View(this),null,options,false){
            @Override
            public void onClick(View v) {
                tv1.append(((Button)v).getText().toString());
                if(((Button)v).getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        cpd.show();
    }
    public void datepickerdialog(View v){
        DatePickerDialog dpd=new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv2.setText("日期"+year+"-"+(month+1)+"-"+dayOfMonth);
            }
        },2016, 10, 5);
        dpd.show();
    }
    public void timepickerdialog(View v){
        TimePickerDialog tpd=new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv3.setText(hourOfDay+":"+minute);
            }
        },9,9,true);
        tpd.show();
    }
    public void progressdialog(View v){
        final ProgressDialog pd=ProgressDialog.show(this,"下载","下载中，请稍后。。。。。。。。。。",true);
        new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    pd.dismiss();
                }
            }
        }.start();
    }
}
