package org.aplas.basicappx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

import android.content.DialogInterface;
import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
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
        convertBtn = (Button) findViewById(R.id.convertButton);
        inputTxt = (EditText) findViewById(R.id.inputText);
        outputTxt = (EditText) findViewById(R.id.outputText);
        unitOri = (Spinner) findViewById(R.id.oriList);
        unitConv = (Spinner) findViewById(R.id.convList);
        unitType = (RadioGroup) findViewById(R.id.radioGroup);
        roundBox = (CheckBox) findViewById(R.id.chkRounded);
        formBox = (CheckBox) findViewById(R.id.chkFormula);
        imgView = (ImageView) findViewById(R.id.img);

        unitType.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                        RadioButton selectRadio = (RadioButton) findViewById(checkedId);
                        ArrayAdapter<CharSequence> arrayAdapter;
                        if (selectRadio.getText().equals("Temperature")) {
                            arrayAdapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.tempList, android.R.layout.simple_spinner_item);
                            imgView.setImageResource(R.drawable.temperature);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            unitOri.setAdapter(arrayAdapter);
                            unitConv.setAdapter(arrayAdapter);
                            inputTxt.setText("0");
                            outputTxt.setText("0");
                        } else if (selectRadio.getText().equals("Distance")) {
                            arrayAdapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.distList, android.R.layout.simple_spinner_item);
                            imgView.setImageResource(R.drawable.distance);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            unitOri.setAdapter(arrayAdapter);
                            unitConv.setAdapter(arrayAdapter);
                            inputTxt.setText("0");
                            outputTxt.setText("0");
                        } else if (selectRadio.getText().equals("Weight")) {
                            arrayAdapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.weightList, android.R.layout.simple_spinner_item);
                            imgView.setImageResource(R.drawable.weight);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            unitOri.setAdapter(arrayAdapter);
                            unitConv.setAdapter(arrayAdapter);
                            inputTxt.setText("0");
                            outputTxt.setText("0");
                        }
                    }
                });
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doConvert();
            }
        });
        unitOri.setOnItemSelectedListener(new
                                                  AdapterView.OnItemSelectedListener() {
                                                      @Override
                                                      public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                                                            doConvert();
                                                      }

                                                      @Override
                                                      public void onNothingSelected(AdapterView<?> parent) {
                                                                return;
                                                      }
                                                  });
        unitConv.setOnItemSelectedListener(new
                                                  AdapterView.OnItemSelectedListener() {
                                                      @Override
                                                      public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                                                          doConvert();
                                                      }

                                                      @Override
                                                      public void onNothingSelected(AdapterView<?> parent) {
                                                          return;
                                                      }
                                                  });
        roundBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                doConvert();
            }
        });

    }

    public void doConvert(){
        RadioButton selectRadio = (RadioButton) findViewById(unitType.getCheckedRadioButtonId());
        double val = Double.parseDouble(inputTxt.getText().toString());
        double res = convertUnit(selectRadio.getText().toString(),unitOri.getSelectedItem().toString(),unitConv.getSelectedItem().toString(),val);
        outputTxt.setText(strResult(res,roundBox.isChecked()));
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