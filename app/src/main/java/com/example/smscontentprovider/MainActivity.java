package com.example.smscontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import java.util.List;
import android.provider.ContactsContract;

public class MainActivity extends AppCompatActivity {
    ListView listViewSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSms = findViewById(R.id.listViewSms);
        //Uri uriSms = Uri.parse("content://sms/inbox");
       // Uri uriContacts = Uri.parse("ContactsContract.Contacts.CONTENT_URI");
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

        /*CursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,new String[]{"body","address"},
                new int[]{android.R.id.text1,android.R.id.text2},0);*/
        CursorAdapter adapter = new SimpleCursorAdapter(this,
                                                        android.R.layout.simple_list_item_1,
                                                        cursor,
                                                        new String[]{ContactsContract.Contacts.DISPLAY_NAME},
                                                        new int[]{android.R.id.text1},
                                                        0);
       /*CursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,
                                                        cursor,
                                                        new String[]{"ContactsContract.Contacts.DISPLAY_NAME", Contacts.People.Phones.NUMBER},
                                                        new int[]{android.R.id.text1,android.R.id.text2},0);*/
        listViewSms.setAdapter(adapter);

    }
}
