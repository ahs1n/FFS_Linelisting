package edu.aku.hassannaqvi.ffs_linelisting.database

import edu.aku.hassannaqvi.ffs_linelisting.contracts.TableContracts.*
import edu.aku.hassannaqvi.ffs_linelisting.core.MainApp.PROJECT_NAME

object CreateTable {

    const val DATABASE_NAME = "$PROJECT_NAME.db"
    const val DATABASE_COPY = "${PROJECT_NAME}_copy.db"
    const val DATABASE_VERSION = 1

    const val SQL_CREATE_FORM = ("CREATE TABLE "
            + FormTable.TABLE_NAME + "("
            + FormTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormTable.COLUMN_UID + " TEXT,"
            + FormTable.COLUMN_USERNAME + " TEXT,"
            + FormTable.COLUMN_SYSDATE + " TEXT,"
            + FormTable.COLUMN_START_TIME + " TEXT,"
            + FormTable.COLUMN_END_TIME + " TEXT,"
            + FormTable.COLUMN_ISTATUS + " TEXT,"
            + FormTable.COLUMN_DEVICEID + " TEXT,"
            + FormTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormTable.COLUMN_SYNCED + " TEXT,"
            + FormTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FormTable.COLUMN_APPVERSION + " TEXT,"
            + FormTable.COLUMN_SA + " TEXT,"
            + FormTable.COLUMN_SB + " TEXT,"
            + FormTable.COLUMN_LC + " TEXT"
            + " );"
            )

    const val SQL_CREATE_MWRA = ("CREATE TABLE "
            + MwraTable.TABLE_NAME + "("
            + MwraTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MwraTable.COLUMN_PROJECT_NAME + " TEXT,"
            + MwraTable.COLUMN_UID + " TEXT,"
            + MwraTable.COLUMN_UUID + " TEXT,"
            + MwraTable.COLUMN_USERNAME + " TEXT,"
            + MwraTable.COLUMN_SYSDATE + " TEXT,"
            + MwraTable.COLUMN_START_TIME + " TEXT,"
            + MwraTable.COLUMN_END_TIME + " TEXT,"
            + MwraTable.COLUMN_ISTATUS + " TEXT,"
            + MwraTable.COLUMN_DEVICEID + " TEXT,"
            + MwraTable.COLUMN_DEVICETAGID + " TEXT,"
            + MwraTable.COLUMN_SYNCED + " TEXT,"
            + MwraTable.COLUMN_SYNCED_DATE + " TEXT,"
            + MwraTable.COLUMN_APPVERSION + " TEXT,"
            + MwraTable.COLUMN_SMWRA + " TEXT"

            + " );"
            )

    const val SQL_CREATE_USERS = ("CREATE TABLE "
            + UsersTable.TABLE_NAME + "("
            + UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersTable.COLUMN_FULLNAME + " TEXT"
            + " );"
            )


    const val SQL_CREATE_VERSIONAPP = ("CREATE TABLE "
            + VersionTable.TABLE_NAME + " ("
            + VersionTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VersionTable.COLUMN_VERSION_CODE + " TEXT, "
            + VersionTable.COLUMN_VERSION_NAME + " TEXT, "
            + VersionTable.COLUMN_PATH_NAME + " TEXT "
            + ");"
            )

    const val SQL_CREATE_ENUMBLOCKS = ("CREATE TABLE "
            + EnumBlocksTable.TABLE_NAME + "("
            + EnumBlocksTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EnumBlocksTable.COLUMN_DISTRICT_NAME + " TEXT,"
            + EnumBlocksTable.COLUMN_TEHSIL_NAME + " TEXT,"
            + EnumBlocksTable.COLUMN_ENUM_BLOCK_CODE + " TEXT"
            + " );"
            )
}