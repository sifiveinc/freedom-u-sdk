# Add support for modern AMD GPU (e.g. RX550 / POLARIS)
PACKAGECONFIG:append:riscv64:class-target = " gallium-llvm amd"
