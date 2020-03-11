package android.example.gaol.support;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.gaol.R;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class information extends AppCompatActivity {
    String nama,alamat,nohp,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        List<DepoItem> depoItems = new ArrayList<>();
        ArrayList<HashMap<String, String>> alBookPick;
        alBookPick = Eksekusi();
        for(int i=0; i<alBookPick.size();++i){
            nama = alBookPick.get(i).get("nama_depo");
            alamat = alBookPick.get(i).get("alamat_depo");
            nohp = alBookPick.get(i).get("no_hp");
            id = alBookPick.get(i).get("id_depo");
            depoItems.add(
                    new DepoItem(id,nama, alamat,nohp));
        }
        RecyclerView depoRecycleView = findViewById(R.id.rv_main);
        RecyclerView.LayoutManager recyclerView = new GridLayoutManager(this,1);
        depoRecycleView.setHasFixedSize(true);
        depoRecycleView.setLayoutManager(recyclerView);

        depoRecycleView.setAdapter(new InformationAdapter(this,depoItems));

    }

//    ArrayList<MainData> mainData;
//    ArrayList<HashMap<String, String>> arrayList;
//    RecyclerView rl_rv_main;
//    MainAdapter mainAdapter;
//    int index = 0, limit = 5, total = 0;
//    Button btn_View;
//    Global global = new Global();
//
//
//    public void showAllData(){
//
//        mainData = new ArrayList<>();
//        arrayList = new ArrayList<>();
//
//        rl_rv_main.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(information.this);
//        rl_rv_main.setLayoutManager(layoutManager);
//
//        arrayList = getQuestion(index, limit);
//
//        if(arrayList != null)
//            total = Integer.parseInt(arrayList.get(0).get(global.TAG_COUNT));
//
//        for(int i = 0; i < arrayList.size(); i++){
//            mainData.add(new MainData(
//                    arrayList.get(i).get(global.DATA_NAMA)
//                    , arrayList.get(i).get(global.DATA_ALAMAT)
//                    , arrayList.get(i).get(global.DATA_NOMOR_HP)
//            ));
//        }
//
//        mainAdapter = new MainAdapter(rl_rv_main, mainData, information.this);
//        rl_rv_main.setAdapter(mainAdapter);
//
//        mainAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore() {
//                if (arrayList.size() < total) {
//                    arrayList.add(null);
//                    mainAdapter.notifyItemInserted(arrayList.size() - 1);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            arrayList.remove(arrayList.size() - 1);
//                            mainAdapter.notifyItemRemoved(arrayList.size());
//
//                            index = arrayList.size();
//
//                            arrayList = getQuestion(index, limit);
//
//                            for(int i = 0; i < arrayList.size(); i++){
//                                mainData.add(new MainData(
//                                        arrayList.get(i).get(global.DATA_NAMA)
//                                        , arrayList.get(i).get(global.DATA_ALAMAT)
//                                        , arrayList.get(i).get(global.DATA_NOMOR_HP)
//                                ));
//                            }
//
//                            index = arrayList.size();
//
//                            mainAdapter.notifyDataSetChanged();
//                            mainAdapter.setLoaded();
//                        }
//                    }, 500);
//                }
//            }
//        });
//
//    }
//
//    public ArrayList<HashMap<String, String>> getQuestion(int index, int limit){
//
//        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
//
//        CallBackMain callBackMain = new CallBackMain(information.this);
//
//        try{
//            arrayList = callBackMain.execute(""+index, ""+limit).get();
//        }catch (Exception x){
//
//        }
//
//        System.out.println("arraylist = "+arrayList);
//
//        return arrayList;
//    }

    public ArrayList<HashMap<String, String>> Eksekusi(){
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        callback_read_depo update_book = new callback_read_depo(information.this);
        //Log.d("CEKIDBOOK",id_book);
        try {
            arrayList = update_book.execute(
                   ).get();
        }catch (Exception e){

        }

        return arrayList;
    }
}