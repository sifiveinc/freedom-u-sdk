PACKAGECONFIG:append = " dwarf libunwind manpages jvmti cap"

PACKAGES:remove = "${PN}-doc"
PACKAGECONFIG:remove = "jevents"

do_install:append() {
    rm -rf ${D}${datadir}
}
