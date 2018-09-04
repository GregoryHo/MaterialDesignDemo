package greg.ns.com.demo.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Gregory on 2016/6/28.
 */
public abstract class BaseHideScrollListener extends RecyclerView.OnScrollListener {

	private static final int SCROLL_THRESHOLD = 30;

	private int scrolledDistance = 0;
	private boolean isHeaderVisible = false;
	private boolean initStatus = true;

	@Override
	public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
		super.onScrollStateChanged(recyclerView, newState);

		if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
			int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
			//show views if first item is first visible position and views are hidden
			if (firstVisibleItem == 0) {
				if (!isHeaderVisible) {
					showHeaderViewImp(recyclerView);
				}
			}
		}
	}

	@Override
	public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
		super.onScrolled(recyclerView, dx, dy);

		int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
		//show views if first item is first visible position and views are hidden
		if (firstVisibleItem == 0) {
			if (!isHeaderVisible) {
				showHeaderViewImp(recyclerView);
			}
		} else {
			if (scrolledDistance > SCROLL_THRESHOLD && isHeaderVisible) {
				hideHeaderViewImp(recyclerView);
			}
		}

		if (isHeaderVisible && dy > 0) {
			scrolledDistance += dy;
		}
	}

	public abstract void showHeaderViewImp(RecyclerView recyclerView);

	public abstract void hideHeaderViewImp(RecyclerView recyclerView);

	public void hideHeaderViewFreeze(RecyclerView recyclerView, int topOffSet) {
		setHeaderVisible(false);
		recyclerView.setTranslationY(topOffSet);
	}

	public void setInitStatus(boolean status) {
		this.initStatus = status;
	}

	public boolean getInitStatus() {
		return initStatus;
	}

	public void setHeaderVisible(boolean visible) {
		this.isHeaderVisible = visible;
		this.scrolledDistance = 0;
	}

	public boolean isHeaderVisible() {
		return isHeaderVisible;
	}
}
