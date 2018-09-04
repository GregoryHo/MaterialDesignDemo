package greg.ns.com.demo.recyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Gregory on 2016/6/30.
 */
public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

	public static final int VISIBLE_ITEM_THRESHOLD = 15;
	public static final int VALID_ITEM_COUNT = 30;

	public interface AdapterLoadMoreListener {
		void onLoadMore();
	}

	private AdapterLoadMoreListener loadMoreListener;

	private int visibleItemThreshold = VISIBLE_ITEM_THRESHOLD;
	private int validItemCount = VALID_ITEM_COUNT;


	private boolean isLoading;

	private int currentItemCount;

	@Override
	public int getItemCount() {
		if (!isAutoLoadEnable()) { // Using load more listener
			return getListSizeImp();
		} else { // Default
			if (getListSizeImp() < currentItemCount + VALID_ITEM_COUNT) {
				currentItemCount = getListSizeImp();
			} else {
				currentItemCount = currentItemCount == getInitItemCount() ? VALID_ITEM_COUNT : currentItemCount;
			}
		}
		return currentItemCount;
	}

	protected abstract boolean isAutoLoadEnable();

	protected abstract int getListSizeImp();

	protected abstract int getInitItemCount();

	public AdapterLoadMoreListener getLoadMoreListener() {
		return loadMoreListener;
	}

	public void setLoadMoreListener(AdapterLoadMoreListener loadMoreListener) {
		this.loadMoreListener = loadMoreListener;
	}

	public int getVisibleItemThreshold() {
		return visibleItemThreshold;
	}

	public void setVisibleItemThreshold(int visibleItemThreshold) {
		this.visibleItemThreshold = visibleItemThreshold;
	}

	public int getValidItemCount() {
		return validItemCount;
	}

	public void setValidItemCount(int validItemCount) {
		this.validItemCount = validItemCount;
	}

	public void addCurrentItemCount(int count) {
		currentItemCount = getListSizeImp() < (currentItemCount + count) ? getListSizeImp() : currentItemCount + count;
	}

	public int getCurrentItemCount() {
		return currentItemCount;
	}

	public void setCurrentItemCount(int itemCount) {
		currentItemCount = itemCount;
	}

	public boolean isLoading() {
		return isLoading;
	}

	public void setIsLoading() {
		this.isLoading = true;
	}

	public void setIsLoaded() {
		this.isLoading = false;
	}
}
