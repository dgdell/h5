FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://mkfs.ubifs-allow-output-file-creation-on-different-device.patch \
    file://no_deatach_check.patch \
    "

SRC_URI_append_dm800 = " file://disable-ubi.patch"
