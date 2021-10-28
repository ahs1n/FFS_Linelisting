package edu.aku.hassannaqvi.ffs_linelisting.models;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.ffs_linelisting.BR;
import edu.aku.hassannaqvi.ffs_linelisting.contracts.TableContracts.FormTable;
import edu.aku.hassannaqvi.ffs_linelisting.core.MainApp;

public class Form extends BaseObservable {

    private final String TAG = "Form";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String startTime = StringUtils.EMPTY;
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;

    // SECTION VARIABLES
    private String sH1 = StringUtils.EMPTY;
    // FIELD VARIABLES
    private String hh01 = StringUtils.EMPTY;
    private String hh02 = StringUtils.EMPTY;
    private String hh03 = StringUtils.EMPTY;
    private String hh04 = StringUtils.EMPTY;
    private String hh05 = StringUtils.EMPTY;
    private String hh06 = StringUtils.EMPTY;
    private String hh07 = StringUtils.EMPTY;
    private String hh0717x = StringUtils.EMPTY;
    private String hh08 = StringUtils.EMPTY;
    private String hh09 = StringUtils.EMPTY;
    private String hh10 = StringUtils.EMPTY;
    private String hh11 = StringUtils.EMPTY;
    private String hh12 = StringUtils.EMPTY;
    private String hh13 = StringUtils.EMPTY;
    private String hh14 = StringUtils.EMPTY;
    private String hh15 = StringUtils.EMPTY;

    private String hh20 = StringUtils.EMPTY;  // Structure Number
    private String hh21 = StringUtils.EMPTY; // Household ID
    private String sA = StringUtils.EMPTY;
    private String sB = StringUtils.EMPTY;
    private String lC = StringUtils.EMPTY;

    public Form() {

        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setAppver(MainApp.appInfo.getAppVersion());
        setAppver(MainApp.appInfo.getAppVersion());

    }

    @Bindable
    public String getHh01() {
        return hh01;
    }

    public void setHh01(String hh01) {
        this.hh01 = hh01;
        notifyPropertyChanged(BR.hh01);
    }

    @Bindable
    public String getHh02() {
        return hh02;
    }

    public void setHh02(String hh02) {
        this.hh02 = hh02;
        notifyPropertyChanged(BR.hh02);
    }

    @Bindable
    public String getHh03() {
        return hh03;
    }

    public void setHh03(String hh03) {
        this.hh03 = hh03;
        notifyPropertyChanged(BR.hh03);
    }

    @Bindable
    public String getHh04() {
        return hh04;
    }

    public void setHh04(String hh04) {
        this.hh04 = hh04;
        notifyPropertyChanged(BR.hh04);
    }

    @Bindable
    public String getHh05() {
        return hh05;
    }

    public void setHh05(String hh05) {
        this.hh05 = hh05;
        notifyPropertyChanged(BR.hh05);
    }

    @Bindable
    public String getHh06() {
        return hh06;
    }

    public void setHh06(String hh06) {
        this.hh06 = hh06;
        notifyPropertyChanged(BR.hh06);
    }

    @Bindable
    public String getHh07() {
        return hh07;
    }

    public void setHh07(String hh07) {
        this.hh07 = hh07;
        notifyPropertyChanged(BR.hh07);
    }

    @Bindable
    public String getHh0717x() {
        return hh0717x;
    }

    public void setHh0717x(String hh0717x) {
        this.hh0717x = hh0717x;
        notifyPropertyChanged(BR.hh0717x);
    }

    @Bindable
    public String getHh08() {
        return hh08;
    }

    public void setHh08(String hh08) {
        this.hh08 = hh08;
        notifyPropertyChanged(BR.hh08);
    }

    @Bindable
    public String getHh09() {
        return hh09;
    }

    public void setHh09(String hh09) {
        this.hh09 = hh09;
        notifyPropertyChanged(BR.hh09);
    }

    @Bindable
    public String getHh10() {
        return hh10;
    }

    public void setHh10(String hh10) {
        this.hh10 = hh10;
        notifyPropertyChanged(BR.hh10);
    }

    @Bindable
    public String getHh11() {
        return hh11;
    }

    public void setHh11(String hh11) {
        this.hh11 = hh11;
        notifyPropertyChanged(BR.hh11);
    }

    @Bindable
    public String getHh12() {
        return hh12;
    }

    public void setHh12(String hh12) {
        this.hh12 = hh12;
        notifyPropertyChanged(BR.hh12);
    }

    @Bindable
    public String getHh13() {
        return hh13;
    }

    public void setHh13(String hh13) {
        this.hh13 = hh13;
        notifyPropertyChanged(BR.hh13);
    }

    @Bindable
    public String getHh14() {
        return hh14;
    }

    public void setHh14(String hh14) {
        this.hh14 = hh14;
        notifyPropertyChanged(BR.hh14);
    }

    @Bindable
    public String getHh15() {
        return hh15;
    }

    public void setHh15(String hh15) {
        this.hh15 = hh15;
        notifyPropertyChanged(BR.hh15);
    }
/*
    @Bindable
    public String getHh16() {
        return hh16;
    }

    public void setHh16(String hh16) {
        this.hh16 = hh16;
        notifyPropertyChanged(BR.hh16);
    }

    @Bindable
    public String getHh17() {
        return hh17;
    }

    public void setHh17(String hh17) {
        this.hh17 = hh17;
        notifyPropertyChanged(BR.hh17);
    }

    @Bindable
    public String getHh18() {
        return hh18;
    }

    public void setHh18(String hh18) {
        this.hh18 = hh18;
        notifyPropertyChanged(BR.hh18);
    }

    @Bindable
    public String getHh19() {
        return hh19;
    }

    public void setHh19(String hh19) {
        this.hh19 = hh19;
        notifyPropertyChanged(BR.hh19);
    }
*/
    @Bindable
    public String getHh20() {
        return hh20;
    }

