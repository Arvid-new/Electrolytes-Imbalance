package Activites.Iron;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.graduatioapp.R;

import Activites.SimpleViewHolder;
import Interfaces.CreateTree;
import de.blox.treeview.BaseTreeAdapter;
import de.blox.treeview.TreeNode;
import de.blox.treeview.TreeView;

public class IronHyperTree extends AppCompatActivity implements CreateTree {
    BaseTreeAdapter<SimpleViewHolder> baseAdapter;
    BaseTreeAdapter<SimpleViewHolder> baseAdapter2;
TreeView treeView;
TreeView treeView2;
String tree;
TreeNode root;
TreeNode root2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron_tree);
        treeView=findViewById(R.id.treeView);

        Bundle bundle=getIntent().getExtras();
        tree=bundle.getString("type");
        if(tree.equals("hemo")) {
            createHyperTree();
            baseAdapter.setRootNode(root);
            treeView.setAdapter(baseAdapter);

        }else if(tree.equals("chelating")) {
            createHypoTree();
            baseAdapter2.setRootNode(root2);
            treeView.setAdapter(baseAdapter2);
        }

    }



    @Override
    public void createHypoTree() {
        baseAdapter2=new BaseTreeAdapter<SimpleViewHolder>(this,R.layout.node){

            @NonNull
            @Override
            public SimpleViewHolder onCreateViewHolder(View view) {
                return new SimpleViewHolder(view);
            }

            @Override
            public void onBindViewHolder(SimpleViewHolder simpleViewHolder, Object data, int position) {
                simpleViewHolder.textView.setText(data.toString());
            }
        };

        root2=new TreeNode("Iron chelating agents (*1)");
        //level 1
        TreeNode childA1=new TreeNode("Deferoxamine (DFO) Desferal®");
        TreeNode childB1=new TreeNode("Deferiprone (DFP) Ferriprox®");
        TreeNode childC1=new TreeNode("Deferasirox (DFX) Deferoxinova®");
        root2.addChildren(childA1,childB1,childC1);

        ///level2

        TreeNode childA2=new TreeNode("Administration and Dose 40mg/kg SC or IV\n" +
                "continuous infusion over 8-12 hrs for 5" +
                "nights" +
                "Precautions 1)Causes pain , pruritus and " +
                "swelling upon administration so add " +
                "antihistaminic or hydrocortisone in " +
                "infusion bag \n2) not used for chronic " +
                "therapy");
        TreeNode childB2=new TreeNode("Administration and Dose 20-30 mg/kg/day " +
                "diluted in water or juice\n" +
                "Precautions 1) monitor serum creatinine (if " +
                "increased ⅓ than normal value ) therefore " +
                "decrease dose initially by 10mg/kg/day \n2)" +
                "diarrhea and skin complications may be seen " +
                "Notes Effective in chronic blood transfusion");
        TreeNode childC2=new TreeNode("Administration and Dose 75mg/kg/day divided on " +
                "3 doses , Oral tabs or syrup\n" +
                "Precautions 1)monitor neutropenia and " +
                "agranulocytosis so is nor responding perform CBC " +
                "test/week\n" +
                "Notes Effective to decrease liver iron " +
                "concentration and cardiac iron over load");

        childA1.addChild(childA2);
        childB1.addChild(childB2);
        childC1.addChild(childC2);

        //level 3

        TreeNode A3=new TreeNode("Monitor therapy progress by serum ferritin every 2 -4 weeks");
        TreeNode B3=new TreeNode("Monitor therapy progress by serum ferritin every 2 -4 weeks");
        TreeNode C3=new TreeNode("Monitor therapy progress by serum ferritin every 2 -4 weeks");
        TreeNode A31=new TreeNode("Combination of DFO+DFP if " +
                "DFO alone is not responding\n" +
                "or increased cardiac toxicity");
        TreeNode B31=new TreeNode("Combination of DFO+DFP if " +
                "DFO alone is not responding\n" +
                "or increased cardiac toxicity");
        childA2.addChildren(A3,A31);
        childB2.addChildren(B3,B31);
        childC2.addChild(C3);


    }

    @Override
    public void createHyperTree() {
        baseAdapter=new BaseTreeAdapter<SimpleViewHolder>(this,R.layout.node){

            @NonNull
            @Override
            public SimpleViewHolder onCreateViewHolder(View view) {
                return new SimpleViewHolder(view);
            }

            @Override
            public void onBindViewHolder(SimpleViewHolder simpleViewHolder, Object data, int position) {
                simpleViewHolder.textView.setText(data.toString());
            }
        };


        root=new TreeNode("Hemochromatosis");

        TreeNode child1=new TreeNode("1) History of liver disease (*1)\n" +
                "2)General symptoms (fatigue , malaise and\n" +
                "abdominal pain) (*1)\n");
        root.addChild(child1);
        TreeNode child2=new TreeNode("1) Serum ferritin (SF) (>300μg/L in men and post menopausal\n" +
                "women) and (>200 μg/L in premenopausal women) (*2)\n" +
                "2) Total iron binding capacity (TIBC) (*2)\n" +
                "3) Calculate transferrin saturation (STS) (>45%) (*2)\n");
        child1.addChild(child2);

        TreeNode child3=new TreeNode("Normal STS (<45%) (*2)\n" +
                "Elevated SF (>200-300 μg/L");
        TreeNode child31=new TreeNode("Elevated STS (>45%) (*2)\n" +
                "Elevated SF (>200-300 μg/L )\n");
        child2.addChild(child3);
        child2.addChild(child31);




        TreeNode child4=new TreeNode("1)Evaluate other causes as (anemias ,\n" +
                "metabolic disorder, inflammation and\n" +
                "liver disease) 2)Treat underlining cause\n" +
                "3) ∓ liver biopsy (*1)\n");
        child3.addChild(child4);


        TreeNode child41=new TreeNode("Family history of genetic hemochromatosis\n" +
                "HFE genotyping\n" +
                "∓ liver biopsy\n");
        child31.addChild(child41);



        TreeNode child5=new TreeNode("Resolved\n");
        TreeNode child51=new TreeNode("Persistent elevated SF\n");
        child4.addChild(child51);
        child4.addChild(child5);

        TreeNode child61=new TreeNode("Iron overload detected so consider\n" +
                "causes including ferroportin disease (*3)\n");
        child51.addChild(child61);
        TreeNode childA=new TreeNode("Check absence of hereditary hemochromatosis by genotyping (*1)\n");
        TreeNode childB=new TreeNode("Hereditary Hemochromatosis\n");
        TreeNode childC=new TreeNode("Secondary Hemochromatosis\n");
        child61.addChild(childA);
        childA.addChildren(childB,childC);
        TreeNode childD=new TreeNode("Age>40\n" +
                "Hepatomegaly\n" +
                "Elevated ALT ,AST\n" +
                "± liver biopsy\n");
        TreeNode childD1=new TreeNode("Age>40\n" +
                "Hepatomegaly\n" +
                "Elevated ALT ,AST\n" +
                "± liver biopsy\n");

        childC.addChild(childD);
        child41.addChild(childD1);
        TreeNode childE=new TreeNode("Check for organ damage or cirrhosis\n");
        TreeNode childE1=new TreeNode("Check for organ damage or cirrhosis\n");

        childD.addChild(childE);
        childD1.addChild(childE1);
        TreeNode childF=new TreeNode("Phlebotomy + Iron chelating agents (*1)\n");
        TreeNode childF1=new TreeNode("Phlebotomy + Iron chelating agents (*1)\n");
        childE.addChild(childF);
        childE1.addChild(childF1);





    }
}
