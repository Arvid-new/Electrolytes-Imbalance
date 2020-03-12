package Activites.Calculator.Carbonate.LowP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class BicarbonateDeficit extends AppCompatActivity {
EditText desired;
EditText measured;
EditText bodyWeight;
Button calculate;
TextView resultText;
double ds,ms,bw,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicarbonate_deficit);
        desired=findViewById(R.id.desiredBi);
        measured=findViewById(R.id.measuredBi);
        bodyWeight=findViewById(R.id.bodyweight);
        calculate=findViewById(R.id.calculate);
        resultText=findViewById(R.id.textView8);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(desired.getText().toString().equals("")||measured.getText().toString().equals("")))
                    calculate();
            }
        });
    }

public void calculate(){
        ds=Double.parseDouble(desired.getText().toString());
        ms=Double.parseDouble(measured.getText().toString());
        bw=Double.parseDouble(bodyWeight.getText().toString());
        result=0.5*bw*(ds-ms);
        String string=" BiCarbonate Deficit = "+String.format("%.2f",result)+" mEq/L";
        resultText.setText(string);


}

}
