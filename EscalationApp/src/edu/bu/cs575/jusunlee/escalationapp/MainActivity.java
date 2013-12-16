package edu.bu.cs575.jusunlee.escalationapp;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v4.widget.SimpleCursorAdapter;
import android.app.ListActivity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.ListAdapter;

public class MainActivity extends ListActivity {

	public static final Uri ROGUE_CONTENT_URI = Uri.parse("content://edu.bu.cs575.jusunlee.rogueapp.rogueprovider");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Cursor cursor = getContentResolver().query(ROGUE_CONTENT_URI, 
				null,
				null, 
				null, 
				Phone.DISPLAY_NAME + " ASC");
		
		ListAdapter adapter = new SimpleCursorAdapter(this, 
				R.layout.list_item,
				cursor, 
				new String[] { Phone.DISPLAY_NAME, Phone.NUMBER },
				new int[] { R.id.contact_name, R.id.contact_number });
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
