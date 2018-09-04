package greg.ns.com.demo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Gregory on 2016/6/30.
 */
public abstract class SingleVHAdapter<VH extends BaseRecyclerViewHolder, T> extends BaseRecyclerViewAdapter {

	private Context context;
	private List<T> list;

	public SingleVHAdapter(Context context, @NonNull List<T> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return onCreateViewHolderImp(parent);
	}

	protected abstract BaseRecyclerViewHolder onCreateViewHolderImp(ViewGroup parent);

	@Override
	public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
		T listItem = BaseAdapterHelper.getListItem(list, position);
		if (listItem == null) {
			throw new IllegalStateException("Incorrect ViewHolder found");
		} else {
			holder.setItemClickable();
			onBindViewHolderImp((VH) holder, position, listItem);
		}
	}

	protected abstract void onBindViewHolderImp(VH holder, int position, T listItem);

	public void updateList(@NonNull List<T> list) {
		this.list.clear();
		this.list.addAll(list);
	}

	@Override
	public int getListSizeImp() {
		return list.size();
	}

	public Context getContext() {
		return context;
	}

	public List<T> getList() {
		return list;
	}
}
