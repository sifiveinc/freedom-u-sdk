FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-gallivm-support-LLVM-21.patch"

# Add support for modern AMD GPU (e.g. RX550 / POLARIS)
PACKAGECONFIG:append:riscv64:class-target = " gallium-llvm vdpau amd"
