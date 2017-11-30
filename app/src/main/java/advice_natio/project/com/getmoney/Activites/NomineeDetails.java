package advice_natio.project.com.getmoney.Activites;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import advice_natio.project.com.getmoney.BaseActivity.BaseActivity;
import advice_natio.project.com.getmoney.Fragment.DatePickerFragment;
import advice_natio.project.com.getmoney.R;


/**
 * Created by Surya Chundawat on 8/13/2017.
 */

public class NomineeDetails extends BaseActivity implements View.OnClickListener
{
    private EditText edtnomineename;
    private TextInputLayout txtinNomineename;
    private TextView txtrelation,txtdate;
    private RadioButton rdspouce,rdson,rddaughter,rdfather,rdmother;
    private DatePicker nomineeDate;
    private Context context;
    private AppCompatButton btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomineedetails);
        InitiStatus();
        InitiToolbar((Toolbar)findViewById(R.id.toolbar),getResources().getString(R.string.title_nomineeactivity));
        InitiView();
        context=this;
    }

    private void InitiView()
    {
        edtnomineename = (EditText) findViewById(R.id.edtnomineename);
        txtrelation =(TextView) findViewById(R.id.txtrelation);
        rdspouce =(RadioButton) findViewById(R.id.rdspouce);
        rddaughter =(RadioButton) findViewById(R.id.rddaughter);
        rdfather = (RadioButton) findViewById(R.id.rdfather);
        rdmother =(RadioButton) findViewById(R.id.rdmother);
        btnNext = (AppCompatButton) findViewById(R.id.btnnext);
        btnNext.setOnClickListener(this);
        txtdate = (TextView) findViewById(R.id.txtdate);
        txtdate.setOnClickListener(this);


    }

    public static void StartActivity(Context context) {
        context.startActivity(new Intent(context,NomineeDetails.class));
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnnext:
                //Intent intent = new Intent(NomineeDetails.this,)
                Dashboard.StartActivity(context);
                break;
            case R.id.txtdate:
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
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
