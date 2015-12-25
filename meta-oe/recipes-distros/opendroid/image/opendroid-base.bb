SUMMARY = "Base packages require for image."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"

PV = "5.2"
PR = "r5"

inherit packagegroup

RDEPENDS_${PN} = "\
    oe-alliance-base \
    opendroid-enigma2 \
    opendroid-bootlogo \
    opendroid-spinner \
    ntfs-3g \
    hddtemp \
    packagegroup-base-nfs \
    busybox-cron \
    python-imaging \
    unrar \
    ofgwrite \
    packagegroup-base-smbfs-client \
    "
