# To use NetworkManager instead
PACKAGECONFIG:remove = "networkd nss-resolve resolved"

# Temporary build issue workaround
PACKAGECONFIG:remove = "cgroupv2"

# Disable the osc-context for hifive-premier-p550
PACKAGECONFIG:remove:hifive-premier-p550 = "osc-context"
