package com.example.bagguo.fragmentpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bagguo on 2017/9/25.
 */

public class NewsTitleFragment extends Fragment {
    List<News> mNewsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView newsTitleRecyclerView = view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        newsTitleRecyclerView.setLayoutManager(linearLayoutManager);
        getTitles();
        NewsAdapter adapter = new NewsAdapter();
        newsTitleRecyclerView.setAdapter(adapter);
        return view;
    }
    private void getTitles(){
        for (int i = 0; i < 30; i++) {
            News news = new News();
            news.setTitle("this is  news title"+i);
            mNewsList.add(news);
        }
    }
                                                    //要写泛型
    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitle.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView newsTitle;

            public ViewHolder(View itemView) {
                super(itemView);
                newsTitle = itemView.findViewById(R.id.news_title);
            }
        }
    }
}
