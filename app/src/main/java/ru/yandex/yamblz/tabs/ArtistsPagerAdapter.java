package ru.yandex.yamblz.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import ru.yandex.yamblz.Model.Artist;

/**
 * Created by Nikita Yaschenko on 8/10/16.
 */
public class ArtistsPagerAdapter extends FragmentStatePagerAdapter {

    private List<Artist> artists;

    public ArtistsPagerAdapter(FragmentManager fm, List<Artist> artists) {
        super(fm);

        this.artists = artists;
    }

    @Override
    public Fragment getItem(int position) {
        return ArtistPreviewFragment.newInstance(artists.get(position));
    }

    @Override
    public int getCount() {
        return artists.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return artists.get(position).getName();
    }
}
