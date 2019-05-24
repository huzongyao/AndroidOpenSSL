//
// Created by huzongyao on 2019/5/22.
//

#include <openssl/ossl_typ.h>
#include <openssl/bio.h>
#include <openssl/evp.h>
#include <openssl/buffer.h>
#include "api_base64.h"

char *base64_encode(const char *input, int length) {
    BIO *b64, *bio;
    BUF_MEM *mem = NULL;
    if (!input || !length) {
        return "";
    }
    b64 = BIO_new(BIO_f_base64());
    BIO_set_flags(b64, BIO_FLAGS_BASE64_NO_NL);
    bio = BIO_new(BIO_s_mem());
    bio = BIO_push(b64, bio);
    BIO_write(bio, input, length);
    BIO_flush(bio);
    BIO_get_mem_ptr(bio, &mem);
    char *ret = malloc(mem->length + 1);
    memcpy(ret, mem->data, mem->length);
    ret[mem->length] = '\0';
    BIO_free_all(bio);
    return ret;
}