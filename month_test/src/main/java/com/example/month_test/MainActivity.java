package com.example.month_test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.month_test.xxxxcontract.Contract;
import com.example.month_test.xxxxpresenter.PeresentImp;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import Api.ApiManager;
import Bean.FoodBean;

public class MainActivity extends AppCompatActivity implements Contract.View {

    public static XRecyclerView xrec;
    private int c=2;



    private List<FoodBean.DataBean> foodBeans=new ArrayList<>();
    private Myadpter myadpter=new Myadpter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PeresentImp peresentImp=new PeresentImp(MainActivity.this);
        peresentImp.loadData();
        initView();



    }

    @Override
    public void loadData(final FoodBean foodBean) {
        foodBeans=foodBean.getData();

    }

    private void initView() {
        xrec=(XRecyclerView) findViewById(R.id.xrec);
        LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this);
        xrec.setLoadingMoreEnabled(true);
        xrec.setAdapter(myadpter);
        xrec.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        xrec.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xrec.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                     ApiManager.page=c++;

                xrec.loadMoreComplete();


            }
        });
        xrec.setLayoutManager(manager);

    }
    class Myadpter extends RecyclerView.Adapter<Myadpter.ViewHolder>
    {

        @NonNull
        @Override
        public Myadpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=View.inflate(MainActivity.this,R.layout.rec_item,null);
            ViewHolder viewHolder=new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull Myadpter.ViewHolder holder, int position) {
            Glide.with(MainActivity.this).load(foodBeans.get(position).getPic()).into(holder.imageView);
            holder.textView.setText(foodBeans.get(position).getTitle());
        }
   public  void setData(List<FoodBean.DataBean> foodbean)
   {
       if (foodBeans!=null)
       {
             foodbean.clear();
             foodbean.addAll(foodBeans);
             notifyDataSetChanged();
       }
   }
        @Override
        public int getItemCount() {
            return foodBeans.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageView;
            private TextView textView;
            public ViewHolder(View itemView) {
                super(itemView);
                imageView=  itemView.findViewById(R.id.item_iv);
                textView=itemView.findViewById(R.id.item_tv);
            }
        }
    }
}
