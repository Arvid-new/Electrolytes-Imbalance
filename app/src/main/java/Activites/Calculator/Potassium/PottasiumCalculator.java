package Activites.Calculator.Potassium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class PottasiumCalculator extends AppCompatActivity {
RadioGroup radioGroup;
RadioButton radioButton;
EditText measuredKE;
EditText bodyWeightE;
Button calculateB;
TextView resultText;
TextView r2;
TextView r3;
float mk,bw;
double kdefec,dpr,tpd;
double c=0;
double nk=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pottasium_calculator);
        radioGroup=findViewById(R.id.radioGroup);
        measuredKE=findViewById(R.id.measuredKID);
        bodyWeightE=findViewById(R.id.bodyweightID);
        calculateB=findViewById(R.id.calculate);
        resultText=findViewById(R.id.resultID);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton=findViewById(checkedId);
                switch (radioButton.getId()){
                    case R.id.big: {
                        c = 0.6;
                        nk = 4;
                    }
                        break;
                    case R.id.small: {
                        c = 0.4;
                        nk = 3.5;
                    }
                        break;
                }
            }
        });

        calculateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(measuredKE.getText().toString().equals("")||bodyWeightE.getText().toString().equals("")||c==0)){
                    calculate();
                }
            }
        });
    }
    public void calculate(){
        mk=Float.parseFloat(measuredKE.getText().toString());
        bw=Float.parseFloat(bodyWeightE.getText().toString());
        kdefec=(nk-mk)*bw*c;
        dpr=1.0*bw;
        tpd=kdefec+dpr;
        String string1="K deficit ="+String.format("%.2f",kdefec)+ " mmol";
        String string2="Daily potassium requirement = "+String.format("%.2f",dpr)+ " mmol";
        String string3="Total potassium deficit = "+String.format("%.2f",tpd)+ " mmol";
        resultText.setText(string1);
        r2.setText(string2);
        r3.setText(string3);

    }
}
