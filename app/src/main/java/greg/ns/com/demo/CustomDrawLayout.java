package greg.ns.com.demo;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

/**
 * Created by Gregory on 2016/7/18.
 */
public class CustomDrawLayout extends DrawerLayout {

  public CustomDrawLayout(Context context) {
    super(context);
  }

  public CustomDrawLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    widthMeasureSpec = MeasureSpec.makeMeasureSpec(
        MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY);
    heightMeasureSpec = MeasureSpec.makeMeasureSpec(
        MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.EXACTLY);
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }
}
