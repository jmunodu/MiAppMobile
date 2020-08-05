package cl.mundu.miappmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RegistroActivity extends AppCompatActivity {

    EditText telefono;
    ListView listView;
    Set<String> telefonos;
    ArrayList<String> telefonosArray;

    EditText name;
    EditText eMail;
    RadioGroup sexo;
    EditText pass1;
    EditText pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        telefono = findViewById(R.id.editTextPhone);

        listView = findViewById(R.id.listView);
        telefonos = new HashSet<String>();

        name = findViewById(R.id.txtName);
        eMail = findViewById(R.id.txtEMail);
        sexo = findViewById(R.id.radioGroupSexo);
        pass1 = findViewById(R.id.txtPasswordLogin);
        pass2 = findViewById(R.id.txtPass2);

        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean arg1) {
                Log.i("RegistroActiviy", "setOnFocusChangeListener [START] " + arg1);
                EditText et = (EditText) view;
                if (et.getText().toString().length() == 0 && arg1 == Boolean.FALSE) {
                    name.setError("Ingrese un Nombre");
                }
            }
        });

        eMail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean arg1) {
                Log.i("RegistroActiviy", "setOnFocusChangeListener [START] " + arg1);
                EditText et = (EditText) view;
                if (et.getText().toString().length() == 0 && arg1 == Boolean.FALSE) {
                    name.setError("Ingrese un Nombre");
                }
            }
        });

        pass2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean arg1) {
                Log.i("RegistroActiviy", "setOnFocusChangeListener [START] " + arg1);
                EditText et = (EditText) view;
                if (!et.getText().toString().equals(pass1.getText().toString()) && arg1 == Boolean.FALSE) {
                    pass2.setError("Contaseñas no son iguales");
                }
            }
        });
    }

    public void agregarTelefono(View view) {

        Log.i("RegistroActiviy", "agregarTelefono [START]");

        if (telefono.getText().toString().length() > 0) {
            // TODO: Ingresar telefono a ListView
            telefonos.add(telefono.getText().toString());
            telefonosArray= new ArrayList<String>(telefonos);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, telefonosArray);

            listView.setAdapter(adapter);
        } else {
            telefono.setError("Ingrese Teléfono");
        }
        Log.i("RegistroActiviy", "agregarTelefono [END]");
    }

    public void validarFormulario(View view) {
        Log.i("RegistroActiviy", "agregarTelefono [START]");

        if (name.getText().toString().length() == 0) {

        }

        Log.i("RegistroActiviy", "agregarTelefono [END]");

    }
}


