# Add support for modern AMD GPU (e.g. RX550 / POLARIS)
PACKAGECONFIG:append:riscv64:class-target = " gallium-llvm amd"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = "file://0001-gallivm-adapt-for-JITLink-in-LLVM-23.patch"
