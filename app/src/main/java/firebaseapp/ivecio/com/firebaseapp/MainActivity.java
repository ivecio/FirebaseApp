package firebaseapp.ivecio.com.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference(); //recupera a instância do banco de dados - altera direto no BD
                                                                                                    // o reference pega o "root" do Firebase, a raiz principal
    private DatabaseReference usuarioReferencia = databaseReferencia.child("usuarios");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioReferencia.child("001").child("nome").setValue("Ivecio Filho");

    }
}
