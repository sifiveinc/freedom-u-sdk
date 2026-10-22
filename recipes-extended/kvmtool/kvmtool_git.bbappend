ARCH = "${@oe.kernel.map_kernel_arch(d)}"
EXTRA_OEMAKE = 'V=1 ARCH=${ARCH} EXTRA_CFLAGS="-I${STAGING_KERNEL_BUILDDIR}/include/generated -I${STAGING_KERNEL_BUILDDIR}/arch/${ARCH}/include/generated"'
