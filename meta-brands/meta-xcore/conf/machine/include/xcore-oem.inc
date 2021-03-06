# We know about rtc
include conf/machine/include/build-extras.inc

BRAND_OEM = "xcore"

MACHINE_NAME = "\
${@bb.utils.contains('MACHINEBUILD', 'spycat', 'SpyCat' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'spycatmini', 'SpyCat' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'vp7358ci', '7358ci' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'bcm7358', '7358' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osmini', 'OS mini' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osminiplus', 'OS mini +' , '', d)}\
"

MACHINE_BRAND = "\
${@bb.utils.contains('MACHINEBUILD', 'spycat', 'SPYCAT' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'spycatmini', 'XCORE' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'vp7358ci', 'Sample2' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'bcm7358', 'Sample1' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osmini', 'Edision' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osminiplus', 'Edision' , '', d)}\
"

IMAGEDIR ?= "\
${@bb.utils.contains('MACHINEBUILD', 'spycat', 'spycat' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'spycatmini', 'spycatmini' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'vp7358ci', 'vp7358ci' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'bcm7358', 'bcm7358' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osmini', 'osmini' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osminiplus', 'osminiplus' , '', d)}\
"

MTD_KERNEL = "\
${@bb.utils.contains('MACHINEBUILD', 'spycat', 'mtd0' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'spycatmini', 'mtd0' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'vp7358ci', 'mtd2' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'bcm7358', 'mtd2' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osmini', 'mtd0' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osminiplus', 'mtd0' , '', d)}\
"

MTD_ROOTFS = "\
${@bb.utils.contains('MACHINEBUILD', 'spycat', 'mtd2' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'spycatmini', 'mtd2' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'vp7358ci', 'mtd3' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'bcm7358', 'mtd3' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osmini', 'mtd2' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osminiplus', 'mtd2' , '', d)}\
"

MACHINE_DRIVER = "\
${@bb.utils.contains('MACHINEBUILD', 'spycat', 'spycat' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'spycatmini', 'spycatmini' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'vp7358ci', 'vp7358ci' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'bcm7358', 'bcm7358' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osmini', 'osmini' , '', d)}\
${@bb.utils.contains('MACHINEBUILD', 'osminiplus', 'osminiplus' , '', d)}\
"

KERNEL_FILE = "kernel.bin"
ROOTFS_FILE = "rootfs.bin"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS = "\
    xcore-dvb-modules-${MACHINE_DRIVER} \
    "

DVBPROVIDER = "kernel"
DVBSKYPROVIDER = "kernel"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
    kernel-module-cdfs \
    "

MACHINE_EXTRA_RRECOMMENDS += " \
    gstreamer1.0-plugin-dvbmediasink \
    "

include conf/machine/include/autoload-filesystems.inc

<<<<<<< HEAD
DVBMEDIASINK_CONFIG = "--with-wma --with-wmv --with-pcm --with-dts --with-eac3 --with-vb6 --with-vb8 --with-spark \
    ${@bb.utils.contains('MACHINEBUILD', 'osminiplus', '--with-h265' , '', d)} \
=======
DVBMEDIASINK_CONFIG = "--with-wma --with-wmv --with-pcm --with-dts --with-eac3  \
<<<<<<< HEAD
    ${@base_contains('MACHINEBUILD', 'osminiplus', '--with-h265 --with-vb6 --with-vb8 --with-spark' , '', d)} \
>>>>>>> 3.4
=======
    ${@bb.utils.contains('MACHINEBUILD', 'osminiplus', '--with-h265 --with-vb6 --with-vb8 --with-spark' , '', d)} \
>>>>>>> 7433ddb3f7d5daa5ba9a39ffc7046b21fdeab63b
"

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el"

PREFERRED_PROVIDER_virtual/blindscan-dvbs = "xcore-blindscan-utils"
PREFERRED_PROVIDER_virtual/blindscan-dvbc = "xcore-blindscan-utils"

PREFERRED_PROVIDER_virtual/kernel = "linux-xcore"

KERNEL_OUTPUT = "${KERNEL_IMAGETYPE}"
KERNEL_CONSOLE = "ttyS0,115200n8"

IMAGE_FSTYPES ?= "ubi"

IMAGE_CMD_ubi_prepend = " \
    rm -rf ${IMAGE_ROOTFS}/boot/*; \
    rm -rf ${IMAGE_ROOTFS}/tmp/*; \
    "

MACHINE_FEATURES += "alsa 3dtv switchoff hdmicec bootsplash omb boxmodel feature1 feature2"

BOOTLOGO_FILENAME = "splash.bin"

require conf/machine/include/tune-mips32.inc

# add support for extra feeds
PACKAGE_ARCHS += " ${MACHINEBUILD}"