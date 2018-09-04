package greg.ns.com.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import greg.ns.com.demo.fragmentadapter.CustomFragmentAdapter;

/**
 * Created by Gregory on 2016/7/15.
 */
public class BaseAppBarActivity extends AppCompatActivity
    implements
    NavigationView.OnNavigationItemSelectedListener,
    MenuItemCompat.OnActionExpandListener, SearchView.OnQueryTextListener {

  private ViewPager viewPager;
  private DrawerLayout drawerLayout;
  private Toolbar toolbar;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    initAppBar();
    initNavigationView();
    initViewPager();
    initTabLayout();
  }

  private void initAppBar() {
    CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingBar);
    collapsingToolbarLayout.setTitle("Material Design");

    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      //getSupportActionBar().setDisplayShowTitleEnabled(false);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setHomeButtonEnabled(true);
      //getSupportActionBar().setTitle("Material Design");
    }
  }

  private void initNavigationView() {
    drawerLayout = findViewById(R.id.drawer_layout);
    drawerLayout.setDrawerListener(
        new CustomActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer,
            R.string.closeDrawer));
    NavigationView navigationView = findViewById(R.id.navigation_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  private void initViewPager() {
    viewPager = findViewById(R.id.viewpager);
    viewPager.setAdapter(new CustomFragmentAdapter(getSupportFragmentManager()));
  }

  private void initTabLayout() {
    TabLayout tabLayout = findViewById(R.id.tablayout);
    tabLayout.setTabMode(TabLayout.MODE_FIXED);
    tabLayout.setupWithViewPager(viewPager);
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.toolbar_menu, menu);

    MenuItem editItem = menu.findItem(R.id.action_edit);
    editItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

    MenuItem menuSearchItem = menu.findItem(R.id.action_search);
    menuSearchItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
    SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuSearchItem);
    searchView.setMaxWidth(Integer.MAX_VALUE); // Set view to max width
    searchView.setOnQueryTextListener(this);
    MenuItemCompat.setOnActionExpandListener(menuSearchItem, this);

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    switch (id) {
      case R.id.action_edit:
        break;

      case R.id.action_search:
        break;

      default:
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem menuItem) {
    navigateTo();
    drawerLayout.closeDrawers();
    return true;
  }

  @Override
  public boolean onMenuItemActionExpand(MenuItem item) {
    return false;
  }

  @Override
  public boolean onMenuItemActionCollapse(MenuItem item) {
    return false;
  }

  @Override
  public boolean onQueryTextChange(String newText) {
    return false;
  }

  @Override
  public boolean onQueryTextSubmit(String query) {
    return false;
  }

  private void navigateTo() {

  }

  private static class CustomActionBarDrawerToggle extends ActionBarDrawerToggle {

    CustomActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout,
        Toolbar toolbar, @StringRes int openDrawerContentDescRes,
        @StringRes int closeDrawerContentDescRes) {
      super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);
      syncState();
    }

    @Override
    public void onDrawerClosed(View drawerView) {
      super.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
      super.onDrawerOpened(drawerView);
    }
  }
}
