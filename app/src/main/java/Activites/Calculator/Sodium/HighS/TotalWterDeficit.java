package Activites.Calculator.Sodium.HighS;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class TotalWterDeficit extends AppCompatActivity {
EditText desiredNaE,serumNaE,bodyWaterE;
RadioGroup radioGroup;
double desiredNa,serumNa,category,result,bodyWater,bodyWeight;
TextView resultText;
Button calculate;
RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_wter_deficit);
        category=0.0;
        desiredNaE=findViewById(R.id.desirednaID);
        radioGroup=findViewById(R.id.radiogroupID);
        serumNaE=findViewById(R.id.serumnaID);
        resultText=findViewById(R.id.resultID);
        calculate=findViewById(R.id.calcID);
        bodyWaterE=findViewById(R.id.bodywaterID);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton=findViewById(checkedId);
                switch (radioButton.getId()){
                    case R.id.childrenID:
                        category=0.6;
                        break;
                    case R.id.womenID:
                        category=0.5;
                        break;
                    case R.id.menID:
                        category=0.6;
                        break;
                    case R.id.elderlywomenID:
                        category=0.45;
                        break;
                    case R.id.elderlymenID:
                        category=0.5;
                        break;

                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(desiredNaE.getText().toString().equals("")||serumNaE.getText().toString().equals("")||category==0.0||
                        bodyWaterE.getText().toString().equals("")))
                    calculate();
            }
        });

    }


    public void calculate(){
        desiredNa=Double.parseDouble(desiredNaE.getText().toString());
        serumNa=Double.parseDouble(serumNaE.getText().toString());
        bodyWeight=Double.parseDouble(bodyWaterE.getText().toString());
        bodyWater=bodyWeight*category;
        result=bodyWater*(1-(desiredNa/serumNa));
        String s="Total Water deficit = "+result+" L";
        resultText.setText(s);


    }
}
