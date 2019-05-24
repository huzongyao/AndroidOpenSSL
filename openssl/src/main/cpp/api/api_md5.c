//
// Created by huzongyao on 2019/5/23.
//

#include <openssl/md5.h>
#include <malloc.h>
#include <string.h>
#include "api_md5.h"

char *get_md5_string(const char *input, int length) {
    unsigned char digest[MD5_DIGEST_LENGTH];
    char *ret = malloc(MD5_DIGEST_LENGTH * 2 + 1);
    ret[MD5_DIGEST_LENGTH * 2] = '\0';
    MD5_CTX ctx;
    MD5_Init(&ctx);
    MD5_Update(&ctx, input, (size_t) length);
    MD5_Final(digest, &ctx);
    for (int i = 0; i < MD5_DIGEST_LENGTH; i++) {
        sprintf(&ret[2 * i], "%02X", digest[i]);
    }
    return ret;
}