package pl.akademiakodu.homework3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editTextLogin)
    EditText editTextLogin;
    @BindView(R.id.editTextPass)
    EditText editTextPass;
    @BindView(R.id.textViewPass)
    TextView Pass;
    @BindView(R.id.textViewLogin)
    TextView Login;

    StringBuffer login = new StringBuffer();
    StringBuffer pass = new StringBuffer();
    String correctLog = "admin";
    String correctPass = "password";

    public void alertDialog(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonLog)
    public void log() {

        login.delete(0, login.length());
        pass.delete(0, pass.length());

        login.append(editTextLogin.getText());
        pass.append(editTextPass.getText());


        if (login.toString().equals(correctLog)) {
            if (correctPass.equals(pass.toString())) {

                Intent intent = new Intent(this, ChoiceActivity.class);
                startActivity(intent);
            } else {
                alertDialog("Wrong password");
                Toast.makeText(this, "Access denied", Toast.LENGTH_LONG).show();

            }

            Toast.makeText(this, "Access granded", Toast.LENGTH_LONG).show();
            InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            keyboard.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        } else {
            alertDialog("Wrong login");
            Toast.makeText(this, "Access denied", Toast.LENGTH_LONG).show();
        }
    }

}
