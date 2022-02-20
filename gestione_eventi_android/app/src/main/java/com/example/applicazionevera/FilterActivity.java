package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {

    private Chip chipIntr, chipServ, chipCult, chipSport;
    private Chip chipLtoH, chipHtoL;
    private Button btnsalva;
    private ArrayList<String> selectedChipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        chipIntr = findViewById(R.id.chipIntr);
        chipServ = findViewById(R.id.chipServ);
        chipCult = findViewById(R.id.chipCult);
        chipSport = findViewById(R.id.chipSport);
        chipLtoH = findViewById(R.id.chipbassoalto);
        chipHtoL = findViewById(R.id.chipAltobasso);
        selectedChipData = new ArrayList<>();

        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    selectedChipData.add(compoundButton.getText().toString());
                }
                else {
                    selectedChipData.remove(compoundButton.getText().toString());
                }
            }
        };

        chipIntr.setOnCheckedChangeListener(checkedChangeListener);
        chipServ.setOnCheckedChangeListener(checkedChangeListener);
        chipCult.setOnCheckedChangeListener(checkedChangeListener);
        chipSport.setOnCheckedChangeListener(checkedChangeListener);
        chipLtoH.setOnCheckedChangeListener(checkedChangeListener);
        chipHtoL.setOnCheckedChangeListener(checkedChangeListener);

        btnsalva = findViewById(R.id.buttonApply);
        btnsalva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("data", selectedChipData.toString());
                setResult(104, resultIntent);
                finish();
            }
        });

    }
}