package adityagurjar.people;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.meyerlaurent.cactv.AutoCompleteContactTextView;
import com.meyerlaurent.cactv.People;


public class MainActivity extends ActionBarActivity {

    AutoCompleteContactTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (AutoCompleteContactTextView) findViewById(R.id.coolStuff);
        textView.setThreshold(1);
        textView.setType(AutoCompleteContactTextView.TYPE_OF_DATA.BOTH);

        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                People selected = (People) textView.getAdapter().getItem(i);
                textView.setText(selected.getData().toString());

                Toast.makeText(getApplicationContext(),selected.getData().toString(),Toast.LENGTH_SHORT).show();


                //setText(selected.getName().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id){
//            case R.id.menu_phone:
//                textView.setType(AutoCompleteContactTextView.TYPE_OF_DATA.PHONE);
//                item.setChecked(true);
//                break;
//            case R.id.menu_mail:
//                item.setChecked(true);
//                textView.setType(AutoCompleteContactTextView.TYPE_OF_DATA.EMAIL);
//                break;
//            case R.id.menu_both:
//                item.setChecked(true);
//                textView.setType(AutoCompleteContactTextView.TYPE_OF_DATA.BOTH);
//                break;
//            case R.id.bold:
//                if (item.isChecked()){
//                    item.setChecked(false);
//                    textView.changeStyle(AutoCompleteContactTextView.STYLE.NONE);
//                }
//                else{
//                    item.setChecked(true);
//                    textView.changeStyle(AutoCompleteContactTextView.STYLE.BOLD);
//                }
//        }
        return true;
    }


}
