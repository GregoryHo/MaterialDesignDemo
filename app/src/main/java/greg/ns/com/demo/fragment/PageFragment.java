package greg.ns.com.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import greg.ns.com.demo.R;
import greg.ns.com.demo.recyclerview.BaseRecyclerViewHolder;
import greg.ns.com.demo.recyclerview.SingleVHAdapter;

/**
 * Created by Gregory on 2016/7/15.
 */
public class PageFragment extends Fragment {

  private RecyclerView recyclerView;

  public static PageFragment newInstance(int position) {
    PageFragment pageFragment = new PageFragment();
    Bundle bundle = new Bundle();
    bundle.putString("index", String.valueOf(position));
    pageFragment.setArguments(bundle);
    return pageFragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.page_fragment, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    initRecyclerView(view);
  }

  private void initRecyclerView(View view) {
    recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
    recyclerView.setAdapter(
        new CustomAdapter(getActivity().getApplicationContext(), generateList()));
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
  }

  private List<String> generateList() {
    List<String> list = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      list.add(getArguments().getString("index"));
    }

    return list;
  }

  private static class CustomAdapter extends SingleVHAdapter<BaseRecyclerViewHolder, String> {

    CustomAdapter(Context context, @NonNull List<String> list) {
      super(context, list);
    }

    @Override
    protected BaseRecyclerViewHolder onCreateViewHolderImp(ViewGroup parent) {
      return new BaseRecyclerViewHolder(
          LayoutInflater.from(getContext()).inflate(R.layout.page_list_content, parent, false)
      );
    }

    @Override
    protected void onBindViewHolderImp(BaseRecyclerViewHolder holder, int position,
        String listItem) {
      holder.getTextView(R.id.page_title).setText("Page " + listItem + " # ");
      holder.getTextView(R.id.page_text_numbers).setText(String.valueOf(position));
    }

    @Override
    protected boolean isAutoLoadEnable() {
      return false;
    }

    @Override
    protected int getInitItemCount() {
      return 0;
    }
  }
}
