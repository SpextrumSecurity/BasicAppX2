package org.aplas.basicappx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Distance dist = new Distance();
    private Weight weight = new Weight();
    private Temperature temp = new Temperature();
    private Button convertBtn;
    private EditText inputTxt;
    private EditText outputTxt;
    private Spinner unitOri;
    private Spinner unitConv;
    private RadioGroup unitType;
    private CheckBox roundBox;
    private CheckBox formBox;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertBtn = (Button)findViewById(R.id.convertButton);
        inputTxt = (EditText)findViewById(R.id.inputText);
        outputTxt = (EditText)findViewById(R.id.outputText);
        unitOri = (Spinner)findViewById(R.id.oriList);
        unitConv = (Spinner)findViewById(R.id.convList);
        unitType = (RadioGroup) findViewById(R.id.radioGroup);
        roundBox = (CheckBox)findViewById(R.id.chkRounded);
        formBox = (CheckBox)findViewById(R.id.chkFormula);
        imgView = (ImageView)findViewById(R.id.img);
    }

    protected double convertUnit(String type, String oriUnit, String convUnit, double value){
        if(type.equals("Temperature")){
            return temp.convert(oriUnit,convUnit,value);
        }else if(type.equals("Distance")){
            return dist.convert(oriUnit,convUnit,value);
        }else{
            return weight.convert(oriUnit,convUnit,value);
        }
    }

    protected String strResult (double val, boolean rounded){
        if (rounded) {
            DecimalFormat f = new DecimalFormat("#.##");
            return f.format(val);
        } else {
            DecimalFormat f = new DecimalFormat("#.#####");
            return f.format(val);
        }
    }

    private AlertDialog startDialog;
    @Override
    protected void onStart() {
        super.onStart();
        startDialog = new AlertDialog.Builder(MainActivity.this).create();
        startDialog.setTitle("Application started");
        startDialog.setMessage("This app can use to convert any units");
        startDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    });
        startDialog.show();

    }


}