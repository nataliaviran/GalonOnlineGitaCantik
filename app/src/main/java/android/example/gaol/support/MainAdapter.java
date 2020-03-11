package android.example.gaol.support;

import android.content.Context;
import android.content.Intent;

import android.example.gaol.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context mContext;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private OnLoadMoreListener onLoadMoreListener;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    ArrayList<MainData> mainData;
    LayoutInflater layoutInflater;
    View view;
    Global global = new Global();

    public MainAdapter(RecyclerView recyclerView, ArrayList<MainData> mainData, Context mContext) {
        this.mainData = mainData;
        this.mContext = mContext;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        layoutInflater = LayoutInflater.from(viewGroup.getContext());

        if (i == VIEW_TYPE_ITEM) {
            view = layoutInflater.inflate(R.layout.activity_information_row, viewGroup, false);
            MainViewHoldew mViewHolder = new MainViewHoldew(view);
            return mViewHolder;
        } else if (i == VIEW_TYPE_LOADING) {
            view = layoutInflater.inflate(R.layout.loading, viewGroup, false);
            LoadingViewHolder mViewHolder2 = new LoadingViewHolder(view);
            return mViewHolder2;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof MainViewHoldew) {
            MainViewHoldew RMAViewHolder = (MainViewHoldew) viewHolder;

            RMAViewHolder.amr_nama.setText(mainData.get(i).getNama());
            RMAViewHolder.amr_alamat.setText(mainData.get(i).getAlamat());
            RMAViewHolder.amr_hp.setText(mainData.get(i).getNo_hp());

            RMAViewHolder._amr_cv_main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, information.class);
                    intent.putExtra(global.DATA_NAMA, mainData.get(i).getNama());
                    intent.putExtra(global.DATA_ALAMAT, mainData.get(i).getAlamat());
                    intent.putExtra(global.DATA_NOMOR_HP, mainData.get(i).getNo_hp());

                    mContext.startActivity(intent);
                    //((Activity)mContext).finish();
                }
            });


        } else if (viewHolder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) viewHolder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return mainData.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    @Override
    public int getItemViewType(int position) {
        return mainData.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    public class MainViewHoldew extends RecyclerView.ViewHolder{
        private TextView amr_nama, amr_alamat, amr_hp;
        CardView _amr_cv_main;

        public MainViewHoldew(View itemView) {
            super(itemView);
            amr_nama = (TextView) itemView.findViewById(R.id.amr_nama);
            amr_alamat = (TextView) itemView.findViewById(R.id.amr_alamat);
            amr_hp = (TextView) itemView.findViewById(R.id.amr_hp);
            _amr_cv_main = (CardView) itemView.findViewById(R.id.amr_cv_main);
        }

        public void setItem(String item) {

        }

    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View view) {
            super(view);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);
        }
    }
}
