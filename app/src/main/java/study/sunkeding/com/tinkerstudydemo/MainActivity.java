package study.sunkeding.com.tinkerstudydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tinkerpatch.sdk.TinkerPatch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListener();
    }

    private void initListener() {
        final Button bt=findViewById(R.id.bt1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TextView tv = null;
//                tv.setText("d");
                bt.setText("fix 空指针");
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TinkerPatch tinkerPatch = TinkerPatch.with().fetchPatchUpdate(true);
                if (tinkerPatch!=null){
                    Toast.makeText(MainActivity.this, "tinkerPatch.getPatchVersion():" + tinkerPatch.getPatchVersion(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
