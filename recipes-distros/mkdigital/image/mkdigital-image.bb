DESCRIPTION = "MK-Digital Image"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "MK-Digital"

require conf/license/license-gplv2.inc

PV = "${IMAGE_VERSION}"
PR = "r${DATETIME}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

IMAGE_INSTALL = "mkdigital-base"

export IMAGE_BASENAME = "mkdigital-image"
IMAGE_LINGUAS = ""

IMAGE_FEATURES += "package-management"

inherit image
