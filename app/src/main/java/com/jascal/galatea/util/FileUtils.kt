package com.jascal.galatea.util

import android.util.Log
import com.jascal.galatea.GalateaApplication
import java.io.*

/**
 * @author ihave4cat
 * @describe TODO
 * @data on 2019/1/3 4:40 PM
 * @email jascal@163.com
 * */

class FileUtils {
    companion object {
        fun getCacheDir(): String {
            return GalateaApplication.getInstance().getRootDir() + "cache/"
        }

        fun readTextFromSDcard(fileName: String): String? {
            Log.d("cacheProxy", "read file $fileName")

            val file = File(fileName)
            if (!file.exists()) {
                return null
            }
            try {
                val fileInputStream = FileInputStream(file)
                val availableLength = fileInputStream.available()
                val buffer = ByteArray(availableLength)
                fileInputStream.read(buffer)
                fileInputStream.close()
                return String(buffer, charset("UTF-8"))
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }

        fun saveTextToSdcard(fileName: String, text: String): Boolean {
            Log.d("cacheProxy", "save to file $fileName")

            val file = File(fileName)
            val parentFile = file.parentFile
            if (!parentFile.exists()) {
                parentFile.mkdirs()
            }
            try {
                val bw = BufferedWriter(FileWriter(file))
                bw.write(text)
                bw.flush()
                bw.close()
            } catch (e: IOException) {
                e.printStackTrace()
                file.delete()
                return false
            }
            return true
        }
    }
}