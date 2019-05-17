package com.example.nguyenquangduong.totnghiep;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nguyenquangduong.totnghiep.Common.Common;
import com.example.nguyenquangduong.totnghiep.Model.Food;
import com.example.nguyenquangduong.totnghiep.Model.Request;
import com.example.nguyenquangduong.totnghiep.ViewHolder.MenuViewHolder;
import com.example.nguyenquangduong.totnghiep.ViewHolder.OrderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class OrderStatus extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Request, OrderViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference requests;

    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }








//    public boolean onContextItemSelected(MenuItem item) {
//        if (item.getTitle().equals(Common.UPDATE))
//        {
//            showUpdateFoodDialog(adapter.getRef(item.getOrder()).getKey(),adapter.getItem(item.getOrder()));
//        }
//        else  if (item.getTitle().equals(Common.DELETE))
//        {
//            deleteFood(adapter.getRef(item.getOrder()).getKey());
//        }
//
//
//        return super.onContextItemSelected(item);
//    }
//
//    private void showUpdateFoodDialog(String key, Request item) {
//    }
//
//    private void deleteFood(String key) {
//        AlertDialog.Builder deleteOrder = new AlertDialog.Builder(OrderStatus.this);
//        deleteOrder.setTitle("Xóa Đơn Hàng");
//        deleteOrder.setMessage("Bạn có chắc muốn xóa đơn hàng này? vui lòng kiểm tra lại");
//
//        deleteOrder.setIcon(R.drawable.ic_delete_black_24dp);
//
//        deleteOrder.setNegativeButton("HỦY", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        deleteOrder.setPositiveButton("ĐỒNG Ý", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                requests.child(key).removeValue();
//                Toast.makeText(OrderStatus.this, "Xóa món thành công", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        deleteOrder.show();
//
//
//        adapter.notifyDataSetChanged();
//
//
//
//    }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/font1.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_order_status);

        database = FirebaseDatabase.getInstance();
        requests = database.getReference("Request");

        recyclerView = (RecyclerView)findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    //    if (getIntent() == null)

        loadOrders(Common.currentUser.getPhone());
  //      else
          //  loadOrders(getIntent().getStringExtra("userPhone"));

    }



    private void loadOrders(String phone) {
        Query getOrderByUser = requests.orderByChild("phone")
                .equalTo(phone);
        FirebaseRecyclerOptions<Request> orderOptions = new FirebaseRecyclerOptions.Builder<Request>()
                .setQuery(getOrderByUser,Request.class)
                .build();




        adapter = new FirebaseRecyclerAdapter<Request, OrderViewHolder>(orderOptions) {
            @Override
            protected void onBindViewHolder(@NonNull OrderViewHolder viewHolder, int position, @NonNull Request model) {
                viewHolder.txtOrderId.setText(adapter.getRef(position).getKey());
                viewHolder.txtOrderStatus.setText(Common.convertCodeToStatus(model.getStatus()));
                viewHolder.txtOrderPhone.setText(model.getPhone());
                viewHolder.txtOrderAddress.setText(model.getAddress());
            }

            @NonNull
            @Override
            public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.order_layout,viewGroup,false);
                return new OrderViewHolder(itemView);

            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}
