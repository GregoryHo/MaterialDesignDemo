package greg.ns.com.demo.recyclerview;

import java.util.List;

/**
 * Created by Gregory on 2016/6/30.
 */
public class BaseAdapterHelper {

	/**
	 * Gets the list item held at the specified adapter position.
	 *
	 * @param position The index of the list item to return
	 * @return The list item at the specified position
	 */
	public static <T> T getListItem(List<T> itemList, int position) {
		boolean indexInRange = position >= 0 && position < itemList.size();
		if (indexInRange) {
			return itemList.get(position);
		} else {
			return null;
		}
	}
}
