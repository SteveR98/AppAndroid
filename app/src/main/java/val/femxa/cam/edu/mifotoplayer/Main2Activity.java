package val.femxa.cam.edu.mifotoplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        boolean primero = true;

        TextView textView = (TextView)findViewById(R.id.textView);
        String sms =textView.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("megustasono", Context.MODE_PRIVATE);

        for (int i = 1; i <= 3; i++) {


            if (sharedPreferences.getBoolean("Opinion Foto" + i, false)) {

                if (primero)
                {
                    sms = "Te ha gustado la foto" + i;
                }

                else
                {
                    sms = sms + ", la foto " + i;
                }

                primero = false;
            }
            textView.setText(sms);
        }
    }
}