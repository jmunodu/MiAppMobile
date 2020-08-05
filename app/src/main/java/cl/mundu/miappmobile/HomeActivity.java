package cl.mundu.miappmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extras = getIntent().getExtras();

        Bundle bd = extras.getBundle("bd");

        textEmail = findViewById(R.id.txtEmailHome);
        textEmail.setText(bd.getString("email"));
    }
}
