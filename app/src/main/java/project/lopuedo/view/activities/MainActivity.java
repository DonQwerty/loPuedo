package project.lopuedo.view.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import project.lopuedo.R;
import project.lopuedo.view.fragments.MainActivityFragment;
import project.lopuedo.view.fragments.RoundActivityFragment;
import project.lopuedo.view.fragments.ScoresActivityFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mMainButton;
    private int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, MainActivityFragment.newInstance()).commit();
        state = 0;
        mMainButton = (Button) findViewById(R.id.button_main);
        mMainButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        Fragment newFragment;

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);

        // To avoid compilation error
        newFragment = new MainActivityFragment();

        // TODO Esto nunca vuelve a MainActivityFragment.
        switch (state) {
            // to Round
            case 0:
                newFragment = RoundActivityFragment.newInstance();
                break;
            // to Scores
            case 1:
                newFragment = ScoresActivityFragment.newInstance();
                break;
        }
        ft.replace(R.id.fragment_container, newFragment);
        ft.commit();
        state = (state +1) % 2;
    }
}
