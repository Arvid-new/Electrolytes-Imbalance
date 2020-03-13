package Activites.Calculator.Sodium.HighS;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.graduatioapp.R;

public class ArdogueFormula extends AppCompatActivity {
EditText serumNaE;
EditText bodyWeightE;
RadioGroup categoryR,infusateNaR,infusatekR;
double serumNa,category,infusateNa,infusateK,bodyWeight,constant=0;
RadioButton radioButton1, radioButton2, radioButton3;
Button calculate;
AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ardogue_formula);
        categoryR=findViewById(R.id.radiogroupID);
        infusateNaR=findViewById(R.id.infusatenaID);
        infusatekR=findViewById(R.id.infusatekID);
        serumNaE=findViewById(R.id.serumnaID);
        bodyWeightE=findViewById(R.id.bodyweightID);
        calculate=findViewById(R.id.calcID);
        categoryR.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton1=findViewById(checkedId);
                switch(radioButton1.getId()){
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

        infusateNaR.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton2=findViewById(checkedId);
                switch(radioButton2.getId()){
                    case R.id.naclID:
                        infusateNa=513;
                    break;
                    case  R.id.nsID:
                        infusateNa=154;
                        break;
                    case R.id.lactateringerID:
                        infusateNa=130;
                        break;
                    case R.id.naclnsID:
                        infusateNa=77;
                        break;
                    case R.id.dextroseID:
                        infusateNa=0;
                        break;
                }
            }
        });


        infusatekR.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton3=findViewById(checkedId);
                switch (radioButton3.getId()){
                    case R.id.mostfluidslID:
                        infusateK=0;
                        break;
                        case R.id.lactatedringerID:
                        infusateK=4;
                        break;
                    case R.id.ringeracetateID:
                        infusateK=5;
                        break;
                }
            }
        });

    calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!serumNaE.getText().toString().equals(""))
            calculate();
        }
    });





    }

    public void calculate(){
        builder=new AlertDialog.Builder(ArdogueFormula.this);
        serumNa=Double.parseDouble(serumNaE.getText().toString());
        bodyWeight=Double.parseDouble(bodyWeightE.getText().toString());
        double totalBodyWater=bodyWeight*category;
        double changeInSerumNa=((infusateNa+infusateK)-serumNa)/(totalBodyWater+1);
        double sodiumCorrectionRate=(1000*0.5*(totalBodyWater+1))/((infusateNa+infusateK)-serumNa);
        builder.setCancelable(false);
        builder.setTitle("Adrogue Formula");
        String s="Total Body Water = "+totalBodyWater+" L\n"+"Change in Serum Sodium = "+String.format("%.2f",changeInSerumNa)+" mmol/L or mEq/L\n"+
                "Sodium correction rate = "+String.format("%.2f",sodiumCorrectionRate)+ " ml/hr"+"\n\nExplanation : \n" +
                "Action to be taken is to decrease or increase Sodium by the value of (Change in Serum Sodium) and according the calculated value of the (Correction Rate).";
        builder.setMessage(s);
        builder.setNegativeButton("return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
AlertDialog dialog=builder.show();
dialog.show();
    }

}
