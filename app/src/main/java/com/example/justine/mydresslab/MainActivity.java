package com.example.justine.mydresslab;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private String[] mDrawerListValues;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mTitle;
    private ActionBarDrawerToggle mDrawerToggle;

    //Création d'une instance de ma classe VetementsBDD
    VetementsBDD vetementBDD = new VetementsBDD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = "Vetements et accessoires";

        mDrawerListValues = getResources().getStringArray(R.array.drawer_list_values);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);


        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_layout, mDrawerListValues));
        mDrawerList.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mDrawerListValues.length;
            }

            @Override
            public Object getItem(int position) {
                return mDrawerListValues[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                View view = inflater.inflate(R.layout.drawer_layout, parent, false);

                ImageView icon = (ImageView) view.findViewById(R.id.icon);
                TextView description = (TextView) view.findViewById(R.id.description_text_view);

                int resource = 0;

                if(position == 0){
                    resource = R.drawable.teeshirt;
                }
                else if(position == 1){
                    resource = R.drawable.robe;
                }
                else if(position == 2){
                    resource = R.drawable.pantalon;
                }
                else if(position == 3){
                    resource = R.drawable.sac;
                }
                else if(position == 4){
                    resource = R.drawable.chaussure;
                }
                else{
                    resource = R.drawable.veste;
                }

                icon.setImageResource(resource);
                description.setText(mDrawerListValues[position]);

                return view;
            }
        });
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position) {
        Toast.makeText(this, R.string.app_name, Toast.LENGTH_SHORT).show();
        int[] image =null;
        String [] ssType = null;

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        String choix = getResources().getStringArray(R.array.drawer_list_values)[position];
        switch (choix)
        {
            case("Hauts"):

                vetementBDD.open();
                //Vetements[] vetsFromBdd = vetementBDD.recupereTSdepuisType("HAUT");
                ssType = getResources().getStringArray(R.array.list_sstype_haut);
                ft.replace(R.id.fragment_placeholder, FragmentSsType.getInstance(ssType, new int[]{
                        R.drawable.teeshirtfondblanc, R.drawable.polofondblanc, R.drawable.pullfondblanc, R.drawable.debardeurfondblanc }));
                ft.commit();
                break;
            case("Robes"):

                break;
            case("Bas"):
                ssType = getResources().getStringArray(R.array.list_sstype_bas);
                ft.replace(R.id.fragment_placeholder, FragmentSsType.getInstance(ssType, new int[]{
                        R.drawable.pantalonfondblanc, R.drawable.shortpantacourtfondblanc, R.drawable.jupefondblanc}));
                ft.commit();
                break;
            case("Accessoires"):
                ssType = getResources().getStringArray(R.array.list_sstype_accessoire);
                ft.replace(R.id.fragment_placeholder, FragmentSsType.getInstance(ssType, new int[]{
                        R.drawable.sacfondblanc, R.drawable.lunettesfondblanc, R.drawable.cravatefondblanc, R.drawable.chapeaufondblanc}));
                ft.commit();
                break;
            case("Chaussures"):
                ssType = getResources().getStringArray(R.array.list_sstype_chaussure);
                ft.replace(R.id.fragment_placeholder, FragmentSsType.getInstance(ssType, new int[]{
                        R.drawable.tongfondblanc, R.drawable.talonfondblanc, R.drawable.bottefondblanc, R.drawable.autresfondblanc}));
                ft.commit();
                break;
            case("Manteaux"):
                break;
            default:
                break;
        }


        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mDrawerListValues[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

}