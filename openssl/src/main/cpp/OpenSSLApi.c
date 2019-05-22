//
// Created by huzongyao on 2019/5/22.
//
#include <jni.h>
#include <openssl/e_os2.h>
#include <malloc.h>
#include <api_md5.h>
#include <api_base64.h>
#include "ndk_log.h"

#define JNI_FUNC(x) Java_com_hzy_openssl_OpenSSLApi_##x


JNIEXPORT jstring JNICALL
JNI_FUNC(getVersionString)(JNIEnv *env, jclass type) {
    LOGI("Version Info: [%s]", OPENSSL_VERSION_TEXT);
    return (*env)->NewStringUTF(env, OPENSSL_VERSION_TEXT);
}

JNIEXPORT jstring JNICALL
JNI_FUNC(encodeBase64)(JNIEnv *env, jclass type, jbyteArray input_) {
    jbyte *input = (*env)->GetByteArrayElements(env, input_, NULL);
    jsize length = (*env)->GetArrayLength(env, input_);
    char *output = base64_encode((char *) input, length);
    LOGI("Base64[%s]", output);
    (*env)->ReleaseByteArrayElements(env, input_, input, 0);
    jstring ret = (*env)->NewStringUTF(env, output);
    free(output);
    return ret;
}

JNIEXPORT jstring JNICALL
JNI_FUNC(getMD5String)(JNIEnv *env, jclass type, jbyteArray input_) {
    jbyte *input = (*env)->GetByteArrayElements(env, input_, NULL);
    jsize length = (*env)->GetArrayLength(env, input_);
    char *output = get_md5_string((char *) input, length);
    LOGI("MD5[%s]", output);
    (*env)->ReleaseByteArrayElements(env, input_, input, 0);
    jstring ret = (*env)->NewStringUTF(env, output);
    free(output);
    return ret;
}