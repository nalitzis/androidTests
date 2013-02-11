LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES := com_example_fibonaccinative_FibLib.c
LOCAL_MODULE := com_example_fibonaccinative_FibLib
include $(BUILD_SHARED_LIBRARY)