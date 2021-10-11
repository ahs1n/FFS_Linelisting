package edu.aku.hassannaqvi.ffs_linelisting.ui.sections;

import static edu.aku.hassannaqvi.ffs_linelisting.core.MainApp.form;
import static edu.aku.hassannaqvi.ffs_linelisting.core.MainApp.sharedPref;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.ffs_linelisting.MainActivity;
import edu.aku.hassannaqvi.ffs_linelisting.R;
import edu.aku.hassannaqvi.ffs_linelisting.core.MainApp;
import edu.aku.hassannaqvi.ffs_linelisting.database.DatabaseHelper;
import edu.aku.hassannaqvi.ffs_linelisting.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.ffs_linelisting.models.EnumBlocks;
import edu.aku.hassannaqvi.ffs_linelisting.models.Form;

public class SectionAActivity extends AppCompatActivity {
    private static final String TAG = "SectionCRActivity";
    ActivitySectionABinding bi;
    String st = "";
    private DatabaseHelper db;
    private ArrayList<String> ebCode;
    private ArrayList<String> districtNames;
    private ArrayList<String> tehsilNames;
    private ArrayList<String> headHH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        st = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime());
        setupSkips();
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;

        populateSpinner();
    }


    private void setupSkips() {
    }

    private void populateSpinner() {
        Collection<EnumBlocks> enumBlocks = db.getEnumBlocks();
        ebCode = new ArrayList<>();
        districtNames = new ArrayList<>();
        tehsilNames = new ArrayList<>();
        for (EnumBlocks eb : enumBlocks) {
            ebCode.add(eb.getEnumBlock());

            districtNames.add(eb.getDistrictName());
            tehsilNames.add(eb.getTehsilName()); //
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ebCode);

        bi.hh01.setAdapter(adapter);

        bi.hh01.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int position = ebCode.indexOf(bi.hh01.getText().toString());
                bi.hh04.setText(districtNames.get(position));
                bi.hh05.setText(tehsilNames.get(position));

                ArrayList<String> households = new ArrayList<String>();

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SectionAActivity.this,
                        android.R.layout.simple_dropdown_item_1line, households);

                bi.hh01.setAdapter(adapter);

            }
        });


    }

    private boolean insertRecord() {
        MainApp.selectedCluster = bi.hh01.getText().toString();
        MainApp.maxStructure = Integer.parseInt(sharedPref.getString(MainApp.selectedCluster, "0"));


        return true;
       /* long rowId = 0;

        try {
            rowId = db.addCR(form);

            if (rowId > 0) {
                long updCount = 0;

                form.setId(String.valueOf(rowId));
                form.setUid(form.getDeviceId() + form.getId());

                updCount = db.updateCrColumn(TableContracts.FormTable.COLUMN_UID, form.getUid());

                if (updCount > 0) {
                    return true;
                }

            } else {
                Toast.makeText(this, "Updating Database… ERROR!", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(CR):" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return false;*/
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (insertRecord()) {
            finish();
            startActivity(new Intent(this, SectionBActivity.class));
        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {
        form = new Form();
        form.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        form.setUserName(MainApp.user.getUserName());
        form.setDeviceId(MainApp.appInfo.getDeviceID());
        form.setDeviceTag(MainApp.appInfo.getTagName());
        form.setAppver(MainApp.appInfo.getAppVersion());
        form.setStartTime(st);
        form.setEndTime(new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));


        form.setHh01(bi.hh01.getText().toString());

/*        form.setHh02(bi.hh02.getText().toString());

        form.setHh03(bi.hh03.getText().toString());*/

        form.setHh04(bi.hh04.getText().toString());

        form.setHh05(bi.hh05.getText().toString());

        form.setHh06(bi.hh06.getText().toString());
        form.setHh20(String.valueOf(MainApp.maxStructure));

        try {
            form.setsA(form.sAtoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(SA): " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    @Override
    public void onBackPressed() {
        // Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}