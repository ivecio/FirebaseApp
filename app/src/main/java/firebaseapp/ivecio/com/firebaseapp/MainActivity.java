package firebaseapp.ivecio.com.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference(); //recupera a instância do banco de dados - altera direto no BD
                                                                                                    // o reference pega o "root" do Firebase, a raiz principal
    private DatabaseReference usuarioReferencia = databaseReferencia.child("usuarios");
    private DatabaseReference produtoReferencia = databaseReferencia.child("produtos").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Usuario usuario = new Usuario();
        usuario.setNome("Guilherme");
        usuario.setSobrenome("Favretto");
        usuario.setIdade(11);
        usuario.setSexo("masculino");

        usuarioReferencia.child("003").setValue(usuario);

        Produto produto = new Produto();
        produto.setCor("Amarelo");
        produto.setDecricao("Produto amarelo");
        produto.setFabricante("Empresa Amarela");

        produtoReferencia.child("001").setValue(produto);
        */

        produtoReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
