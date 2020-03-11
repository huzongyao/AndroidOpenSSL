LOCAL_PATH := $(call my-dir)

# prebuilt libs
include $(CLEAR_VARS)
LOCAL_MODULE    := libcrypto
LOCAL_SRC_FILES := $(LOCAL_PATH)/openssl/jniLibs/$(TARGET_ARCH_ABI)/libcrypto.a
include $(PREBUILT_STATIC_LIBRARY)


# build shared libs
include $(CLEAR_VARS)
LOCAL_MODULE := openssl

LOCAL_C_INCLUDES := \
    $(LOCAL_PATH)/api \
    $(LOCAL_PATH)/openssl/include \

LOCAL_SRC_FILES := \
	$(wildcard $(LOCAL_PATH)/api/*.c) \
	$(wildcard $(LOCAL_PATH)/*.c) \

LOCAL_CFLAGS += -ffunction-sections -fdata-sections
LOCAL_CFLAGS += -fvisibility=hidden
LOCAL_LDFLAGS += -Wl,--gc-sections

LOCAL_STATIC_LIBRARIES := libcrypto
LOCAL_LDLIBS := -llog

include $(BUILD_SHARED_LIBRARY)