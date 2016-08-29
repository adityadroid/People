package adityagurjar.people;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.widget.EditText;

import java.util.ArrayList;

public class Add_Contact extends AppCompatActivity {

    EditText userNameField,userEmailField,userNumberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userNameField=(EditText)findViewById(R.id.userName);
        userEmailField=(EditText)findViewById(R.id.userEmail);
        userNumberField=(EditText)findViewById(R.id.userPhoneNuber);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userEmailField.getText().toString().isEmpty()
                        ||userNameField.getText().toString().isEmpty()
                        ||userNumberField.getText().toString().isEmpty()) {
                    Snackbar.make(userNameField,"One or more fields Empty!",Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    String Name = userNameField.getText().toString();
                    String Email= userEmailField.getText().toString();
                    String Phone = userNumberField.getText().toString();


                    WritePhoneContact(Name,Phone,Email,getApplicationContext());

                }




            }
        });
    }




    public void WritePhoneContact(String displayName, String number,String email,Context cntx )
    {
        Context contetx 	= cntx;
        String strDisplayName 	=  displayName;
        String strNumber 	=  number;
        String strEmail = email;

        ArrayList<ContentProviderOperation> cntProOper = new ArrayList<ContentProviderOperation>();
        int contactIndex = cntProOper.size();

        cntProOper.add(ContentProviderOperation.newInsert(RawContacts.CONTENT_URI)//Step1
                .withValue(RawContacts.ACCOUNT_TYPE, null)
                .withValue(RawContacts.ACCOUNT_NAME, null).build());

        cntProOper.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)//Step2
                .withValueBackReference(Data.RAW_CONTACT_ID,contactIndex)
                .withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE)
                .withValue(StructuredName.DISPLAY_NAME, strDisplayName) // Name of the contact
                .build());
        //Mobile number will be inserted in ContactsContract.Data table
        cntProOper.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)//Step 3
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID,contactIndex)
                .withValue(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE)
                .withValue(Phone.NUMBER, strNumber) // Number to be added
                .withValue(Phone.TYPE, Phone.TYPE_MOBILE).build()); //Type like HOME, MOBILE etc

        cntProOper.add(ContentProviderOperation
                .newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID,
                        contactIndex)
                .withValue(Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Email.DATA, strEmail)
                .withValue(Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Email.TYPE, "2").build());

        boolean status=true;
        try
        {

            ContentProviderResult[] contentProresult = null;
            contentProresult = contetx.getContentResolver().applyBatch(ContactsContract.AUTHORITY, cntProOper); //apply above data insertion into contacts list
        }
        catch (RemoteException exp)
        {
            Snackbar.make(userNameField,"Error Occured!",Snackbar.LENGTH_SHORT).show();
            status=false;
        }
        catch (OperationApplicationException exp)
        {
            Snackbar.make(userNameField,"Error Occured!",Snackbar.LENGTH_SHORT).show();
            status=false;

        }
        if(status)
        {

            Snackbar.make(userNameField,"Contact Added!",Snackbar.LENGTH_SHORT).show();
            userNumberField.setText("");
            userEmailField.setText("");
            userNameField.setText("");


        }
    }
}
