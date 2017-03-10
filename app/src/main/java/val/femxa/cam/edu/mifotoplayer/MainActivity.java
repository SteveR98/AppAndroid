package val.femxa.cam.edu.mifotoplayer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int []arrayPics=
        {R.drawable.ic_flash_on,
        R.drawable.ic_security,
        R.drawable.ic_whatshot,
                R.drawable.ic_accessible};

     private static int fotoActual = 0;
    private static int longitudarray = 0;

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("FotoActual",fotoActual);

    }

    @Override
    protected void onStart()
    {
        Log.d("MENSAJE","Entro al onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {

        Log.d("MENSAJE","Entro al onResume");
        super.onResume();

    }

    @Override
    protected void onCreate(Bundle bundle) {
        Log.d("MENSAJE","Entro al onCreate");
        super.onCreate(bundle);

        if(bundle==null){
            Log.d("MENSAJE","Bundle vacio");
        }
        else{
            Log.d("MENSAJE","Bundle con cosas") ;
            fotoActual= bundle.getInt("FotoActual");
        }


        setContentView(R.layout.activity_main);
        Log.d("MENSAJE","SETEADA FOTO 1");
        View v = findViewById(R.id.no);
        Button boton = (Button) v;

        View v2 = findViewById(R.id.si);
        Button boton2 = (Button) v2;

        SharedPreferences sp = getSharedPreferences("megustasono", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putBoolean("Opinion Foto"+fotoActual,false);
        Log.d("MIMENSAJE",String.valueOf( sp.getBoolean("Opinion Foto"+fotoActual,false)));
        ed.commit();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensajenegativo = getResources().getString(R.string.mensajeno);
                Toast toast = Toast.makeText(MainActivity.this, mensajenegativo, Toast.LENGTH_SHORT);

                ImageView imagen1 = (ImageView) findViewById(R.id.imageView);
                longitudarray = arrayPics.length ;

                imagen1.setImageResource(arrayPics [fotoActual]);

                fotoActual++;

                if (longitudarray == fotoActual)
                {
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }

                toast.show();

                Log.d("MIMENSAJE","BOTON NO PULSADO");
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {

                String mensaje = getResources().getString(R.string.mensajesi);
                Toast toast = Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT);

                ImageView imagen1 = (ImageView) findViewById(R.id.imageView);
                longitudarray = arrayPics.length ;

                imagen1.setImageResource(arrayPics [fotoActual]);

                SharedPreferences sp = getSharedPreferences("megustasono", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=sp.edit();

                ed.putBoolean("Opinion Foto"+fotoActual,true);

                Log.d("MIMENSAJE",String.valueOf( sp.getBoolean("Opinion Foto"+fotoActual,true)));
                ed.commit();

                fotoActual++;

                if (longitudarray == fotoActual)
                {
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);

                }

                toast.show();

                Log.d("MIMENSAJE","BOTON SI PULSADO");


            }
        });



    }
}
