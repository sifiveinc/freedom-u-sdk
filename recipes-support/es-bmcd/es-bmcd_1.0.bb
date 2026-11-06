DESCRIPTION = "daemon used for communication between MCU and SoC via UART"
LICENSE = "CLOSED"

inherit systemd

SYSTEMD_SERVICE:${PN} = "es-bmcd.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

SRC_URI = "file://es-bmc-daemon"
S = "${UNPACKDIR}/es-bmc-daemon"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
	install -m 0755 -D ${S}/es-bmcd -t ${D}${bindir}
	install -m 0755 -D ${S}/es-bmcd.service -t ${D}/${systemd_system_unitdir}
	install -m 0755 ${S}/es-bmcd.sh ${D}${bindir}
}

RDEPENDS:${PN} += "${VIRTUAL-RUNTIME_base-utils}"

COMPATIBLE_MACHINE = "(hifive-premier-p550)"
