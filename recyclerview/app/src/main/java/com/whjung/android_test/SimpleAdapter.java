package com.whjung.android_test;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    private ArrayList<Item> mData = null ;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ToggleButton tb ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            tb = itemView.findViewById(R.id.tb) ;
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    SimpleAdapter(ArrayList<Item> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false) ;
        SimpleAdapter.ViewHolder vh = new SimpleAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(final SimpleAdapter.ViewHolder holder, final int position) {
        String text = mData.get(position).str ;
        holder.tb.setText(text);
        holder.tb.setTag(position);

        Log.d("TAG",Integer.toString(position) + String.valueOf(mData.get(position).isChecked));
        holder.tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.get(position).isChecked = holder.tb.isChecked();
            }
        });

        if (mData.get(position).isChecked) {
            holder.tb.setChecked(true);
        } else {
            holder.tb.setChecked(false);
        }
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}