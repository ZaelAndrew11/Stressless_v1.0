package cl.aguzman.stressless.views.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import cl.aguzman.stressless.R;
import cl.aguzman.stressless.models.Pending;
import cl.aguzman.stressless.views.main.PendingsFragment;

public class DetailsActivity extends AppCompatActivity {

    private Pending pending;
    private EditText contentDescripction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        contentDescripction = (EditText) findViewById(R.id.contentLong);
        long idPending = getIntent().getLongExtra(PendingsFragment.PENDING_ID, 0);
        if(idPending != 0){
            pending = Pending.findById(Pending.class, idPending);
            getSupportActionBar().setTitle(pending.getName());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(pending.getDescription() != null){
            contentDescripction.setText(pending.getDescription());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Editable contentNewDescription = contentDescripction.getText();
        pending.setDescription(String.valueOf(contentNewDescription));
        pending.save();
        Toast.makeText(this, "Descripción Guardada", Toast.LENGTH_SHORT).show();
    }
}
