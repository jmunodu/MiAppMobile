package cl.mundu.miappmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmailLogin);
        txtPassword = findViewById(R.id.txtPasswordLogin);
    }

    public void btnRegistro(View vista) {
        Toast.makeText(MainActivity.this,"Registrar Usuario",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent (this, RegistroActivity.class);
        startActivity(intent);
    }

    public void btnLogin(View view) {

        Log.i("MainActivity", "btnLogin");

        Log.d("MainActivity", "email: [" + txtEmail.getText().toString() + "]");
        Log.d("MainActivity", "password: [" + txtPassword.getText().toString() + "]");

        // TODO: Pendiente validar user y pass correctos
        if (txtEmail.getText().toString().length() > 0 && txtPassword.getText().toString().length() > 0) {
            Intent intentLogin = new Intent (this, HomeActivity.class);

            // Forma 1:
            Bundle bd = new Bundle();
            bd.putString("email", txtEmail.getText().toString());

            intentLogin.putExtra("bd", bd);

            // Forma 2:
            intentLogin.putExtra("email", txtEmail.getText().toString());

            startActivity(intentLogin);
        } else {
            txtEmail.setError("Complete Email y contraseña");
        }

    }
}
