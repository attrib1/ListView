package com.example.admin.tut_non;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity4 extends ActionBarActivity {
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);

        ListView list = (ListView) findViewById(R.id.listView4);
        data = new ArrayList<String>();

        for (int i = 0; i < 799; i++) {
            data.add("data" + (i + 1));
        }
        list.setAdapter(new adapter2());

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplication(),"data "+(i+1),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class adapter2 extends BaseAdapter {

        Holder holder;

        @Override

        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getApplication()).inflate(R.layout.layoutlistview, null);
                holder = new Holder();
                holder.title = (TextView) view.findViewById(R.id.ListviewTitle);
                holder.title2 = (TextView)view.findViewById(R.id.ListviewTitle2);
                view.setTag(holder);
            } else {

                holder = (Holder)view.getTag();
            }
                holder.title.setText(data.get(i));
                holder.title2.setText(data.get(i));

            return view;
        }

        private class Holder {
            TextView title;
            TextView title2;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
