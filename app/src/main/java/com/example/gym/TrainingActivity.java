package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity implements PlanDetailsDialog.PassPlanInterface {

    private TextView trainingNameTextView, longDescriptionTextView;
    private ImageView image;
    private Button addToPlanButton;

    public static final String TRAINING_KEY = "training";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        initialViews();

        Intent intent = getIntent();
        if(intent !=null){
            Training training = intent.getParcelableExtra(TRAINING_KEY);
            if(training != null){
                trainingNameTextView.setText(training.getName());
                longDescriptionTextView.setText(training.getLongDescription());
                Glide.with(this)
                        .asBitmap()
                        .load(training.getImageURL())
                        .into(image);

                addToPlanButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 2023/04/21 show with the dialog
                        PlanDetailsDialog planDetailsDialog = new PlanDetailsDialog();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(TRAINING_KEY,training);
                        planDetailsDialog.setArguments(bundle);
                        planDetailsDialog.show(getSupportFragmentManager(),"Plan detail dialog");
                    }
                });
            }
        }
    }

    public void initialViews(){

        trainingNameTextView = findViewById(R.id.trainingNameTextView);
        longDescriptionTextView = findViewById(R.id.longDescriptionTextView);
        image = findViewById(R.id.image);
        addToPlanButton = findViewById(R.id.addToPlanButton);
    }

    @Override
    public void getPlan(Plan plan) {
        Log.d("training Activity", plan.toString());

        if(Utils.addPlan(plan)){
            Toast.makeText(this,"plan added successfully",Toast.LENGTH_LONG).show();
            // TODO: 2023/04/22 navigate the user to plan activity
            Intent intent = new Intent(this, PlanActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }
}