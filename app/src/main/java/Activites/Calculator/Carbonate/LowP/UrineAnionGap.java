package Activites.Calculator.Carbonate.LowP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.graduatioapp.R;

public class UrineAnionGap extends AppCompatActivity {
    EditText na;
    EditText cl;
    EditText k;
    Button calculate;
    TextView resultText;
    double result,nan,cln,kn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urine_anion_gap2);
        calculate=findViewById(R.id.calc);
        na=findViewById(R.id.naID);
        cl=findViewById(R.id.clID);
        k=findViewById(R.id.kID);
        resultText=findViewById(R.id.resID);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(cl.getText().toString().equals("")||na.getText().toString().equals("")|| k.getText().toString().equals("")))
                    calculate();
            }
        });
    }
    public  void calculate(){
        nan=Double.parseDouble(na.getText().toString());
        cln=Double.parseDouble(cl.getText().toString());
        kn=Double.parseDouble(k.getText().toString());
        result=nan+kn-cln;
        String string="UAG= "+String.format("%.2f",result)+" mEq/L\n"+"Normal UAG= -10 - 20 mEq/L";
        resultText.setText(string);
    }
}
