package adityagurjar.people;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class contactInfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontact_info_page);
        Intent intent = getIntent();
        String name= intent.getExtras().getString("name");
        String mail = intent.getExtras().getString("email");
        String phone = intent.getExtras().getString("phone");
        Toast.makeText(contactInfoPage.this, ""+name+mail+phone, Toast.LENGTH_SHORT).show();

    }
}
