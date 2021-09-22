package edu.aku.hassannaqvi.ffs_linelisting.ui.sections;

import static edu.aku.hassannaqvi.ffs_linelisting.core.MainApp.cr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.ffs_linelisting.MainActivity;
import edu.aku.hassannaqvi.ffs_linelisting.R;
import edu.aku.hassannaqvi.ffs_linelisting.contracts.TableContracts;
import edu.aku.hassannaqvi.ffs_linelisting.core.MainApp;
import edu.aku.hassannaqvi.ffs_linelisting.database.DatabaseHelper;
import edu.aku.hassannaqvi.ffs_linelisting.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.ffs_linelisting.models.FormCR;

public class SectionAActivity extends AppCompatActivity {
    private static final String TAG = "SectionCRActivity";
    ActivitySectionABinding bi;
    String st = "";
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        st = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime());
        setupSkips();
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;

    }


    private void setupSkips() {
    }


    private boolean insertRecord() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long rowId = 0;

        try {
            rowId = db.addCR(cr);

            if (rowId > 0) {
                long updCount = 0;

                cr.setId(String.valueOf(rowId));
                cr.setUid(cr.getDeviceId() + cr.getId());

                updCount = db.updateCrColumn(TableContracts.FormCRTable.COLUMN_UID, cr.getUid());

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

        return false;
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (insertRecord()) {
            finish();
            startActivity(new Intent(this, SectionAActivity.class));
        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {
        cr = new FormCR();
        cr.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        cr.setUserName(MainApp.user.getUserName());
        cr.setDeviceId(MainApp.appInfo.getDeviceID());
        cr.setDeviceTag(MainApp.appInfo.getTagName());
        cr.setAppver(MainApp.appInfo.getAppVersion());
        cr.setStartTime(st);
        cr.setEndTime(new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));

        try {
            cr.setcR(cr.cRtoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(CR): " + e.getMessage(), Toast.LENGTH_SHORT).show();
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