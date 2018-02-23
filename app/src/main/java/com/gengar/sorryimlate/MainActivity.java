package com.gengar.sorryimlate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gengar.sorryimlate.adapter.Adapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static java.net.Proxy.Type.HTTP;


public class MainActivity extends AppCompatActivity {

    private Button kasnim,sms;
    private TextView textView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kasnim = findViewById(R.id.kasnim);

        sms = findViewById(R.id.sms);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","Kasnicu malo, reci da ne upis");
                startActivity(intent);

            }
        });

        textView = findViewById(R.id.text_veiw);

        recyclerView = findViewById(R.id.recycler);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(manager);

        kasnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
                LateDB late = new LateDB(cal);
                late.save();
                Toast.makeText(MainActivity.this, "Sad mozes spavati", Toast.LENGTH_SHORT).show();
                textView.setText(dateFormat.format(cal.getTime()));

            }
        });

        kasnim.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Puff", Toast.LENGTH_SHORT).show();

                List<LateDB> all = LateDB.listAll(LateDB.class);

                recyclerView.setAdapter(new Adapter(all));

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                for (LateDB item : all){
                    System.out.println(dateFormat.format(item.getDate().getTime()));
                }


                return true;
            }
        });
    }
}
