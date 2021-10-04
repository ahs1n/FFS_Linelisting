package edu.aku.hassannaqvi.ffs_linelisting.models

import android.database.Cursor
import edu.aku.hassannaqvi.ffs_linelisting.contracts.TableContracts.UsersTable
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hassan.naqvi on 11/30/2016.
 */
class Users {
    var userID: Long = 0
    var userName: String = StringUtils.EMPTY
    var password: String = StringUtils.EMPTY
    var fullname: String = StringUtils.EMPTY

    constructor() {
        // Default Constructor
    }

    constructor(username: String, fullname: String) {
        userName = username
        this.fullname = fullname
    }

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Users {
        userName = jsonObject.getString(UsersTable.COLUMN_USERNAME)
        password = jsonObject.getString(UsersTable.COLUMN_PASSWORD)
        fullname = jsonObject.getString(UsersTable.COLUMN_FULLNAME)
        return this
    }

    fun hydrate(cursor: Cursor): Users {
        userID = cursor.getLong(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_ID))
        userName = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_USERNAME))
        password = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_PASSWORD))
        fullname = cursor.getString(cursor.getColumnIndexOrThrow(UsersTable.COLUMN_FULLNAME))
        return this
    }


}