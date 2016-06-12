package com.example.littl.tempswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class tempswitch extends AppCompatActivity
    implements RadioGroup.OnCheckedChangeListener, TextWatcher
{
    RadioGroup rbtnGroup;
    TextView txvType;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempswitch);

        rbtnGroup = (RadioGroup)findViewById(R.id.rbtnGroup);
        txvType = (TextView)findViewById(R.id.txvType);
        edt = (EditText)findViewById(R.id.edt);

        rbtnGroup.setOnCheckedChangeListener(this);
        edt.addTextChangedListener(this);
    }

    protected void selection(){

        TextView txvC = (TextView)findViewById(R.id.txvC);
        TextView txvF = (TextView)findViewById(R.id.txvF);

        double f=0, c=0;
        String value = edt.getText().toString();
        if(rbtnGroup.getCheckedRadioButtonId() == R.id.rbtnC) {

            if (!value.isEmpty()) {
                f = Double.parseDouble(value);
                c = (f - 32) * 5 / 9;
            }
        }else {
            if (!value.isEmpty()) {
                c = Double.parseDouble(edt.getText().toString());
                f = c * 9 / 5 + 32;
            }
        }

        txvC.setText(String.format("%.1f", c) + getResources().getString(R.string.txvC)) ;
        txvF.setText(String.format("%.1f", f) + getResources().getString(R.string.txvF));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        selection();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        selection();
    }
}
