package Activites.Calculator.Sodium.LowS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class CorrectedSodium extends AppCompatActivity {
EditText measuredSodiumE;
EditText serumglucoseE;
Button calculateB;
TextView resultText;
double ms,sg,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrected_sodium);
        measuredSodiumE=findViewById(R.id.measuredSodiumID);
        serumglucoseE=findViewById(R.id.serumglucoseID);
        calculateB=findViewById(R.id.calcID);
        resultText=findViewById(R.id.resultID);
        calculateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(measuredSodiumE.getText().toString().equals("")||serumglucoseE.getText().equals("")))
                   calculate();
            }
        });
    }
    public void calculate(){
        ms=Double.parseDouble(measuredSodiumE.getText().toString());
        sg=Double.parseDouble(serumglucoseE.getText().toString());
        result=ms+(0.016*(sg-100));
        String s="corrected Sodium = "+result+" mEq/L";
        resultText.setText(s);
    }
}
