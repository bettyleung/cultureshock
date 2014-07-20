package com.angelhacks.cultureshock;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.angelhacks.cultureshock.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class DestinationList extends ActionBarActivity {

    MyExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_list);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new MyExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.s
        getMenuInflater().inflate(R.menu.destination_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    * Preparing the list data
    */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("DINING");
        listDataHeader.add("COMMUNICATION");
        listDataHeader.add("SPECIAL_OCCASIONS");
        listDataHeader.add("TRANSIT");
        listDataHeader.add("BUSINESS");


        // Adding child data
        List<String> DINING= new ArrayList<String>();
        DINING.add("Food");
        DINING.add("Etiquette");

        List<String> COMMUNICATION = new ArrayList<String>();


        List<String> SPECIAL_OCCASIONS = new ArrayList<String>();

        List<String> TRANSIT= new ArrayList<String>();

        List<String> BUSINESS = new ArrayList<String>();

        listDataChild.put(listDataHeader.get(0), DINING); // Header, Child data
        listDataChild.put(listDataHeader.get(1), COMMUNICATION);
        listDataChild.put(listDataHeader.get(2), SPECIAL_OCCASIONS);
        listDataChild.put(listDataHeader.get(2), TRANSIT);
        listDataChild.put(listDataHeader.get(2), BUSINESS);
    }
}
