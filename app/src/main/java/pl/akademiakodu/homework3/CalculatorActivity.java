package pl.akademiakodu.homework3;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button buttonC, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonDel, buttonMulti, buttonMinus, buttonAdd, buttonEqu;
    StringBuffer readLine = new StringBuffer();
    int firstNumber, secondNumber, endOfFirstNumber, interresult;
    Integer result;
    String charArit;
    @BindView(R.id.progressBar)
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        textView = (TextView) findViewById(R.id.textView);
        button0 = (Button) findViewById((R.id.button0));
        button1 = (Button) findViewById((R.id.button1));
        button2 = (Button) findViewById((R.id.button2));
        button3 = (Button) findViewById((R.id.button3));
        button4 = (Button) findViewById((R.id.button4));
        button5 = (Button) findViewById((R.id.button5));
        button6 = (Button) findViewById((R.id.button6));
        button7 = (Button) findViewById((R.id.button7));
        button8 = (Button) findViewById((R.id.button8));
        button9 = (Button) findViewById((R.id.button9));
        buttonC = (Button) findViewById((R.id.buttonC));
        buttonMulti = (Button) findViewById((R.id.buttonMulti));
        buttonDel = (Button) findViewById((R.id.buttonDel));
        buttonAdd = (Button) findViewById((R.id.buttonAdd));
        buttonMinus = (Button) findViewById((R.id.buttonMinus));
        buttonEqu = (Button) findViewById((R.id.buttonEqu));
        readLine.delete(0, readLine.length());

        ButterKnife.bind(this);



        /*
        UWAGI:
       należałoby zmienić jeszcze:
       -if'y na Switch
       -możnaby również oprogramować button'y metodami public void buttonProcedure(String digit){}
       - poległem z obsługą błedu dzielenia przez 0 i za dużo czasu na tym straciłem, toteż zabrakło czasu zeby zrefaktoryzować resztę kodu
       -powinnien być zmieniony również layout ale po zmianie na inny trzeba wszystko od nowa poustawiać na ekranie, więc zrezygnowałem
         */


    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId()){
            case R.id.button0:
                readLine.append("0");
                textView.setText(readLine.toString());
            case R.id.button1:
                readLine.append("1");
                textView.setText(readLine.toString());
        }*/
        if (button0.getId() == v.getId()) {
            if (result == null) {
                readLine.append("0");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("0");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }
        if (button1.getId() == v.getId()) {
            if (result == null) {
                readLine.append("1");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("1");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }
        if (button2.getId() == v.getId()) {
            if (result == null) {
                readLine.append("2");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("2");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }
        if (button3.getId() == v.getId()) {
            if (result == null) {
                readLine.append("3");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("3");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }
        if (button4.getId() == v.getId()) {
            if (result == null) {
                readLine.append("4");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("4");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }
        if (button5.getId() == v.getId()) {
            if (result == null) {
                readLine.append("5");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("5");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }
        if (button6.getId() == v.getId()) {
            if (result == null) {
                readLine.append("6");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("6");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }
        if (button7.getId() == v.getId()) {
            if (result == null) {
                readLine.append("7");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("7");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }
        if (button8.getId() == v.getId()) {
            if (result == null) {
                readLine.append("8");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("8");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }
        if (button9.getId() == v.getId()) {
            if (result == null) {
                readLine.append("9");
                textView.setText(readLine.toString());
                enableButtons();
            } else {
                readLine.delete(0, readLine.length());
                textView.setText("");
                result = null;
                readLine.append("9");
                textView.setText(readLine.toString());
                enableButtons();
            }
        }

        if (buttonDel.getId() == v.getId()) {
            firstNumber = Integer.parseInt(readLine.toString());
            endOfFirstNumber = readLine.length();
            readLine.append("/");
            charArit = "/";
            textView.setText(readLine.toString());
            buttonEqu.setEnabled(true);
        }
        if (buttonMulti.getId() == v.getId()) {
            firstNumber = Integer.parseInt(readLine.toString());
            endOfFirstNumber = readLine.length();
            readLine.append("*");
            charArit = "*";
            textView.setText(readLine.toString());
            buttonEqu.setEnabled(true);
        }
        if (buttonMinus.getId() == v.getId()) {
            firstNumber = Integer.parseInt(readLine.toString());
            endOfFirstNumber = readLine.length();
            readLine.append("-");
            charArit = "-";
            textView.setText(readLine.toString());
            buttonEqu.setEnabled(true);
        }
        if (buttonAdd.getId() == v.getId()) {
            firstNumber = Integer.parseInt(readLine.toString());
            endOfFirstNumber = readLine.length();
            readLine.append("+");
            charArit = "+";
            textView.setText(readLine.toString());
            buttonEqu.setEnabled(true);
        }
        if (buttonC.getId() == v.getId()) {
            textView.setText("");
            readLine.delete(0, readLine.length());
        }
        if (buttonEqu.getId() == v.getId()) {
            secondNumber = Integer.parseInt(readLine.substring(endOfFirstNumber + 1));
            NewTask newTask = new NewTask();
            newTask.execute();
            progressBar.setProgress(0);
            buttonEqu.setEnabled(false);
            disableButtons();
        }
    }

    public void enableButtons() {
        buttonAdd.setEnabled(true);
        buttonDel.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonMulti.setEnabled(true);
    }

    public void disableButtons() {
        buttonAdd.setEnabled(false);
        buttonDel.setEnabled(false);
        buttonMinus.setEnabled(false);
        buttonMulti.setEnabled(false);
    }

    public void alertDialog(String message) {
        AlertDialog alertDialog2 = new AlertDialog.Builder(this).create();
        alertDialog2.setMessage(message);
        alertDialog2.setTitle("error");
        alertDialog2.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog2.show();
    }

    public class NewTask extends AsyncTask<Void, Integer, Integer> {

        @Override
        protected Integer doInBackground(Void... params) throws ArithmeticException {
            for (int i = 0; i <= 1; i++) {
                publishProgress(i);
                try {
                    Thread.sleep(150);
                    switch (charArit) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "/":
                            if (secondNumber == 0) {
                                alertDialog("Forbidden dividing by zero");
                            } else {
                                result = firstNumber / secondNumber;
                            }
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        public void onPostExecute(Integer args) {
            readLine.append("=" + result.toString());
            textView.setText(readLine.toString());
        }

        @Override
        public void onProgressUpdate(Integer... args) {
            progressBar.setProgress(args[0]);
        }
    }


}


