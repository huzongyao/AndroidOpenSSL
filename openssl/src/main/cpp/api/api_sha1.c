//
// Created by huzongyao on 2019/5/24.
//

#include <openssl/sha.h>
#include <malloc.h>
#include "api_sha1.h"


char *get_sha1_string(const char *input, int length) {
    unsigned char digest[SHA_DIGEST_LENGTH];
    char *ret = malloc(SHA_DIGEST_LENGTH * 2 + 1);
    ret[SHA_DIGEST_LENGTH * 2] = '\0';
    SHA_CTX ctx;
    SHA1_Init(&ctx);
    SHA1_Update(&ctx, input, (size_t) length);
    SHA1_Final(digest, &ctx);
    for (int i = 0; i < SHA_DIGEST_LENGTH; i++) {
        sprintf(&ret[2 * i], "%02X", digest[i]);
    }
    return ret;
}