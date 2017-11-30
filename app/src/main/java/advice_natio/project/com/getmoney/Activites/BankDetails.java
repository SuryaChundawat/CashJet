package advice_natio.project.com.getmoney.Activites;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import advice_natio.project.com.getmoney.BaseActivity.BaseActivity;
import advice_natio.project.com.getmoney.R;


/**
 * Created by Surya Chundawat on 8/17/2017.
 */

public class BankDetails extends BaseActivity implements View.OnClickListener
{
    private AppCompatButton btnBuymore;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankdetails);
       // InitiStatus();
     //   InitiToolbar((Toolbar)findViewById(R.id.toolbar),getResources().getString(R.string.titile_bankdetails));
      //  Iniview();
        context= this;
    }

    public static void StartActivity(Context context) {
        context.startActivity(new Intent(context,BankDetails.class));
    }

    private void Iniview()
    {
        btnBuymore = (AppCompatButton) findViewById(R.id.Buy);
        btnBuymore.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int getId = view.getId();
        switch (getId)
        {
            case R.id.Buy:
                UploadDetaills.StartActivity(context);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_settings:
                Products.StartActivity(context);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
