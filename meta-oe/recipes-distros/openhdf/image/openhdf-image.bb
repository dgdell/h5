SUMMARY = "OpenHDF Image"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "OpenHDF Team"

require conf/license/license-gplv2.inc

PV = "${IMAGE_VERSION}"
<<<<<<< HEAD
PR = "r${DATETIME}"
PR[vardepsexclude] = "DATETIME"
=======
PR = "r${DATE}"
>>>>>>> 7433ddb3f7d5daa5ba9a39ffc7046b21fdeab63b
PACKAGE_ARCH = "${MACHINE_ARCH}"

IMAGE_INSTALL = "openhdf-base \
    ${@bb.utils.contains("MACHINE_FEATURES", "dvbc-only", "", "enigma2-plugin-settings-defaultsat", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "singlecore", "", \
    " \
    packagegroup-base-smbfs-client \
    packagegroup-base-smbfs-utils \
    packagegroup-base-smbfs-server \
    packagegroup-base-nfs \
    ", d)} \
    "

export IMAGE_BASENAME = "openhdf-image"
IMAGE_LINGUAS = ""

IMAGE_FEATURES += "package-management"

inherit image


rootfs_postprocess() {
    curdir=$PWD

    if [ -f /home/oa/5.5/meta-oe-alliance/meta-oe/recipes-distros/openhdf/custom/parser.sh ]; then
        cp /home/oa/5.5/meta-oe-alliance/meta-oe/recipes-distros/openhdf/custom/parser.sh .
        ./parser.sh ${MACHINEBUILD} ${IMAGE_ROOTFS}
        rm -rf parser.sh
    fi
    cd ${IMAGE_ROOTFS}

    # because we're so used to it
    ln -s opkg usr/bin/ipkg || true
    ln -s opkg-cl usr/bin/ipkg-cl || true
    ln -s usr/lib/enigma2/spinner usr/lib/enigma2/skin_default/spinner || true

    echo ${DEPLOY_DIR_IMAGE} > /tmp/DEPLOY_DIR_IMAGE
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_postprocess; "

export NFO = '${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfo'

do_generate_nfo() {
    VER=`grep Version: "${IMAGE_ROOTFS}/usr/lib/ipkg/info/enigma2.control" | cut -b 10-26`
    echo "Enigma2: ${VER}" > ${NFO}
    echo "Machine: ${MACHINE}" >> ${NFO}
    DATE=`date +%Y-%m-%d' '%H':'%M`
    echo "Date: ${DATE}" >> ${NFO}
    echo "Issuer: OpenHDF" >> ${NFO}
    echo "Link: ${DISTRO_FEED_URI}" >> ${NFO}
    if [ "${DESC}" != "" ]; then
        echo "Description: ${DESC}" >> ${NFO}
        echo "${DESC}" >> ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.desc
    fi
    MD5SUM=`md5sum ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfi | cut -b 1-32`
    echo "MD5: ${MD5SUM}" >> ${NFO}
}

addtask generate_nfo after do_rootfs

