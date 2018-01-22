package com.example.lalit.lalitdev;

/**
 * Created by Admin on 1/9/2018.
 * 1.click on build menu bar
 * 2.click on genrate sign apk
 * 3.set the key store path (where we sote the jks file)
 * 4.set the password of keysteot anf key store alist (both are same)
 * 5.put alise name
 * 6.fill all the option
 * 7.click on ok
 * 8.sellect the frist check box
 * 9.finish
 *
 * create the  SHA1 Key
 * C:\Program Files\Java\jdk1.8.0_151\bin>keytool -list -v -keystore D:\Software\la
    litdev.jks -alias lalitdev -storepass Test123$$ -keypass Test123$$

    create the HASH Key
 C:\Program Files\Java\jdk1.8.0_151\bin>keytool -exportcert -alias lalitdev -keys
 tore D:\Software\lalitdev.jks | C:\Openssl\bin\openssl sha1 -binary | C:\Openssl
 \bin\openssl base64
 Enter keystore password:  Test123$$


    //   Rest api url is
        https://www.androidhive.info/2014/01/how-to-create-rest-api-for-android-app-using-php-slim-and-mysql-day-12-2/
 */

public class CreateKeyStore {
}
