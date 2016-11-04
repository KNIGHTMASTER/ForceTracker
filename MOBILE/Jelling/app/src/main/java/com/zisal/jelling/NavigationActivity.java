package com.zisal.jelling;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;

import com.tripoin.tripoin_component.ui.activity.impl.HomeBaseActivity;
import com.tripoin.tripoin_component.ui.fragment.impl.MainFragment;
import com.tripoin.tripoin_component.ui.fragment.impl.ViewPagerFragment;

import br.liveo.Model.HelpLiveo;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;

/**
 * Created on 9/20/2016 : 6:31 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class NavigationActivity extends HomeBaseActivity implements OnItemClickListener{

    protected HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle bundle) {
        // User Information
        userName.setText("Hasim Kurniawan");
        userEmail.setText("Banyuwangi");
        userPhoto.setImageResource(R.drawable.hasim_kurniawan);
        userBackground.setImageResource(com.tripoin.tripoin_component.R.drawable.ic_user_background_first);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.map_force), R.drawable.ic_map_red_500_18dp);
        mHelpLiveo.add(getString(R.string.add_force), R.drawable.ic_add_location_red_500_18dp);
        mHelpLiveo.add(getString(R.string.manage_force), R.drawable.ic_group_red_a700_18dp);

        //with(this, Navigation.THEME_DARK). add theme dark
        //with(this, Navigation.THEME_LIGHT). add theme light

        with(this) // default theme is dark
                .startingPosition(0) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(com.tripoin.tripoin_component.R.string.settings, com.tripoin.tripoin_component.R.mipmap.ic_settings_black_24dp)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();
    }

    @Override
    public void onItemClick(int position) {
        Fragment mFragment;
        FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (position){
            case 0:
                mFragment = new MapForceFragment();
                break;
            case 1 :
                mFragment = new AddForceFragment();
                break;
            case 2 :
                mFragment = new ManageForceFragment();
                break;
            default:
                mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                break;
        }

        if (mFragment != null){
            mFragmentManager.beginTransaction().replace(com.tripoin.tripoin_component.R.id.container, mFragment).commit();
        }

        setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };
}
