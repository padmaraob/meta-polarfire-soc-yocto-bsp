require recipes-kernel/linux/mpfs-linux-common.inc

LINUX_VERSION ?= "5.6.x"
KERNEL_VERSION_SANITY_SKIP="1"

BRANCH = "linux-5.6.y"
SRCREV = "v5.6.16"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;branch=${BRANCH} \
"

SRC_URI_append_icicle-kit-es = " \
    file://icicle-kit-es-a000-microchip.dts \
    file://0001-PFSoC-Icicle-kit-Adding-DTS-makefile.patch \
    file://0001-Microchip-Polarfire-SoC-Clock-Driver.patch \
    file://0002-PFSoC-MAC-Interface-auto-negotiation.patch \
 "
SRC_URI_append_icicle-kit-es-sd = " \
    file://icicle-kit-es-a000-microchip.dts \
    file://0001-PFSoC-Icicle-kit-Adding-DTS-makefile.patch \
    file://0001-Microchip-Polarfire-SoC-Clock-Driver.patch \
    file://0002-PFSoC-MAC-Interface-auto-negotiation.patch \
 "
 
SRC_URI_append_mpfs = " \
    file://0001-PCI-microsemi-Add-host-driver-for-Microsemi-PCIe-con.patch \
    file://0002-Microsemi-PCIe-expansion-board-DT-entry.patch \
    file://0004-SiFive-Unleashed-CPUFreq.patch \
    file://0007-Add-PWM-LEDs-D1-D2-D3-D4.patch \
    file://riscv-add-support-to-determine-no-of-L2-cache-way-enabled.patch \
"

SRC_URI_append_lc-mpfs = " \
    file://0004-SiFive-Unleashed-CPUFreq.patch \
    file://0007-Add-PWM-LEDs-D1-D2-D3-D4.patch \
    file://riscv-add-support-to-determine-no-of-L2-cache-way-enabled.patch \
"

do_configure_prepend_icicle-kit-es() {
    cp -f ${WORKDIR}/icicle-kit-es-a000-microchip.dts ${S}/arch/riscv/boot/dts/microchip
}
do_configure_prepend_icicle-kit-es-sd() {
    cp -f ${WORKDIR}/icicle-kit-es-a000-microchip.dts ${S}/arch/riscv/boot/dts/microchip
}

SRC_URI_append_icicle-kit-es = " file://defconfig"
SRC_URI_append_icicle-kit-es-sd = " file://defconfig"
SRC_URI_append_mpfs = " file://defconfig"
SRC_URI_append_lc-mpfs = " file://defconfig"

