package ucm.ac.mz.sociomatico.Controllers;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ucm.ac.mz.sociomatico.R;

public class MainActivity extends AppCompatActivity implements cultura.OnFragmentInteractionListener, curiosidades.OnFragmentInteractionListener, tecnologia.OnFragmentInteractionListener, fama.OnFragmentInteractionListener, desporto.OnFragmentInteractionListener,economia.OnFragmentInteractionListener, politica.OnFragmentInteractionListener, categorias.OnFragmentInteractionListener, internacional.OnFragmentInteractionListener,sociedade.OnFragmentInteractionListener {


    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    MenuItem item1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TabLayout tb = findViewById(R.id.tablayout);

        tb.addTab(tb.newTab().setText("Novidades"));
        tb.addTab(tb.newTab().setText("Internacional"));
        tb.addTab(tb.newTab().setText("Sociedade"));
        tb.addTab(tb.newTab().setText("Politica"));
        tb.addTab(tb.newTab().setText("Economia"));
        tb.addTab(tb.newTab().setText("Desporto"));
        tb.addTab(tb.newTab().setText("Fama"));
        tb.addTab(tb.newTab().setText("tecnologia"));
        tb.addTab(tb.newTab().setText("Cultura"));
        tb.addTab(tb.newTab().setText("Curiosidades"));

        tb.setTabGravity(TabLayout.GRAVITY_FILL);
        tb.setTabMode(TabLayout.MODE_SCROLLABLE);


       final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
       final ucm.ac.mz.sociomatico.Controllers.PagerAdapter adapter = new ucm.ac.mz.sociomatico.Controllers.PagerAdapter(getSupportFragmentManager(),tb.getTabCount());

       viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tb));


        tb.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab){
                viewPager.setCurrentItem(tab.getPosition());
            }



            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)){

            item1 = item;



            return super.onOptionsItemSelected(item);





        }


        return true;
    }



  public void abrirCategoria(MenuItem v){




      TabLayout tb = findViewById(R.id.tablayout);
      final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
      final ucm.ac.mz.sociomatico.Controllers.PagerAdapter adapter = new ucm.ac.mz.sociomatico.Controllers.PagerAdapter(getSupportFragmentManager(),tb.getTabCount());


      switch (""+v.getTitle()){
          case "Internacional":
              viewPager.setAdapter(adapter);
              viewPager.setCurrentItem(1);
              onOptionsItemSelected(item1);
              break;

          case "Sociedade":
              viewPager.setAdapter(adapter);
              viewPager.setCurrentItem(2);
              onOptionsItemSelected(item1);
              break;

          case "Politica":
              viewPager.setAdapter(adapter);
              viewPager.setCurrentItem(3);
              onOptionsItemSelected(item1);
              break;

          case "Economia":
              viewPager.setAdapter(adapter);
              viewPager.setCurrentItem(4);
              onOptionsItemSelected(item1);
              break;

          case "Desporto":
              viewPager.setAdapter(adapter);
              viewPager.setCurrentItem(5);
              onOptionsItemSelected(item1);
              break;

          case "Fama":
              viewPager.setAdapter(adapter);
              viewPager.setCurrentItem(6);
              onOptionsItemSelected(item1);
              break;

          case "Tecnologias":
              viewPager.setAdapter(adapter);
              viewPager.setCurrentItem(7);
              onOptionsItemSelected(item1);
              break;

          case "Cultura":
              viewPager.setAdapter(adapter);
              viewPager.setCurrentItem(8);
              onOptionsItemSelected(item1);
              break;

          case "Curiosidades":
              viewPager.setAdapter(adapter);
              viewPager.setCurrentItem(9);
              onOptionsItemSelected(item1);
              break;

          case "Definicões":
              break;
      }


  }





    @Override
    public void onFragmentInteraction(Uri uri) {




    }
}
