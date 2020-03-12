package Activites.Calculator.Carbonate.LowP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class AnionGap extends AppCompatActivity {
EditText na;
EditText cl;
EditText hco3;
Button calculate;
TextView resultText;
double result,nan,cln,hco3n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anion_gap);
        calculate=findViewById(R.id.calc);
        na=findViewById(R.id.naID);
        cl=findViewById(R.id.clID);
        hco3=findViewById(R.id.hco3ID);
        resultText=findViewById(R.id.resID);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(cl.getText().toString().equals("")||na.getText().toString().equals("")|| hco3.getText().toString().equals("")))
                    calculate();
            }
        });
    }
    public void calculate(){
        nan=Double.parseDouble(na.getText().toString());
        cln=Double.parseDouble(cl.getText().toString());
        hco3n=Double.parseDouble(hco3.getText().toString());
        result=nan-(cln+hco3n);
        String string="Anion Gap= "+String.format("%.2f",result)+" mEq/L\n"+"Normal Anion Gap= 3 - 10 mEq/L";
        resultText.setText(string);
    }
}
