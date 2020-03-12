package Trees;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.graduatioapp.R;
import com.github.barteksc.pdfviewer.PDFView;

public class IronHyper extends AppCompatActivity {
PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron_hyper);
        Bundle bundle=getIntent().getExtras();
        String s=bundle.getString("tree");
        pdfView=findViewById(R.id.ironhyper);
        pdfView.fromAsset(s).load();
        }

    }
