package com.example.gym;

import static com.example.gym.TrainingActivity.TRAINING_KEY;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PlanDetailsDialog extends DialogFragment {

    public interface PassPlanInterface{
        void getPlan(Plan plan);
    }

    private PassPlanInterface passPlanInterface;

    private Button dismissButton, addButton;
    private TextView txtTrainingName;
    private EditText minutesEditText;
    private Spinner daySpinner;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_plan_details,null);
        initialViews(view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Enter Details");

        Bundle bundle = getArguments();
        if (bundle != null){
            final Training training = bundle.getParcelable(TRAINING_KEY);

            if(training != null){
                txtTrainingName.setText(training.getName());

                dismissButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day  = daySpinner.getSelectedItem().toString();
                        int minutes = Integer.valueOf(minutesEditText.getText().toString());

                        Plan plan = new Plan(training, minutes, day, false);

                        try {
                            passPlanInterface = (PassPlanInterface) getActivity();
                            passPlanInterface.getPlan(plan);
                            dismiss();

                        }catch (ClassCastException e){
                            e.printStackTrace();
                            dismiss();
                        }
                    }
                });
            }
        }

        return builder.create();
    }

    private void initialViews(View view) {
        dismissButton = view.findViewById(R.id.dismissButton);
        addButton = view.findViewById(R.id.addButton);
        txtTrainingName = view.findViewById(R.id.txtTrainingName);
        minutesEditText = view.findViewById(R.id.minutesEditText);
        daySpinner = view.findViewById(R.id.daySpinner);



    }

}