    public void setHh20(String hh20) {
        this.hh20 = hh20;
        notifyPropertyChanged(BR.hh20);
    }

    @Bindable
    public String getHh21() {
        return hh21;
    }

    public void setHh21(String hh21) {
        this.hh21 = hh21;
        notifyPropertyChanged(BR.hh21);
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

    public String getsH1() {
        return sH1;
    }

    public void setsH1(String sH1) {
        this.sH1 = sH1;
    }

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getlC() {
        return lC;
    }

    public void setlC(String lC) {
        this.lC = lC;
    }


    public Form Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_SYNCED_DATE));
        this.endTime = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_END_TIME));
        this.startTime = cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_START_TIME));
        sAHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_SA)));
        sBHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_SB)));
        lCHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormTable.COLUMN_LC)));

        return this;
    }

    public void sAHydrate(String string) throws JSONException {
        Log.d(TAG, "sAHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.hh01 = json.getString("hh01");
            this.hh02 = json.getString("hh02");
            this.hh03 = json.getString("hh03");
            this.hh04 = json.getString("hh04");
            this.hh05 = json.getString("hh05");
            this.hh06 = json.getString("hh06");

        }
    }

    public void sBHydrate(String string) throws JSONException {
        Log.d(TAG, "sBHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.hh07 = json.getString("hh07");
            this.hh0717x = json.getString("hh0717x");
            this.hh08 = json.getString("hh08");
            this.hh09 = json.getString("hh09");
            this.hh10 = json.getString("hh10");

            this.hh20 = json.getString("hh20");

        }
    }
    public void lCHydrate(String string) throws JSONException {
        Log.d(TAG, "lCHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.hh11 = json.getString("hh11");
            this.hh12 = json.getString("hh12");
            this.hh13 = json.getString("hh13");
            this.hh14 = json.getString("hh14");
            this.hh15 = json.getString("hh15");
       /*     this.hh16 = json.getString("hh16");
            this.hh17 = json.getString("hh17");
            this.hh18 = json.getString("hh18");
            this.hh19 = json.getString("hh19");*/
            this.hh21 = json.getString("hh21");

        }
    }

    public String sAtoString() throws JSONException {
        Log.d(TAG, "cRtoString: ");
        JSONObject json = new JSONObject();

        json.put("hh01", hh01)
                .put("hh02", hh02)
                .put("hh03", hh03)
                .put("hh04", hh04)
                .put("hh05", hh05)
                .put("hh06", hh06);

        return json.toString();
    }


    public String sBtoString() throws JSONException {
        Log.d(TAG, "sBtoString: ");
        JSONObject json = new JSONObject();

        json.put("hh07", hh07)
                .put("hh08", hh08)
                .put("hh0717x", hh0717x)
                .put("hh09", hh09)
                .put("hh10", hh10)
        .put("hh20", hh20);
        return json.toString();
    }

    public String lCtoString() throws JSONException {
        Log.d(TAG, "lCtoString: ");
        JSONObject json = new JSONObject();

        json.put("hh11", hh11)
                .put("hh12", hh12)
                .put("hh13", hh13)
                .put("hh14", hh14)
                .put("hh15", hh15)
              /*  .put("hh16", hh16)
                .put("hh17", hh17)
                .put("hh18", hh18)
                .put("hh19", hh19)*/
                .put("hh21", hh21);
        return json.toString();
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormTable.COLUMN_ID, this.id);
        json.put(FormTable.COLUMN_UID, this.uid);
        json.put(FormTable.COLUMN_USERNAME, this.userName);
        json.put(FormTable.COLUMN_SYSDATE, this.sysDate);
        json.put(FormTable.COLUMN_DEVICEID, this.deviceId);
        json.put(FormTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(FormTable.COLUMN_ISTATUS, this.iStatus);
        json.put(FormTable.COLUMN_SYNCED, this.synced);
        json.put(FormTable.COLUMN_SYNCED_DATE, this.syncDate);
        json.put(FormTable.COLUMN_SA, new JSONObject(sAtoString()));
        json.put(FormTable.COLUMN_SB, new JSONObject(sBtoString()));
        json.put(FormTable.COLUMN_LC, new JSONObject(lCtoString()));
        json.put(FormTable.COLUMN_END_TIME, this.endTime);
        json.put(FormTable.COLUMN_START_TIME, this.startTime);

      /*  json.put(FormTable.COLUMN_SA, this.sA);
        json.put(FormTable.COLUMN_SB, this.sB);
        json.put(FormTable.COLUMN_LC, this.lC);
*/
/*        if (this.sA != null && !this.sA.equals("")) {
            json.put(FormTable.COLUMN_SA, new JSONObject(this.sA));
        }
        if (this.sB != null && !this.sB.equals("")) {
            json.put(FormTable.COLUMN_SB, new JSONObject(this.sB));
        }
        if (this.lC != null && !this.lC.equals("")) {
            json.put(FormTable.COLUMN_LC, new JSONObject(this.lC));
        }*/

        return json;

    }
}
