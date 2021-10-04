package edu.aku.hassannaqvi.ffs_linelisting.ui.sections;

import static edu.aku.hassannaqvi.ffs_linelisting.core.MainApp.sa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
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
import edu.aku.hassannaqvi.ffs_linelisting.databinding.ActivityFamilyListingBinding;
import edu.aku.hassannaqvi.ffs_linelisting.models.Form;

public class FamilyListingActivity extends AppCompatActivity {
    private static final String TAG = "FamilyListingActivity";
    ActivityFamilyListingBinding bi;
    String st = "";
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_family_listing);
        bi.setCallback(this);
        st = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime());
        setupSkips();
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;

        MainApp.hhid++;
        bi.hhid.setText(MainApp.maxStructure + "-" + MainApp.hhid);

    }

    private void setupSkips() {

        bi.hh14.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpa14a));

    }

    private boolean insertRecord() {
        long rowId = 0;

        try {
            rowId = db.addCR(sa);

            if (rowId > 0) {
                long updCount = 0;

                sa.setId(String.valueOf(rowId));
                sa.setUid(sa.getDeviceId() + sa.getId());

                updCount = db.updateCrColumn(TableContracts.FormTable.COLUMN_UID, sa.getUid());

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
            if (view == bi.btnContinue) {
                startActivity(new Intent(this, SectionBActivity.class));
            } else {
                startActivity(new Intent(this, FamilyListingActivity.class));

            }
        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }

    private void saveDraft() {
        sa = new Form();
        sa.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        sa.setUserName(MainApp.user.getUserName());
        sa.setDeviceId(MainApp.appInfo.getDeviceID());
        sa.setDeviceTag(MainApp.appInfo.getTagName());
        sa.setAppver(MainApp.appInfo.getAppVersion());
        sa.setStartTime(st);
        sa.setEndTime(new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));

        sa.setHh11(bi.hh11.getText().toString());

        sa.setHh12(bi.hh12.getText().toString());

        sa.setHh13(bi.hh13.getText().toString());

        sa.setHh14(bi.hh1401.isChecked() ? "1"
                : bi.hh1402.isChecked() ? "2"
                : "-1");

        sa.setHh15(bi.hh15.getText().toString());

        sa.setHh16(bi.hh16.getText().toString());

        sa.setHh17(bi.hh17.getText().toString());

        sa.setHh18(bi.hh18.getText().toString());

        sa.setHh19(bi.hh19.getText().toString());
        sa.setHh21(String.valueOf(MainApp.hhid));

        try {
            sa.setsA(sa.sAtoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(SB): " + e.getMessage(), Toast.LENGTH_SHORT).show();
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