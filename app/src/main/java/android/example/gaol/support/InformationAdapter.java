package android.example.gaol.support;

import android.content.Context;
import android.content.Intent;
import android.example.gaol.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.DepoItemViewHolder> {

    private List<DepoItem> depoItems;

    Context c;

    @NonNull
    @Override
    public DepoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DepoItemViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_information_detail,parent,false)

        );
    }

    @Override
    public void onBindViewHolder(@NonNull final DepoItemViewHolder holder, int position) {
        holder.amr_nama.setText(depoItems.get(position).getNama_depo());
        holder.amr_alamat.setText(depoItems.get(position).getAlamat_depo());
        holder.amr_hp.setText(depoItems.get(position).getNo_hp());
        //holder.image.setImageResource(bengkelItems.get(position).getImageView());

//        holder.setItemClickListener(new ItemClickListener() {
//
//            @Override
//            public void onItemClickListener(View v, int position) {
//                String nama = depoItems.get(position).getNama_depo();
//                String alamat = depoItems.get(position).getAlamat_depo());
//                String hp = depoItems.get(position).getNo_hp();
////                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.image.getDrawable();
////
////                Bitmap bitmap = bitmapDrawable.getBitmap();
////
////                ByteArrayOutputStream stream = new ByteArrayOutputStream();
////
////                bitmap.compress(Bitmap.CompressFormat.PNG, 100,stream);
////                byte[] bytes = stream.toByteArray();
//
////                Intent intent = new Intent(c,Display_ListMobil.class);
////                intent.putExtra("iID", idBengkel);
////                intent.putExtra("iTitle", gTitle);
////                intent.putExtra("iDesc", gDesc);
////                //intent.putExtra("iImage", bytes);
////                c.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return depoItems.size();
    }





    InformationAdapter(Context c, List<DepoItem> DepoItems) {
        this.depoItems = DepoItems;
        this.c = c;
    }

    class DepoItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView amr_nama, amr_alamat, amr_hp;
        //ImageView image;
        private ItemClickListener mitemClickListener;

        public DepoItemViewHolder(@NonNull View itemView) {
            super(itemView);
            amr_nama = itemView.findViewById(R.id.amr_nama);
            amr_alamat = itemView.findViewById(R.id.amr_alamat);
            amr_hp = itemView.findViewById(R.id.amr_hp);
            //image = itemView.findViewById(R.id.images);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.mitemClickListener.onItemClickListener(v, getLayoutPosition());

        }
        public void setItemClickListener(ItemClickListener ic) {

            this.mitemClickListener = ic;
        }


    }
}
