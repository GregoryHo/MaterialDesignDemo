package greg.ns.com.demo.fragmentadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import greg.ns.com.demo.fragment.PageFragment;

/**
 * Created by Gregory on 2016/7/15.
 */
public class CustomFragmentAdapter extends FragmentStatePagerAdapter {

	private static final int FRAGMENT_COUNT = 3;

	public CustomFragmentAdapter(FragmentManager fm) {
		super(fm);

	}

	@Override
	public Fragment getItem(int position) {
		return PageFragment.newInstance(position + 1);
	}

	@Override
	public int getCount() {
		return FRAGMENT_COUNT;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "Page #" + (position + 1);
	}
}
