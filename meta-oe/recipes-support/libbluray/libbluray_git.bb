SUMMARY  = "Library to access Blu-Ray disk"
SECTION = "misc"
HOMEPAGE = "http://videolan.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=435ed639f84d4585d93824e7da3d85da"

DEPENDS = "libxml2"

#SRC_URI = "git://git.videolan.org/libbluray.git;branch=master;protocol=git"
SRC_URI = "ftp://ftp.videolan.org/pub/videolan/libbluray/0.9.2/libbluray-0.9.2.tar.bz2"

#SRCREV="eefd7c6a192b5243ec9b25676944fcb87cfa3c2e"

SRC_URI[md5sum] = "836b2de16547776bf2726166cf796f13"
SRC_URI[sha256sum] = "efc994f42d2bce6af2ce69d05ba89dbbd88bcec7aca065de094fb3a7880ce7ea"

inherit gitpkgv autotools-brokensep pkgconfig
#PV = "v0.9.3+git${SRCPV}"
#PKGV = "v0.9.3+git${GITPKGV}"

PV = "v0.9.2"
PKGV = "v0.9.2"

#S="${WORKDIR}/git"
S="${WORKDIR}"

EXTRA_OECONF = " \
    --disable-bdjava \
    --disable-bdjava-jar \
    --disable-doxygen-doc \
    --disable-doxygen-dot \
    --disable-udf \
    --without-freetype \
    --without-fontconfig \
"

do_package_qa() {
}
