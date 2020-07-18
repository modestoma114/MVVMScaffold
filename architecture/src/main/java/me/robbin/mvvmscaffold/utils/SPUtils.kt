package me.robbin.mvvmscaffold.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment


/**
 *
 * Create by Robbin at 2020/7/18
 */
@SuppressLint("ApplySharedPref")
class SPUtils {

    companion object {
        private val SP_UTILS_MAP: HashMap<String, SPUtils> = HashMap()
        /**
         * Return the single {@link SPUtils} instance
         * Create by Robbin at 2020/7/18
         */
        fun getInstance(spName: String, mode: Int): SPUtils {
            var name = spName
            if (name.isSpace())
                name = "spUtils"
            var spUtils = SP_UTILS_MAP[name]
            if (spUtils == null) {
                synchronized(SPUtils::class.java) {
                    spUtils = SP_UTILS_MAP[name]
                    if (spUtils == null) {
                        spUtils = SPUtils(spName, mode)
                        SP_UTILS_MAP[name] = spUtils!!
                    }
                }
            }
            return spUtils!!
        }
    }

    private var sp: SharedPreferences

    private constructor(spName: String, mode: Int) {
        sp = Utils.getAPP().getSharedPreferences(spName, mode)
    }

    private constructor(spName: String) : this(spName, Context.MODE_PRIVATE)

    /**
     * Put the string value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: String) {
        put(key, value, false)
    }

    /**
     * Put the string value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: String, isCommit: Boolean) {
        if (isCommit) {
            sp.edit().putString(key, value).commit()
        } else {
            sp.edit().putString(key, value).apply()
        }
    }

    /**
     * Return the string value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getString(key: String): String? {
        return getString(key, "")
    }

    /**
     * Return the string value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getString(key: String, default: String): String? {
        return sp.getString(key, default)
    }

    /**
     * Put the int value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Int) {
        put(key, value, false)
    }

    /**
     * Put the int value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Int, isCommit: Boolean) {
        if (isCommit) {
            sp.edit().putInt(key, value).commit()
        } else {
            sp.edit().putInt(key, value).apply()
        }
    }

    /**
     * Return the int value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getInt(key: String): Int? {
        return getInt(key, -1)
    }

    /**
     * Return the int value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getInt(key: String, default: Int): Int? {
        return sp.getInt(key, default)
    }

    /**
     * Put the long value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Long) {
        put(key, value, false)
    }

    /**
     * Put the long value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Long, isCommit: Boolean) {
        if (isCommit) {
            sp.edit().putLong(key, value).commit()
        } else {
            sp.edit().putLong(key, value).apply()
        }
    }

    /**
     * Return the long value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getLong(key: String): Long? {
        return getLong(key, -1L)
    }

    /**
     * Return the long value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getLong(key: String, default: Long): Long? {
        return sp.getLong(key, default)
    }

    /**
     * Put the float value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Float) {
        put(key, value, false)
    }

    /**
     * Put the float value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Float, isCommit: Boolean) {
        if (isCommit) {
            sp.edit().putFloat(key, value).commit()
        } else {
            sp.edit().putFloat(key, value).apply()
        }
    }

    /**
     * Return the float value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getFloat(key: String): Float? {
        return getFloat(key, -1F)
    }

    /**
     * Return the float value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getFloat(key: String, default: Float): Float? {
        return sp.getFloat(key, default)
    }

    /**
     * Put the boolean value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Boolean) {
        put(key, value, false)
    }

    /**
     * Put the boolean value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Boolean, isCommit: Boolean) {
        if (isCommit) {
            sp.edit().putBoolean(key, value).commit()
        } else {
            sp.edit().putBoolean(key, value).apply()
        }
    }

    /**
     * Return the boolean value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getBoolean(key: String): Boolean? {
        return getBoolean(key, false)
    }

    /**
     * Return the boolean value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getBoolean(key: String, default: Boolean): Boolean? {
        return sp.getBoolean(key, default)
    }

    /**
     * Put the set of string value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Set<String>) {
        put(key, value, false)
    }

    /**
     * Put the set of string value in sp
     * Create by Robbin at 2020/7/18
     */
    fun put(key: String, value: Set<String>, isCommit: Boolean) {
        if (isCommit) {
            sp.edit().putStringSet(key, value).commit()
        } else {
            sp.edit().putStringSet(key, value).apply()
        }
    }

    /**
     * Return the set of string value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getStringSet(key: String): Set<String>? {
        return getStringSet(key, emptySet())
    }

    /**
     * Return the set of string value in sp
     * Create by Robbin at 2020/7/18
     */
    fun getStringSet(key: String, default: Set<String>): Set<String>? {
        return sp.getStringSet(key, default)
    }

    /**
     * Return all values in sp
     * Create by Robbin at 2020/7/18
     */
    fun getAll(): Map<String, *> {
        return sp.all
    }

    /**
     * Return whether the sp contains the preference
     * Create by Robbin at 2020/7/18
     */
    fun contains(key: String): Boolean {
        return sp.contains(key)
    }

    /**
     * Remove the preference in sp
     * Create by Robbin at 2020/7/18
     */
    fun remove(key: String) {
        remove(key, false)
    }

    /**
     * Remove the preference in sp
     * Create by Robbin at 2020/7/18
     */
    fun remove(key: String, isCommit: Boolean) {
        if (isCommit) {
            sp.edit().remove(key).commit()
        } else {
            sp.edit().remove(key).apply()
        }
    }

    /**
     * Remove all preference in sp
     * Create by Robbin at 2020/7/18
     */
    fun clear() {
        clear(false)
    }

    /**
     * Remove all preference in sp
     * Create by Robbin at 2020/7/18
     */
    fun clear(isCommit: Boolean) {
        if (isCommit) {
            sp.edit().clear().commit()
        } else {
            sp.edit().clear().apply()
        }
    }

}

fun Activity.getSP(spName: String = "spUtils", mode: Int = Context.MODE_PRIVATE): SPUtils {
    return SPUtils.getInstance(spName, mode)
}

fun Fragment.getSP(spName: String = "spUtils", mode: Int = Context.MODE_PRIVATE): SPUtils {
    return SPUtils.getInstance(spName, mode)
}