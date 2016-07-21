package jlexdev.com.fabanimation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;


/** Fuente:
 *
 *  https://www.learn2crack.com/2015/10/android-floating-action-button-animations.html
 *  (Nuestro Proyecto tiene 4 Animaciones)
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Boolean isFabOpen = false;
    private FloatingActionButton fabAdd, fabDone, fabFavorite;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Fabs
        fabAdd = (FloatingActionButton)findViewById(R.id.fab_add);
        fabDone = (FloatingActionButton)findViewById(R.id.fab_done);
        fabFavorite = (FloatingActionButton)findViewById(R.id.fab_favorite);

        // Animations
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);

        // Llamar a Eventos
        fabAdd.setOnClickListener(this);
        fabDone.setOnClickListener(this);
        fabFavorite.setOnClickListener(this);
    }

    // Eventos Fab
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab_add:
                animateFab();
                break;

            case R.id.fab_done:
                Snackbar.make(v, "Fab Done", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.fab_favorite:
                Snackbar.make(v, "Fab Favorite", Snackbar.LENGTH_SHORT).show();
                break;
        }

    }

    // Metodo Animate
    private void animateFab() {
        if (isFabOpen){
            fabAdd.startAnimation(rotate_backward);
            fabDone.startAnimation(fab_close);
            fabFavorite.startAnimation(fab_close);
            fabDone.setClickable(false);
            fabFavorite.setClickable(false);
            isFabOpen = false;

            Toast.makeText(getApplicationContext(), "Close", Toast.LENGTH_SHORT).show();
        } else {
            fabAdd.startAnimation(rotate_forward);
            fabDone.startAnimation(fab_open);
            fabFavorite.startAnimation(fab_open);
            fabDone.setClickable(true);
            fabFavorite.setClickable(true);
            isFabOpen = true;

            Toast.makeText(getApplicationContext(), "Open", Toast.LENGTH_SHORT).show();
        }
    }

}
