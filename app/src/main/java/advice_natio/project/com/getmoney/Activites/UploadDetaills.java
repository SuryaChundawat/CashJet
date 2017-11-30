package advice_natio.project.com.getmoney.Activites;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

import advice_natio.project.com.getmoney.Activites.Adapter.UploadAdapter;
import advice_natio.project.com.getmoney.BaseActivity.BaseActivity;
import advice_natio.project.com.getmoney.BaseActivity.Constants;
import advice_natio.project.com.getmoney.R;
import advice_natio.project.com.getmoney.RecylerViewClick.RecyclerItemClickListener;
import advice_natio.project.com.getmoney.ScanActivity.ScanActivity;

import static advice_natio.project.com.getmoney.BaseActivity.Constants.REQUEST_CODE;
import static advice_natio.project.com.getmoney.BaseActivity.Constants.SCANNED_RESULT;

/**
 * Created by Surya Chundawat on 8/19/2017.
 */

public class UploadDetaills extends BaseActivity implements View.OnClickListener
{
    /*private RecyclerView ListView;*/
    private Context context;
    private ArrayList<String> picname;
    private String TAG="UploadDetails";
    private AppCompatButton btnBuymore;
    private ImageButton imgAdharcard,imageCheque,imageYourpic;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploaddetails);
        InitiStatus();
        InitiToolbar((Toolbar)findViewById(R.id.toolbar),getResources().getString(R.string.titile_uploaddeatails));
        context = this;
        InitList();
        Init();
        //setView();
    }

    private void Init()
    {
        //ListView = (RecyclerView) findViewById(R.id.recylerview);
        btnBuymore =(AppCompatButton) findViewById(R.id.Buy);
        btnBuymore.setOnClickListener(this);
        imgAdharcard = (ImageButton)  findViewById(R.id.image);
        //imageCheque= (ImageButton)  findViewById(R.id.imageBankCheque);
        //imageYourpic = (ImageButton)  findViewById(R.id.imageyourpic);
        imgAdharcard.setOnClickListener(this);
        imageCheque.setOnClickListener(this);
        imageYourpic.setOnClickListener(this);

    }

    private void InitList()
    {
        picname = new ArrayList<>();
        picname.add("Aadhar Card");
        picname.add("Bank Cheque");
        picname.add("Your Pic");

    }

    public static void setScan(int Position, ImageView imageView)
    {


    }

    /*private void setView() {
        ListView.setLayoutManager(new GridLayoutManager(context, 3));
        ListView.setItemAnimator(new DefaultItemAnimator());
        UploadAdapter adapter = new UploadAdapter(context, picname);
        ListView.setAdapter(adapter);

        ListView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, ListView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position)
                    {
                        Log.e(TAG, "onItemClick ID: "+position );
                        // do whatever
                    }

                    @Override public void onLongItemClick(View view, int position)
                    {
                        // do whatever
                    }
                })
        );
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getExtras().getParcelable(SCANNED_RESULT);
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                getContentResolver().delete(uri, null, null);
                imgAdharcard.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void StartActivity(Context context)
    {
        context.startActivity(new Intent(context,UploadDetaills.class));

    }

    @Override
    public void onClick(View view) {
        int getID = view.getId();
        switch (getID)
        {
            case R.id.Buy:
                Products.StartActivity(context);
                break;
            case R.id.image:
                Intent intent = new Intent(this, ScanActivity.class);
                intent.putExtra(Constants.OPEN_INTENT_PREFERENCE, R.id.image);
                startActivityForResult(intent, REQUEST_CODE);
                break;
           /* case R.id.imageBankCheque:
                Intent intentBankCheque = new Intent(this, ScanActivity.class);
                intentBankCheque.putExtra(Constants.OPEN_INTENT_PREFERENCE, R.id.imageBankCheque);
                startActivityForResult(intentBankCheque, REQUEST_CODE);
                break;
            case R.id.imageyourpic:
                Intent intentYourPic= new Intent(this, ScanActivity.class);
                intentYourPic.putExtra(Constants.OPEN_INTENT_PREFERENCE, R.id.imageyourpic);
                startActivityForResult(intentYourPic, REQUEST_CODE);
                break;*/
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
