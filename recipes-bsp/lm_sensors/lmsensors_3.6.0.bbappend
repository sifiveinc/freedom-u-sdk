FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://0001-sensors.conf.default-add-tmp451.patch \
    "

SYSTEMD_AUTO_ENABLE:hifive-premier-p550 = "enable"
