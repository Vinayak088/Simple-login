package jobs.mobile.com.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        LoginButton();
    }

    public void LoginButton(){
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        attempts=(TextView)findViewById(R.id.textView4);
        login_btn=(Button)findViewById(R.id.button);

        attempts.setText(Integer.toString(attempt_counter));

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("vinayak")&&
                        password.getText().toString().equals("vinayak088")){
                    Toast.makeText(getApplicationContext(),"user and password is correct",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),User.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"user and password is not correct",Toast.LENGTH_LONG).show();
                    attempt_counter--;
                    attempts.setText(Integer.toString(attempt_counter));
                }
                if (attempt_counter==0){
                    login_btn.setEnabled(false);
                }
            }
        });
    }
}
