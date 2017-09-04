package com.choose_gold.baserecyclerviewadapterhelperdemo;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

public class PullToRefreshUseActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener,SwipeRefreshLayout.OnRefreshListener{
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    PullToRefreshAdapter pullToRefreshAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pull_to_refresh_use);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        setTitle("Pull TO Refresh Use");

        pullToRefreshAdapter = new PullToRefreshAdapter( R.layout.layout_animation, DataServer.getSampleData(10));
        pullToRefreshAdapter.setOnLoadMoreListener(this, mRecyclerView);
        pullToRefreshAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        pullToRefreshAdapter.isFirstOnly(false);
        mRecyclerView.setAdapter(pullToRefreshAdapter);
        pullToRefreshAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.i("点击了",""+position);



            }
        });



    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        pullToRefreshAdapter.addData(DataServer.getSampleData(10));
        pullToRefreshAdapter.loadMoreFail();
        mSwipeRefreshLayout.setEnabled(true);
        Log.i("kevin","加载");
    }
int i=1;
    @Override
    public void onRefresh() {

        pullToRefreshAdapter.remove(i);
        mSwipeRefreshLayout.setRefreshing(false);



       /* pullToRefreshAdapter.setEnableLoadMore(false);




        pullToRefreshAdapter.setEnableLoadMore(true);*/
        Log.i("kevin","刷新");


    }




}
