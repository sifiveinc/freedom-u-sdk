DESCRIPTION = "SuperTuxKart is a kart racing game featuring Tux and his friends"
HOMEPAGE = "https://supertuxkart.sourceforge.net"
SECTION = "x11/application"
LICENSE = "GPL-2.0-only & GPL-3.0-or-later & CC-BY-SA-3.0 & CC-BY-SA-4.0 & PD"
LIC_FILES_CHKSUM = "file://COPYING;md5=bcfdeb69518cfe348a07845ebba5c295"

DEPENDS = " \
    libogg \
    libvorbis \
    libxrandr \
    virtual/libgles2 \
    openal-soft \
    fribidi \
    curl \
    libpng \
    libjpeg-turbo \
    freetype \
    bluez5 \
    harfbuzz \
    libsdl2 \
"

inherit cmake pkgconfig gtk-icon-cache features_check

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = " \
    https://github.com/supertuxkart/stk-code/releases/download/${PV}/SuperTuxKart-${PV}-src.tar.gz \
"

SRC_URI[sha256sum] = "33cf8841e4ff4082d80b9248014295bbbea61d14683e86dff100e3ab8f7b27cb"

S = "${UNPACKDIR}/SuperTuxKart-${PV}-src"

# Give BSP the chance to override GL
SELECTGL ??= "-DUSE_GLES2=ON"

EXTRA_OECMAKE = " \
    ${SELECTGL} \
    -DBUILD_RECORDER=0 \
    -DNO_SHADERC=ON \
"
PACKAGECONFIG ??= " \
    ${@bb.utils.filter('DISTRO_FEATURES', 'wayland', d)} \
"
PACKAGECONFIG[wayland] = "-DENABLE_WAYLAND_DEVICE=ON,-DENABLE_WAYLAND_DEVICE=OFF,wayland"

FILES:${PN} += " \
    ${datadir}/icons \
    ${datadir}/metainfo \
"
