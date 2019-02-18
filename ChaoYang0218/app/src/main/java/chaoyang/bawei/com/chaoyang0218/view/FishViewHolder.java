package chaoyang.bawei.com.chaoyang0218.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import chaoyang.bawei.com.chaoyang0218.R;

public class FishViewHolder extends RecyclerView.ViewHolder {

    private final TextView txt;

    public FishViewHolder(@NonNull View itemView) {
        super(itemView);
        txt = itemView.findViewById(R.id.re_txt);
    }
}
