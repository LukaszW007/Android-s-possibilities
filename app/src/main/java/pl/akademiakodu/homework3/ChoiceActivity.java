package pl.akademiakodu.homework3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChoiceActivity extends AppCompatActivity {
    public Integer ileHappy;
    @BindView(R.id.textViewIle)
    TextView ile;
    @BindView(R.id.editTextIle)
    EditText EditIle;
    @BindView(R.id.happyOrNotButton)
    public Button happyOrNotButton;
    @BindView(R.id.buttonAnimation)
    public Button animation;
    @BindView(R.id.buttonCalculator)
    public Button calculator;
    @BindView(R.id.buttonHappy)
    public Button happy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        ButterKnife.bind(this);

    }

    public void alertDialog(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("ERROR");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setMessage(message);
        alertDialog.show();
    }
    @OnClick(R.id.happyOrNotButton)
    public void happiness() throws IllegalStateException {
        ileHappy = Integer.parseInt(EditIle.getText().toString());
        try {

            if (ileHappy > 100) {
                throw new IllegalStateException();

            } else {
                Intent intentHappy = new Intent(this, ImageActivity.class);
                intentHappy.putExtra("howMuch", ileHappy);
                startActivity(intentHappy);
            }
        } catch (IllegalStateException e) {
            alertDialog("Number range is 0-100");

        }
    }
    @OnClick(R.id.buttonCalculator)
    public void calculator(){
        Intent intentCalc = new Intent(this, CalculatorActivity.class);
        startActivity(intentCalc);
    }
    @OnClick(R.id.buttonHappy)
    public void happy(){
        ile.setVisibility(View.VISIBLE);
        EditIle.setVisibility(View.VISIBLE);
        EditIle.setInputType(InputType.TYPE_CLASS_NUMBER);
        InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        keyboard.showSoftInput(EditIle, InputMethodManager.SHOW_IMPLICIT);
        happyOrNotButton.setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.buttonAnimation)
    public void animation(){
        Intent intentAnim = new Intent(this, AnimationActivity.class);
        startActivity(intentAnim);
    }
}
