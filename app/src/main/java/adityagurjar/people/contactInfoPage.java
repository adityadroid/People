package adityagurjar.people;

import android.Manifest;
import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class contactInfoPage extends AppCompatActivity {

    TextView emailInfo, phoneInfo, nameInfo, msgBtn, callBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontact_info_page);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String mail = intent.getExtras().getString("email");
     final String phone = intent.getExtras().getString("phone");
        getSupportActionBar().setTitle(name);

        emailInfo = (TextView) findViewById(R.id.textEmail);
        nameInfo = (TextView) findViewById(R.id.textName);
        phoneInfo = (TextView) findViewById(R.id.textNumber);
        msgBtn = (TextView) findViewById(R.id.messagebutton);
        callBtn = (TextView) findViewById(R.id.callbutton);
        emailInfo.setText(mail);
        phoneInfo.setText(phone);
        nameInfo.setText(name);
        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phone, null)));

            }
        });
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));

                startActivity(i);
            }
        });


    }
}
