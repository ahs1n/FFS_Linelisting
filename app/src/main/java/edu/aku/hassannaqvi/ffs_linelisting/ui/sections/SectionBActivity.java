package edu.aku.hassannaqvi.ffs_linelisting.ui.sections;

import static edu.aku.hassannaqvi.ffs_linelisting.core.MainApp.editor;
import static edu.aku.hassannaqvi.ffs_linelisting.core.MainApp.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
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
import edu.aku.hassannaqvi.ffs_linelisting.databinding.ActivitySectionBBinding;

public class SectionBActivity extends AppCompatActivity {
    private static final String TAG = "SectionBActivity";
    ActivitySectionBBinding bi;
    String st = "";
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b);
        bi.setCallback(this);
        st = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime());
        setupSkips();
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;

        MainApp.maxStructure++;
        MainApp.hhid = 0;
        bi.hhid.setText(MainApp.form.getHh01() + "\n" + String.format("%03d", MainApp.maxStructure));
        Toast.makeText(this, "Staring Structure", Toast.LENGTH_SHORT).show();

    }

    private void setupSkips() {

        bi.hh07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.hh0701.isChecked()) {
                    Clear.clearAllFields(bi.fldGrpCVhh08);
                } else {
                    Clear.clearAllFields(bi.fldGrpCVhh09);
                    Clear.clearAllFields(bi.fldGrpCVhh10);

                }

                if (bi.hh0713.isChecked() || bi.hh0714.isChecked() || bi.hh0715.isChecked() || bi.hh0716.isChecked()) {
                    Clear.clearAllFields(bi.fldGrpCVhh08);
                    Clear.clearAllFields(bi.fldGrpCVhh09);
                    Clear.clearAllFields(bi.fldGrpCVhh10);
                    bi.btnContinue.setText("Continue to Next");
                }

                if (bi.hh0718.isChecked() || bi.hh0719.isChecked()) {
                    Clear.clearAllFields(bi.fldGrpCVhh08);
                    Clear.clearAllFields(bi.fldGrpCVhh09);
                    Clear.clearAllFields(bi.fldGrpCVhh10);
                    bi.btnContinue.setText("Close Listing");
                }

            }
        });
        bi.hh0902.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpCVhh10));

        //   bi.hh09.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpCVhh10));
    }


    private boolean insertRecord() {
        long rowId = 0;

        try {
            rowId = db.addForm(form);

            if (rowId > 0) {
                long updCount = 0;

                form.setId(String.valueOf(rowId));
                form.setUid(form.getDeviceId() + form.getId());

                updCount = db.updateFormColumn(TableContracts.FormTable.COLUMN_UID, form.getUid());

                if (updCount > 0) {

                    editor.putString(MainApp.selectedCluster, String.valueOf(MainApp.maxStructure));
                    editor.apply();

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
            Intent i = null;
            if (form.getHh07().equals("1")) {
                i = new Intent(this, FamilyListingActivity.class);
                MainApp.hhid = 0;
            } else if (bi.hh0718.isChecked() || bi.hh0719.isChecked()) {
                i = new Intent(this, MainActivity.class);
            } else {
                i = new Intent(this, SectionBActivity.class);
            }

            startActivity(i);
        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {
        // form = new Form();
        if (bi.hh0718.isChecked() || bi.hh0719.isChecked()) {
            MainApp.maxStructure--;
        }
        form.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        form.setUserName(MainApp.user.getUserName());
        form.setDeviceId(MainApp.appInfo.getDeviceID());
        form.setDeviceTag(MainApp.appInfo.getTagName());
        form.setAppver(MainApp.appInfo.getAppVersion());
        form.setStartTime(st);
        form.setEndTime(new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));

        form.setHh07(bi.hh0701.isChecked() ? "1"
                : bi.hh0702.isChecked() ? "2"
                : bi.hh0703.isChecked() ? "3"
                : bi.hh0704.isChecked() ? "4"
                : bi.hh0705.isChecked() ? "5"
                : bi.hh0706.isChecked() ? "6"
                : bi.hh0707.isChecked() ? "7"
                : bi.hh0708.isChecked() ? "8"
                : bi.hh0709.isChecked() ? "9"
                : bi.hh0710.isChecked() ? "10"
                : bi.hh0711.isChecked() ? "11"
                : bi.hh0712.isChecked() ? "12"
                : bi.hh0713.isChecked() ? "13"
                : bi.hh0714.isChecked() ? "14"
                : bi.hh0715.isChecked() ? "15"
                : bi.hh0716.isChecked() ? "16"
                : bi.hh0717.isChecked() ? "96"
                : bi.hh0718.isChecked() ? "18"
                : bi.hh0719.isChecked() ? "19"
                : "-1");

        form.setHh0717x(bi.hh0717x.getText().toString());
        form.setHh08(bi.hh08.getText().toString());

        form.setHh09(bi.hh0901.isChecked() ? "1"
                : bi.hh0902.isChecked() ? "2"
                : "-1");
        form.setHh10(bi.hh0701.isChecked() && bi.hh0902.isChecked() ? "1" : bi.hh10.getText().toString());

        form.setHh20(String.valueOf(MainApp.maxStructure));

        try {
            form.setsA(form.sAtoString());
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
        Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
       /* finish();
        startActivity(new Intent(this, MainActivity.class));*/
    }
}