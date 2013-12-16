package edu.bu.cs575.jusunlee.rogueapp;

import java.util.List;

import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v4.widget.SimpleCursorAdapter;
import android.app.ListActivity;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.widget.ListAdapter;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// load contacts
		Cursor cursor = getContentResolver().query(RogueProvider.CONTENT_URI, 
				null,
				null, 
				null, 
				Phone.DISPLAY_NAME + " ASC");
		startManagingCursor(cursor);

		ListAdapter adapter = new SimpleCursorAdapter(this, 
				R.layout.list_item,
				cursor, 
				new String[] { Phone.DISPLAY_NAME, Phone.NUMBER },
				new int[] { R.id.contact_name, R.id.contact_number });
		setListAdapter(adapter);
		
//		// list all content providers that doesn't require permissions
//		List<ProviderInfo> providers = getPackageManager().queryContentProviders(null, 0, 0);
//		for (ProviderInfo p : providers) {
//			if (p.readPermission == null)
//				Log.d("PROVIDERS", p.toString());
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
