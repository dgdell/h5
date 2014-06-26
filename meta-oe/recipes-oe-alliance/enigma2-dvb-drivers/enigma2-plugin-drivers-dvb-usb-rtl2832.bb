SUMMARY = "USB DVB driver for Realtek RTL2832 chipset"
PACKAGE_ARCH = "all"

require conf/license/license-gplv2.inc

DVBPROVIDER ?= "kernel"

RDEPENDS_${PN} = " \
    ${DVBPROVIDER}-module-dvb-usb-rtl2832 \
    ${DVBPROVIDER}-module-rtl2832 \
    ${DVBPROVIDER}-module-e4000 \
    ${DVBPROVIDER}-module-r820t \	
    firmware-dvb-usb-af9035-01 \
    firmware-dvb-usb-af9035-02 \
    firmware-dvb-usb-af9015 \	
    "

PV = "1.0"
PR = "r0"

ALLOW_EMPTY_${PN} = "1"