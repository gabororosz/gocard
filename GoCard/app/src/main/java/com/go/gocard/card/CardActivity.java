package com.go.gocard.card;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.go.gocard.gocard.R;
import com.go.gocard.model.Card;

public class CardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getActionBar().hide();

        final CardDependencies dependencies = new CardDependencies(this);

        setupFragment(savedInstanceState, dependencies.getCardFragment());
    }

    private void setupFragment(Bundle savedInstanceState, CardFragment cardFragment) {
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, cardFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}