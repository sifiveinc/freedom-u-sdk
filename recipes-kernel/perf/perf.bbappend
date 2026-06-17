PACKAGECONFIG:append = " dwarf libunwind manpages jvmti cap"

PACKAGES:remove = "${PN}-doc"

# libbpf.c (copied from the kernel source tree) assigns the result of
# strstr()/strchr() to non-const pointers; with this glibc, those
# functions return 'const char *' when passed a 'const char *' argument,
# triggering -Werror=discarded-qualifiers. tools/lib/bpf/Makefile always
# builds with -Werror regardless of perf's own WERROR setting, so silence
# just this warning, the same way OE-core already does for a similar
# libbpf.c warning above.
TARGET_CC_ARCH:append = " -Wno-error=discarded-qualifiers"

do_install:append() {
    rm -rf ${D}${datadir}
}
